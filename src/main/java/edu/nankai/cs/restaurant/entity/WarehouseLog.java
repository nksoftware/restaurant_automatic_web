package edu.nankai.cs.restaurant.entity;

import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="nkcs_warehouse_log")
public class WarehouseLog {

	private long logId;
	private String logName;
	private int quantity;
	private Date recordDate;
	private float unitPrice;
	
	@Id
	@SequenceGenerator(name="logSeq",sequenceName="NKCS_WAREHOUSE_LOG_ID_SEQ")
	@GeneratedValue(generator="logSeq", strategy=GenerationType.SEQUENCE)
	public long getLogId() {
		return logId;
	}
	public void setLogId(long logId) {
		this.logId = logId;
	}
	@NotBlank
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	@NotNull
	@Min(0)
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	@DecimalMin("0")
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "WarehouseLog [logId=" + logId + ", logName=" + logName + ", quantity=" + quantity + ", recordDate="
				+ recordDate + ", unitPrice=" + unitPrice + "]";
	}
}
