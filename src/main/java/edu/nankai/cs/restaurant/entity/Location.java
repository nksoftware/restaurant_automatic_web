package edu.nankai.cs.restaurant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;


@Entity
@javax.persistence.Table(name="nkcs_location")
public class Location implements Serializable{
	private static final long serialVersionUID = 1L;
	private long locationId;
	private Table table;
	private int floor;
	private float x;
	private float y;
	
	@Id
	@SequenceGenerator(name="locationSeq", sequenceName="NKCS_LOCATION_ID_SEQ")
	@GeneratedValue(generator="locationSeq", strategy=GenerationType.SEQUENCE)
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="table_id",
				foreignKey=@ForeignKey(name="fk_location_id"),
				unique=true)
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	@Min(0)
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	@DecimalMin("0")
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	@DecimalMin("0")
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floor;
		result = prime * result + (int) (locationId ^ (locationId >>> 32));
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
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
		Location other = (Location) obj;
		if (floor != other.floor)
			return false;
		if (locationId != other.locationId)
			return false;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", floor=" + floor + ", x=" + x + ", y=" + y + "]";
	}
}
