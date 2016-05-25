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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nkcs_menu")
public class Menu {
	private Long dishId;
	private String dishName;
	private Category category;
	private float price;
	private Date updatetime;
	private String image;
	private String description;
	private MultipartFile imageFile;
	
	@Id
	@SequenceGenerator(name="menuSeq", sequenceName="NKCS_MENU_ID_SEQ")
	@GeneratedValue(generator="menuSeq", strategy=GenerationType.SEQUENCE)
	public Long getDishId() {
		return dishId;
	}
	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}
	@NotBlank
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="category_id",
				referencedColumnName="categoryId",
				foreignKey=@ForeignKey(name="fk_menu_categoryid"))
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@DecimalMin("0")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Transient
	@JsonIgnore
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dishName == null) ? 0 : dishName.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((updatetime == null) ? 0 : updatetime.hashCode());
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
		Menu other = (Menu) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dishName == null) {
			if (other.dishName != null)
				return false;
		} else if (!dishName.equals(other.dishName))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (updatetime == null) {
			if (other.updatetime != null)
				return false;
		} else if (!updatetime.equals(other.updatetime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Menu [dishId=" + dishId + ", dishName=" + dishName + ", category=" + category + ", price=" + price
				+ ", updatetime=" + updatetime + ", image=" + image + ", description=" + description + "]";
	}
}
