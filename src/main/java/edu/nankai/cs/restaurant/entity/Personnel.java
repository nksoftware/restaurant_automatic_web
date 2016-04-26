package edu.nankai.cs.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="nkcs_personnel")
public class Personnel implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long personnelId;
	private String personnelName;
	private String personnelJob;
	private float salary;
	private String status;
	
	@Id
	@SequenceGenerator(name="personnelSeq", sequenceName="NKCS_PERSONNEL_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="personnelSeq")
	public Long getPersonnelId() {
		return personnelId;
	}
	public void setPersonnelId(Long personnelId) {
		this.personnelId = personnelId;
	}
	@NotBlank
	public String getPersonnelName() {
		return personnelName;
	}
	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}
	@NotBlank
	public String getPersonnelJob() {
		return personnelJob;
	}
	public void setPersonnelJob(String personnelJob) {
		this.personnelJob = personnelJob;
	}
	@DecimalMin("0")
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Personnel [personnelId=" + personnelId + ", personnelName=" + personnelName + ", personnelJob="
				+ personnelJob + ", salary=" + salary + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (personnelId ^ (personnelId >>> 32));
		result = prime * result + ((personnelJob == null) ? 0 : personnelJob.hashCode());
		result = prime * result + ((personnelName == null) ? 0 : personnelName.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnel other = (Personnel) obj;
		if (personnelId != other.personnelId)
			return false;
		if (personnelJob == null) {
			if (other.personnelJob != null)
				return false;
		} else if (!personnelJob.equals(other.personnelJob))
			return false;
		if (personnelName == null) {
			if (other.personnelName != null)
				return false;
		} else if (!personnelName.equals(other.personnelName))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
