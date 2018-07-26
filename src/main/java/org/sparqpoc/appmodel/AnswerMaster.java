package org.sparqpoc.appmodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ANSWERMASTER")
public class AnswerMaster {
	
	@Id
	@Column(name="ANSWERID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="answermaster_seq")
	@SequenceGenerator(name="answermaster_seq",sequenceName="answermaster_seq",allocationSize=1)
	private long answerid;
	
	@ManyToOne()
	@JoinColumn(name="FK_LOANID")
	private LoanMaster loanid;  
	
	@ManyToOne()
	@JoinColumn(name="FK_APPLICANTID")
	@JsonBackReference
	private LoanApplicantDetails applicantid;
	
	@ManyToOne()
	@JoinColumn(name="FK_QUESTIONID")
	private QuestionMaster questionid;
	
	@Column(name="ANSWER",length=300)
	private String answer;
	
	@Column(name="SECONDARYANSWER",length=300)
	private String secondaryanswer;
	
	

	public long getAnswerid() {
		return answerid;
	}

	public void setAnswerid(long answerid) {
		this.answerid = answerid;
	}

	public LoanMaster getLoanid() {
		return loanid;
	}

	public void setLoanid(LoanMaster loanid) {
		this.loanid = loanid;
	}

	public LoanApplicantDetails getApplicantid() {
		return applicantid;
	}

	public void setApplicantid(LoanApplicantDetails applicantid) {
		this.applicantid = applicantid;
	}

	public QuestionMaster getQuestionid() {
		return questionid;
	}

	public void setQuestionid(QuestionMaster questionid) {
		this.questionid = questionid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSecondaryanswer() {
		return secondaryanswer;
	}

	public void setSecondaryanswer(String secondaryanswer) {
		this.secondaryanswer = secondaryanswer;
	}
	
	

}
