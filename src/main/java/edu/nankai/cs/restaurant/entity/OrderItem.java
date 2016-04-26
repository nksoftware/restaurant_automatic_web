package edu.nankai.cs.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="nkcs_order_item")
public class OrderItem {
	@EmbeddedId
	private PK pk;
	private int quantity;
	private String status;
	private float eachPayment;
	
	public PK getPk() {
		return pk;
	}
	public void setPk(PK pk) {
		this.pk = pk;
	}
	
	@Min(0)
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@NotBlank
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public float getEachPayment() {
		return eachPayment;
	}
	public void setEachPayment(float eachPayment) {
		this.eachPayment = eachPayment;
	}


	@Embeddable
	public static class PK implements Serializable{
		private static final long serialVersionUID = 1L;
		@NotNull
		@ManyToOne
		@JoinColumn(name="order_id",
					referencedColumnName="orderId",
					foreignKey=@ForeignKey(name="fk_orderitem_orderid"))
		private Order order;
		@NotNull
		@ManyToOne
		@JoinColumn(name="dish_id",
					referencedColumnName="dishId",
					foreignKey=@ForeignKey(name="fk_orderitem_dishid"))
		private Menu menu;
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
		public Menu getMenu() {
			return menu;
		}
		public void setMenu(Menu menu) {
			this.menu = menu;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((menu == null) ? 0 : menu.hashCode());
			result = prime * result + ((order == null) ? 0 : order.hashCode());
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
			PK other = (PK) obj;
			if (menu == null) {
				if (other.menu != null)
					return false;
			} else if (!menu.equals(other.menu))
				return false;
			if (order == null) {
				if (other.order != null)
					return false;
			} else if (!order.equals(other.order))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "PK [order=" + order + ", menu=" + menu + "]";
		}
		public PK(Order order, Menu menu) {
			super();
			this.order = order;
			this.menu = menu;
		}
		public PK() {
			super();
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(eachPayment);
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + quantity;
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
		OrderItem other = (OrderItem) obj;
		if (Float.floatToIntBits(eachPayment) != Float.floatToIntBits(other.eachPayment))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (quantity != other.quantity)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderItem [pk=" + pk + ", quantity=" + quantity + ", status=" + status + ", eachPayment=" + eachPayment
				+ "]";
	}
}
