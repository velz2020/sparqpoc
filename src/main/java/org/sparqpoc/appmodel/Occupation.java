package org.sparqpoc.appmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="OCCUPATION")
public class Occupation {

	@Id
	@Column(name="OCCUPATIONID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="occupation_seq")
	@SequenceGenerator(name="occupation_seq",sequenceName="occupation_seq",allocationSize=1)
	private int occupationid;
	
	@Column(name="OCCUPATIONNAME",length=20,nullable=true,unique = true)
	@NotNull
	private String occupationname;
	
	@Column(name="OCCUPATIONDESCRIPTION",length=20)
	@NotNull
	private String occupationdescription;

	public int getOccupationid() {
		return occupationid;
	}

	public void setOccupationid(int occupationid) {
		this.occupationid = occupationid;
	}

	public String getOccupationname() {
		return occupationname;
	}

	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
	}

	public String getOccupationdescription() {
		return occupationdescription;
	}

	public void setOccupationdescription(String occupationdescription) {
		this.occupationdescription = occupationdescription;
	}
	
	
	
//	@OneToOne(mappedBy="occupation")
//	private Loan loan;
}
