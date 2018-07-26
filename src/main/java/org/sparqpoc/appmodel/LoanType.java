package org.sparqpoc.appmodel;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="LOANTYPE")
public class LoanType {
	
	@Id
	@Column(name="LOANTYPEID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="loantype_seq")
	@SequenceGenerator(name="loantype_seq",sequenceName="loantype_seq",allocationSize=1)
	private int loantypeid;
	
	@Column(name="LOANTYPENAME",length=20,unique=true)
	@NotNull
	private String loantypename;
	
	@Column(name="LOANTYPEDESCRIPTION",length=50)
	private String loantypedescription;

	public int getLoantypeid() {
		return loantypeid;
	}

	public void setLoantypeid(int loantypeid) {
		this.loantypeid = loantypeid;
	}

	public String getLoantypename() {
		return loantypename;
	}

	public void setLoantypename(String loantypename) {
		this.loantypename = loantypename;
	}

	public String getLoantypedescription() {
		return loantypedescription;
	}

	public void setLoantypedescription(String loantypedescription) {
		this.loantypedescription = loantypedescription;
	}
	
	

}
