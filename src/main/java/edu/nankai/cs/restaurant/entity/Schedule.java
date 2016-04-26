package edu.nankai.cs.restaurant.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@javax.persistence.Table(name="nkcs_schedule")
public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private PK pk;
	private String period;
	
	public PK getPk() {
		return pk;
	}
	public void setPk(PK pk) {
		this.pk = pk;
	}
	@NotBlank
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	@Embeddable
	public static class PK implements Serializable{
		private static final long serialVersionUID = 1L;
		@ManyToOne
		@JoinColumn(name="table_id",
					referencedColumnName="tableId",
					foreignKey=@ForeignKey(name="fk_schedule_tableid"))
		private Table table;
		@ManyToOne
		@JoinColumn(name="waiter_id",
					referencedColumnName="personnelId",
					foreignKey=@ForeignKey(name="fk_schedule_waiterid"))
		private Personnel waiter;
		private Date workDate;
		public Personnel getWaiter() {
			return waiter;
		}
		public void setWaiter(Personnel waiter) {
			this.waiter = waiter;
		}
		public Table getTable() {
			return table;
		}
		public void setTable(Table table) {
			this.table = table;
		}
		public Date getWorkDate() {
			return workDate;
		}
		public void setWorkDate(Date workDate) {
			this.workDate = workDate;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((table == null) ? 0 : table.hashCode());
			result = prime * result + ((waiter == null) ? 0 : waiter.hashCode());
			result = prime * result + ((workDate == null) ? 0 : workDate.hashCode());
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
			if (table == null) {
				if (other.table != null)
					return false;
			} else if (!table.equals(other.table))
				return false;
			if (waiter == null) {
				if (other.waiter != null)
					return false;
			} else if (!waiter.equals(other.waiter))
				return false;
			if (workDate == null) {
				if (other.workDate != null)
					return false;
			} else if (!workDate.equals(other.workDate))
				return false;
			return true;
		}
		public PK(Personnel waiter, Table table, Date workDate) {
			super();
			this.waiter = waiter;
			this.table = table;
			this.workDate = workDate;
		}
		public PK() {
			super();
		}
		@Override
		public String toString() {
			return "PK [table=" + table + ", waiter=" + waiter + ", workDate=" + workDate + "]";
		}
	}

	@Override
	public String toString() {
		return "Schedule [pk=" + pk + ", period=" + period + "]";
	}
}
