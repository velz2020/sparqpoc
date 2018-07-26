package org.sparqpoc.appmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="LOANCATAGORY")
public class LoanCatagory {

	@Id
	@Column(name="LOANCATAGORYID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="loantype_seq")
	@SequenceGenerator(name="loantype_seq",sequenceName="loantype_seq",allocationSize=1)
	private long loancatagoryid;
	
	@Column(name="LOANCATAGORYNAME",length=30,unique = true)
	@NotNull
	private String loancatagoryname;
	
	@Column(name="LOANCATAGORYDESCRIPTION",length=50)
	@NotNull
	private String loancatagorydescription;

	
	public long getLoancatagoryid() {
		return loancatagoryid;
	}

	public void setLoancatagoryid(long loancatagoryid) {
		this.loancatagoryid = loancatagoryid;
	}

	public String getLoancatagoryname() {
		return loancatagoryname;
	}

	public void setLoancatagoryname(String loancatagoryname) {
		this.loancatagoryname = loancatagoryname;
	}

	public String getLoancatagorydescription() {
		return loancatagorydescription;
	}

	public void setLoancatagorydescription(String loancatagorydescription) {
		this.loancatagorydescription = loancatagorydescription;
	}

	
	
	
}
