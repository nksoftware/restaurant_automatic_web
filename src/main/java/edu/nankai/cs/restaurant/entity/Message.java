package edu.nankai.cs.restaurant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "NKCS_MESSAGE")
public class Message {
	private long messageId;
	private Date messageDate;
	private String messageType;
	private String description;
	
	@Id
	@SequenceGenerator(name="MessageSeq", sequenceName="NKCS_MESSAGE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MessageSeq")
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	@NotNull
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	@NotBlank
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	@NotBlank
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageDate=" + messageDate + ", messageType=" + messageType
				+ ", description=" + description + "]";
	}
	
	
}
