package org.sparqpoc.appmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="DOCUMENT")
public class Document {
	
	
	@Id
	@Column(name = "DOCUMENTID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="document_seq")
	@SequenceGenerator(name = "document_seq", sequenceName = "document_seq", allocationSize = 1)
	private long documentid;
	
	@ManyToOne()
	@JoinColumn(name="FK_LOANID")
	private LoanMaster loanid;
	
	@ManyToOne()
	@JoinColumn(name="FK_APPLICANTID")
	private LoanApplicantDetails applicantDetails;
	
	@Column(name="DOCUMENTTITLE")
	@NotNull
	@Size(min = 4, max = 50)
	private String documenttitle;
	
	@Column(name="DOCUMENTNAME")
	@NotNull
	@Size(min = 4, max = 50)
	private String documentname;

	public long getDocumentid() {
		return documentid;
	}

	public void setDocumentid(long documentid) {
		this.documentid = documentid;
	}

	public String getDocumenttitle() {
		return documenttitle;
	}

	public void setDocumenttitle(String documenttitle) {
		this.documenttitle = documenttitle;
	}

	public String getDocumentname() {
		return documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	public LoanMaster getLoanid() {
		return loanid;
	}

	public void setLoanid(LoanMaster loanid) {
		this.loanid = loanid;
	}

	public LoanApplicantDetails getApplicantDetails() {
		return applicantDetails;
	}

	public void setApplicantDetails(LoanApplicantDetails applicantDetails) {
		this.applicantDetails = applicantDetails;
	}
	
	
	
	
}
