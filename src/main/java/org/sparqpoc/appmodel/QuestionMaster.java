package org.sparqpoc.appmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="QUESTIONMASTER")
public class QuestionMaster {
	
	@Id
	@Column(name="QUESTIONID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="questionmaster_seq")
	@SequenceGenerator(name="questionmaster_seq",sequenceName="questionmaster_seq",allocationSize=1)
	private long questionid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="QUESTIONLOANCATAGORY")
	private LoanCatagory questionloancatagory;
	
	@Column(name="QUESTION",length=500)
	@NotNull
	private String question;
	
	@Column(name="GUIDENCE",length=500)
	@NotNull
	private String guidence;

	public long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}

//	public LoanCatagory getQuestiontype() {
//		return questiontype;
//	}
//
//	public void setQuestiontype(LoanCatagory questiontype) {
//		this.questiontype = questiontype;
//	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getGuidence() {
		return guidence;
	}

	public void setGuidence(String guidence) {
		this.guidence = guidence;
	}
	
	

}
