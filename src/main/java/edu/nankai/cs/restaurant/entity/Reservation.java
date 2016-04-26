package edu.nankai.cs.restaurant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@javax.persistence.Table(name = "nkcs_reservation")
public class Reservation {
	private long reservationId;
	private Table table;
	private int peopleNumber;
	private String customerName;
	private String customerTelephone;
	
	private Date starttime;
	private Date endtime;
	
	@Id
	@SequenceGenerator(name="reservationSeq", sequenceName="NKCS_RESERVATION_ID_SEQ")
	@GeneratedValue(generator="reservationSeq", strategy=GenerationType.SEQUENCE)
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "table_id",referencedColumnName="tableId",
				foreignKey = @ForeignKey(name="fk_reservation_id")
				)
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	@Range(max=20, min=1)
	public int getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	@NotBlank
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@NotBlank
	public String getCustomerTelephone() {
		return customerTelephone;
	}
	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}
	@NotNull
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	@NotNull
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", table=" + table + ", peopleNumber=" + peopleNumber
				+ ", customerName=" + customerName + ", customerTelephone=" + customerTelephone + ", starttime="
				+ starttime + ", endtime=" + endtime + "]";
	}
	
}
