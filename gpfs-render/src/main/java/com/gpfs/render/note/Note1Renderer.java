package com.gpfs.render.note;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.assertj.core.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gpfs.gpfs.dto.GpfsInfo;
import com.gpfs.gpfs.dto.NoteInfo;
import com.gpfs.gpfs.dto.QuestionAnswerPairInfo;
import com.gpfs.render.schedule.ScheduleRenderer;

@Component
public class Note1Renderer extends NoteRenderer {

    private static final Logger LOG = LoggerFactory.getLogger(Note1Renderer.class);

    @Override
    public int getNoteIndex() {
        return 1;
    }

    public void render(XWPFDocument docx, NoteInfo note, List<ScheduleRenderer> scheduleRenderers, GpfsInfo gpfs) {
        LOG.debug("Rendering note 1!");
        note.getQuestions().stream()
            .filter(QuestionAnswerPairInfo::isActivated)
            .filter(qap -> !Strings.isNullOrEmpty(qap.getTemplate()))
            .forEach(qap -> {
                renderQuestion(docx, qap);
            });
    }

}
