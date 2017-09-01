package com.gpfs.gpfs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SortNatural;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "gpfs_note")
public class Note extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "note_idx", nullable = false)
	private int index;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "note_id")
	@SortNatural
	private List<QuestionAnswerPair> questions;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<QuestionAnswerPair> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionAnswerPair> questions) {
		this.questions = questions;
	}

}
