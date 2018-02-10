package com.gpfs.render.note;

import java.util.List;
import java.util.Optional;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.assertj.core.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.gpfs.core.dto.schedule.ScheduleInfo;
import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.dto.NoteInfo;
import com.gpfs.gpfs.dto.QuestionAnswerPairInfo;
import com.gpfs.render.schedule.ScheduleRenderer;

public abstract class NoteRenderer {

    private static final Logger LOG = LoggerFactory.getLogger(NoteRenderer.class);

    public abstract int getNoteIndex();

    protected Optional<ScheduleInfo> getSchedule(List<ScheduleInfo> schedules, int index) {
        return schedules.stream().filter(s -> s.getIndex() == index).findFirst();
    }

    protected void renderQuestion(XWPFDocument docx, QuestionAnswerPairInfo qap) {
        LOG.debug("Rendering question. note={}, question idx={}, template={}"
                , getNoteIndex(), qap.getQuestion().getSeries(), qap.getTemplate());
        XWPFParagraph bodyParagraph = null;
        if (qap.getQuestion().isNextParagraph()) {
            bodyParagraph = docx.createParagraph();
        } else {
            bodyParagraph = Iterables.getLast(docx.getParagraphs());
        }
        bodyParagraph.setAlignment(ParagraphAlignment.LEFT);
        //bodyParagraph.setBorderBottom(Borders.DOUBLE);
        XWPFRun r = bodyParagraph.createRun();
        r.setText(qap.getTemplate());
    }

    public void render(XWPFDocument docx, NoteInfo note, List<ScheduleRenderer> scheduleRenderers, GpfsInfo gpfs) {
        note.getQuestions().stream()
        .filter(QuestionAnswerPairInfo::isActivated)
        .filter(qap -> !Strings.isNullOrEmpty(qap.getTemplate()))
        .forEach(qap -> {
            renderQuestion(docx, qap);

            //Render schedules
            scheduleRenderers.stream()
                .filter(sr -> sr.getAfter() == qap.getQuestion().getSeries())
                .forEach(sr -> {
                    LOG.debug("Running schedule renderer! index={}", sr.getScheduleIndex());
                    Optional<ScheduleInfo> schedule = getSchedule(gpfs.getSchedules(), sr.getScheduleIndex());
                    if(schedule.isPresent()) {
                        LOG.debug("Rendering schedule! schedule={}", schedule.get());
                        sr.render(docx, schedule.get(), gpfs);
                    }
                });;
        });
    }

}
