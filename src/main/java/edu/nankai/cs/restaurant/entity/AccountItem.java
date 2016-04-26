package edu.nankai.cs.restaurant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="nkcs_account_item")
public class AccountItem {
	private long itemId;
	private Date recordDate;
	private float profit;
	private float loss;
	@Id
	@SequenceGenerator(name="itemSeq", sequenceName="NKCS_ACCOUNT_ITEM_ID_SEQ")
	@GeneratedValue(generator="itemSeq", strategy=GenerationType.SEQUENCE)
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	@NotNull
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	@Min(0)
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	@Min(0)
	public float getLoss() {
		return loss;
	}
	public void setLoss(float loss) {
		this.loss = loss;
	}
	@Override
	public String toString() {
		return "AccountItem [itemId=" + itemId + ", recordDate=" + recordDate + ", profit=" + profit + ", loss=" + loss
				+ "]";
	}
}
