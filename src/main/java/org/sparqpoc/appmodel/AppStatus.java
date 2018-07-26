package org.sparqpoc.appmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="APPSTATUS")
public class AppStatus {
	
	@Id
	@Column(name="STATUSID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="status_seq")
	@SequenceGenerator(name="status_seq",sequenceName="status_seq",allocationSize=1)
	private long statusid;
	
	@Column(name="STATUSTYPE",length = 20)
	@NotNull
	@Size(min=5,max=10)
	private String statustype;
	
	@Column(name="STATUSNAME",length = 20)
	@NotNull
	@Size(min=5,max=10)
	private String statusname;

	public long getStatusid() {
		return statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public String getStatustype() {
		return statustype;
	}

	public void setStatustype(String statustype) {
		this.statustype = statustype;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	
	

}
