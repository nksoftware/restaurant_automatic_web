package edu.nankai.cs.restaurant.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
@Entity
@javax.persistence.Table(name="nkcs_order")
public class Order {
	private long orderId;
	private Date paidDate;
	private float payment;
	private String status;
	private Date waitStarttime;
	private Date waitEndtime;
	private Table table;
	private List<OrderItem> orderItems;
	
	@Id
	@SequenceGenerator(name="orderSeq", sequenceName="NKCS_ORDER_ID_SEQ")
	@GeneratedValue(generator="orderSeq", strategy=GenerationType.SEQUENCE)
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getWaitStarttime() {
		return waitStarttime;
	}
	public void setWaitStarttime(Date waitStarttime) {
		this.waitStarttime = waitStarttime;
	}
	public Date getWaitEndtime() {
		return waitEndtime;
	}
	public void setWaitEndtime(Date waitEndtime) {
		this.waitEndtime = waitEndtime;
	}
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(name="table_id",
				referencedColumnName="tableId",
				foreignKey=@ForeignKey(name="fk_order_tableid"))
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	@OneToMany(mappedBy="pk.order", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((paidDate == null) ? 0 : paidDate.hashCode());
		result = prime * result + Float.floatToIntBits(payment);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((table == null) ? 0 : table.hashCode());
		result = prime * result + ((waitEndtime == null) ? 0 : waitEndtime.hashCode());
		result = prime * result + ((waitStarttime == null) ? 0 : waitStarttime.hashCode());
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
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		if (paidDate == null) {
			if (other.paidDate != null)
				return false;
		} else if (!paidDate.equals(other.paidDate))
			return false;
		if (Float.floatToIntBits(payment) != Float.floatToIntBits(other.payment))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;
		if (waitEndtime == null) {
			if (other.waitEndtime != null)
				return false;
		} else if (!waitEndtime.equals(other.waitEndtime))
			return false;
		if (waitStarttime == null) {
			if (other.waitStarttime != null)
				return false;
		} else if (!waitStarttime.equals(other.waitStarttime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", paidDate=" + paidDate + ", payment=" + payment + ", status=" + status
				+ ", waitStarttime=" + waitStarttime + ", waitEndtime=" + waitEndtime + ", table=" + table + "]";
	}
}
