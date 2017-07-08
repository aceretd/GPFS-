package com.gpfs.question;

import java.util.List;

import javax.persistence.Entity;

@Entity(name = "table_entry_question")
public class TableEntryQuestionTemplate extends QuestionTemplate {

	private List<TableEntryTemplate> entries;

}
