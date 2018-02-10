package com.gpfs.render.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.dto.NoteInfo;
import com.gpfs.gpfs.service.GpfsService;
import com.gpfs.render.note.NoteRenderer;
import com.gpfs.render.schedule.ScheduleRenderer;
import com.gpfs.render.service.GpfsRenderService;

@Service
public class GpfsRenderServiceImpl implements GpfsRenderService {

    private static final Logger LOG = LoggerFactory.getLogger(GpfsRenderServiceImpl.class);
    private static final int ALL_NOTES = -1;

    @Autowired
    private GpfsService service;

    @Autowired
    @Qualifier("genericRenderer")
    private NoteRenderer genericRenderer;

    @Autowired
    private List<NoteRenderer> specialRenderers;

    @Autowired
    private List<ScheduleRenderer> scheduleRenderers;

    @Override
    public void preview(Long companyId, int year, int note, HttpServletResponse response) throws Exception {
        GpfsInfo gpfs = service.findInfoByCompanyIdAndYear(companyId, year);
        if (null == gpfs) {
            LOG.error("No GPFS found with companyId={} and year={}!", companyId, year);
            return;
        }
        response.setHeader("Content-disposition", "attachment; filename=GPFS.pdf");

        LOG.debug("Trying to render document as PDF.");
        try {
            XWPFDocument docx = render(gpfs, note);
            PdfConverter.getInstance().convert(docx, response.getOutputStream(), PdfOptions.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void preview(Long companyId, int year, HttpServletResponse response) throws Exception {
        preview(companyId, year, ALL_NOTES, response);
    }

    @Override
    public void render(Long companyId, int year, int noteIndex, HttpServletResponse response) throws Exception {
        GpfsInfo gpfs = service.findInfoByCompanyIdAndYear(companyId, year);
        if (null == gpfs) {
            LOG.error("No GPFS found with companyId={} and year={}!", companyId, year);
            return;
        }
        XWPFDocument document = render(gpfs, noteIndex);
        response.setHeader("Content-disposition", "attachment; filename=GPFS.docx");
        if (null != document) {
            document.write(response.getOutputStream());
        }
    }

    @Override
    public void render(Long companyId, int year, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        GpfsInfo gpfs = service.findInfoByCompanyIdAndYear(companyId, year);
        if (null == gpfs) {
            LOG.error("No GPFS found with companyId={} and year={}!", companyId, year);
            return;
        }
        XWPFDocument document = render(gpfs, ALL_NOTES);
        response.setHeader("Content-disposition", "attachment; filename=GPFS.docx");
        if (null != document) {
            document.write(response.getOutputStream());
        }
    }

    public XWPFDocument render(GpfsInfo gpfs, int noteToRender) throws IOException, XmlException  {
        XWPFDocument docx = new XWPFDocument(new ClassPathResource("template.docx").getInputStream());
        //		CTSectPr sectPr = docx.getDocument().getBody().getSectPr();//.addNewSectPr();
        //		XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);

        //write header content
        //		CTP ctpHeader = CTP.Factory.newInstance();
        //		CTR ctrHeader = ctpHeader.getRArray(0);//.addNewR();
        //		CTText ctHeader = ctrHeader.getTArray(0);//.addNewT();
        //		String headerText = "This is header";
        //		ctHeader.setStringValue(headerText);	
        //		XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, docx);
        //		XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        //		parsHeader[0] = headerParagraph;
        //		policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);

        //write footer content
        //		CTP ctpFooter = CTP.Factory.newInstance();
        //		CTR ctrFooter = ctpFooter.addNewR();
        //		CTText ctFooter = ctrFooter.addNewT();
        //		String footerText = "This is footer";
        //		ctFooter.setStringValue(footerText);	
        //		XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, docx);
        //		XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        //		parsFooter[0] = footerParagraph;
        //		policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);

        //write body content
        XWPFParagraph bodyParagraph = docx.createParagraph();
        bodyParagraph.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun companyName = bodyParagraph.createRun();
        companyName.setBold(true);
        companyName.setFontSize(13);
        companyName.setText(gpfs.getCompany().getName());

        bodyParagraph.setBorderBottom(Borders.DOUBLE);

        List<NoteInfo> notesToRender = noteToRender == ALL_NOTES ? gpfs.getNotes()
                : gpfs.getNotes().stream().filter(n -> n.getIndex() == noteToRender).collect(Collectors.toList());

        LOG.debug("Notes to render={}", notesToRender);
        for (int i = 0; i < notesToRender.size(); i++) {
            NoteInfo note = notesToRender.get(i);
            Optional<NoteRenderer> specialRenderer = specialRenderers.stream().filter(r -> r.getNoteIndex() == note.getIndex()).findFirst();
            if (specialRenderer.isPresent()) {
                LOG.debug("Special renderer invoked for note. index={}", note.getIndex());
                specialRenderer.get().render(docx, note, scheduleRenderers, gpfs);
            } else {
                LOG.debug("Generic renderer invoked for note. index={}", note.getIndex());
                genericRenderer.render(docx, note, scheduleRenderers, gpfs);
            }
        }

        return docx;
    }

}
