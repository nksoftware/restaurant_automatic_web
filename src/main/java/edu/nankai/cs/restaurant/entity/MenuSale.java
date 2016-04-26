package edu.nankai.cs.restaurant.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="nkcs_menu_sale")
public class MenuSale {
	@EmbeddedId
	private PK pk;
	private int saleQuantity;
	
	public PK getPk() {
		return pk;
	}
	public void setPk(PK pk) {
		this.pk = pk;
	}
	@Min(0)
	public int getSaleQuantity() {
		return saleQuantity;
	}
	public void setSaleQuantity(int saleQuantity) {
		this.saleQuantity = saleQuantity;
	}
	
	@Embeddable
	public static class PK implements Serializable{
		private static final long serialVersionUID = 1L;
		@NotNull
		@ManyToOne(optional=false)
		@JoinColumn(name="dish_id",
					referencedColumnName="dishId",
					foreignKey=@ForeignKey(name="fk_menu_sale_id"))
		private Menu menu;
		@NotNull
		private Date saleDate;
		public Menu getMenu() {
			return menu;
		}
		public void setMenu(Menu menu) {
			this.menu = menu;
		}
		public Date getSaleDate() {
			return saleDate;
		}
		public void setSaleDate(Date saleDate) {
			this.saleDate = saleDate;
		}
		public PK(Menu menu, Date saleDate) {
			super();
			this.menu = menu;
			this.saleDate = saleDate;
		}
		public PK() {
			super();
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((menu == null) ? 0 : menu.hashCode());
			result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
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
			if (saleDate == null) {
				if (other.saleDate != null)
					return false;
			} else if (!saleDate.equals(other.saleDate))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "PK [menu=" + menu + ", saleDate=" + saleDate + "]";
		}
	}
	@Override
	public String toString() {
		return "MenuSale [pk=" + pk + ", saleQuantity=" + saleQuantity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + saleQuantity;
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
		MenuSale other = (MenuSale) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (saleQuantity != other.saleQuantity)
			return false;
		return true;
	}
}
