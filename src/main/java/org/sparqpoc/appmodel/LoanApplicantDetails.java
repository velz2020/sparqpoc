package org.sparqpoc.appmodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="LOANAPPLICANTDETAILS")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="loanapplicantid")
public class LoanApplicantDetails {
	
	@Id
	@Column(name="LOANAPPLICANTID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="loanapplicant_seq")
	@SequenceGenerator(name="loanapplicant_seq",sequenceName="loanapplicant_seq",allocationSize=1)
	private long loanapplicantid;
	
	@ManyToOne()
	@JoinColumn(name="FK_LOANID",referencedColumnName="LOANID")
	//@JsonManagedReference
	//@JsonIgnore
	private LoanMaster loanid;
	
//	@Column(name = "FK_LOANID")
//	@NotNull
//	private int fkloanid;
	
	@Column(name = "FIRSTNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)	 	
	private String firstname;
 	
 	@Column(name = "LASTNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)	 
	private String lastname;
 	
 	@Column(name = "DOB")
    @NotNull 
    @Temporal(TemporalType.TIMESTAMP)
	private Date dob;
 	
 	@Column(name = "FATHERNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
 	private String fathersname;
 	
 	@Column(name = "PAN", length = 20,unique = true)
    @NotNull
    @Size(min = 10, max = 20)
 	private String pan;
 	
 	@Column(name = "AADHARNO", length = 15,unique = true)
    @NotNull
    @Size(min = 12, max = 12)
 	private String aadharno;
 	
 	@Column(name = "PERMANENTADDRESS", length = 200)
    @NotNull
    @Size(min = 10, max = 200)
 	private String permanentaddress;
 	
 	@Column(name = "TEMPADDRESS", length = 200)
    @NotNull
    @Size(min = 10, max = 200)
 	private String tempaddress;
 	
 	@Column(name = "EMAIL", length = 50,unique = true)
    @NotNull
    @Size(min = 4, max = 50)
	private String email;
 	
 	@Column(name = "MOBILENO", length = 15,unique = true)
    @NotNull
    @Size(min = 10, max = 15)
	private String mobileno;
 	
 	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OCCUPATIONTYPE")
	private Occupation occupation;
 	
 	@Column(name = "MONTHLYSALARY", length = 8)
    @NotNull
	private int monthlysalary = 0;

	public long getLoanapplicantid() {
		return loanapplicantid;
	}

	public void setLoanapplicantid(long loanapplicantid) {
		this.loanapplicantid = loanapplicantid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(String dob) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentdate = dateFormat.parse(dob);
		this.dob = currentdate;
	}

	public String getFathersname() {
		return fathersname;
	}

	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public String getPermanentaddress() {
		return permanentaddress;
	}

	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}

	public String getTempaddress() {
		return tempaddress;
	}

	public void setTempaddress(String tempaddress) {
		this.tempaddress = tempaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public int getMonthlysalary() {
		return monthlysalary;
	}

	public void setMonthlysalary(int monthlysalary) {
		this.monthlysalary = monthlysalary;
	}

//	public int getFkloanid() {
//		return fkloanid;
//	}
//
//	public void setFkloanid(int fkloanid) {
//		this.fkloanid = fkloanid;
//	}
	
	
	//@JsonIgnore
	public LoanMaster getLoanid() {
		return loanid;
	}
	
	
	public void setLoanid(LoanMaster loanid) {
		this.loanid = loanid;
	}
 	
 	
 	

}
