package edu.nankai.cs.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="nkcs_warehouse")
public class Warehouse {

	private long warehouseItemId;
	private String warehouseItemName;
	private int quantity;
	
	@Id
	@SequenceGenerator(name="itemSeq", sequenceName="NKCS_WAREHOUSE_ID_SEQ")
	@GeneratedValue(generator="itemSeq", strategy=GenerationType.SEQUENCE)
	public long getWarehouseItemId() {
		return warehouseItemId;
	}
	public void setWarehouseItemId(long warehouseItemId) {
		this.warehouseItemId = warehouseItemId;
	}
	@NotBlank
	public String getWarehouseItemName() {
		return warehouseItemName;
	}
	public void setWarehouseItemName(String warehouseItemName) {
		this.warehouseItemName = warehouseItemName;
	}
	@NotNull
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Warehouse [warehouseItemId=" + warehouseItemId + ", warehouseItemName=" + warehouseItemName
				+ ", quantity=" + quantity + "]";
	}
}
