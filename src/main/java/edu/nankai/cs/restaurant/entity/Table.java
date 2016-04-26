package edu.nankai.cs.restaurant.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@javax.persistence.Table(name = "nkcs_table")
public class Table implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long tableId;
	private String status;
	private int peopleNumber;
	private Location location;
	private List<Reservation> reservations;
	
	@Id
	@SequenceGenerator(name="tableSeq", sequenceName="NKCS_TABLE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tableSeq")
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	@NotBlank
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Range(min=1, max=20)
	public int getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	@OneToOne(mappedBy="table", fetch=FetchType.LAZY, optional=false, orphanRemoval=true, cascade=CascadeType.ALL)
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@OneToMany(mappedBy="table", orphanRemoval=false, fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + peopleNumber;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tableId == null) ? 0 : tableId.hashCode());
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
		Table other = (Table) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (peopleNumber != other.peopleNumber)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tableId == null) {
			if (other.tableId != null)
				return false;
		} else if (!tableId.equals(other.tableId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", status=" + status + ", peopleNumber=" + peopleNumber + ", location="
				+ location + "]";
	}
	
}
