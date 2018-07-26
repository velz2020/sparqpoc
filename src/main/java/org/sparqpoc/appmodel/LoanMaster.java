package org.sparqpoc.appmodel;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "LOANMASTER")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class LoanMaster {
	
	 	@Id
	    @Column(name = "LOANID")
	    @GeneratedValue(strategy = GenerationType.AUTO, generator = "loan_seq")
	    @SequenceGenerator(name = "loan_seq", sequenceName = "loan_seq", allocationSize = 1)
		private Long id;
	 	
	 	@OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="LOANCATAGORY")
	 	private LoanCatagory loancatagory;
	 	
	 	@OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="LOANTYPE")
	 	private LoanType loantype;
	 	 	
	 	@Column(name = "LOANAMOUNT", length = 15)
	    @NotNull
	    @Size(min = 5, max = 15)
		private String loanamount;
	 	
	    @OneToOne(fetch=FetchType.EAGER)
	    @JoinColumn(name="LOANSTATUS")
		private AppStatus appStatus;
	 	
	 	@Column(name = "BUSINESSTYPE", length = 50)
	    @Size(min = 5, max = 50)
		private String businesstype = null;
	 	
	 	@Column(name = "BUSINESSNAME", length = 50)
	    @Size(min = 5, max = 50)
		private String businessname = null;
	 	
	 	@Column(name = "BUSINESSLOCATION", length = 20)
	    @Size(min = 5, max = 20)
		private String businesslocation = null;
	 	
	 	@Column(name = "BUSINESSADDRESS", length = 50)
	    @Size(min = 5, max = 50)
		private String businessaddress = null;
	 	
	 	@Column(name = "LASTTHREEMONTHSTURNOVER", length = 20)
	    @Size(min = 5, max = 20)
		private String lastthreemonnthsturnover = null;
	 	
	 	@Column(name="CREATEDDATE")
	 	@NotNull
	 	private Date createddate = new Date();
	 	
	 	@OneToMany(mappedBy="loanid")
	 	//@JsonBackReference
	 	//@JsonIgnore back yes
	 	//@JsonProperty("listOfApplicants")
	 	private List<LoanApplicantDetails> listOfApplicants;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	
		public String getLoanamount() {
			return loanamount;
		}

		public void setLoanamount(String loanamount) {
			this.loanamount = loanamount;
		}

		public AppStatus getAppStatus() {
			return appStatus;
		}

		public void setAppStatus(AppStatus appStatus) {
			this.appStatus = appStatus;
		}

		public String getBusinesstype() {
			return businesstype;
		}

		public void setBusinesstype(String businesstype) {
			this.businesstype = businesstype;
		}

		public String getBusinessname() {
			return businessname;
		}

		public void setBusinessname(String businessname) {
			this.businessname = businessname;
		}

		public String getBusinesslocation() {
			return businesslocation;
		}

		public void setBusinesslocation(String businesslocation) {
			this.businesslocation = businesslocation;
		}

		public String getBusinessaddress() {
			return businessaddress;
		}

		public void setBusinessaddress(String businessaddress) {
			this.businessaddress = businessaddress;
		}

		public String getLastthreemonnthsturnover() {
			return lastthreemonnthsturnover;
		}

		public void setLastthreemonnthsturnover(String lastthreemonnthsturnover) {
			this.lastthreemonnthsturnover = lastthreemonnthsturnover;
		}
					
		public Date getCreateddate() {
			return createddate;
		}

		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}

		public LoanCatagory getLoancatagory() {
			return loancatagory;
		}

		public void setLoancatagory(LoanCatagory loancatagory) {
			this.loancatagory = loancatagory;
		}

		public LoanType getLoantype() {
			return loantype;
		}

		public void setLoantype(LoanType loantype) {
			this.loantype = loantype;
		}
		
		//@JsonIgnore
		public List<LoanApplicantDetails> getListOfApplicants() {
			System.out.println("get LIST");
			return listOfApplicants;
		}
        
		
		/*public List<LoanApplicantDetails> getListOfApplicantsForService() {
			System.out.println("get LIST");
			return listOfApplicants;
		}*/
		
		public void setListOfApplicants(List<LoanApplicantDetails> listOfApplicants) {
			System.out.println("SET LIST");
			this.listOfApplicants = listOfApplicants;
			//System.exit(0);
		}
}
