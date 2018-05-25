package domain;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Post {
	@XmlAttribute
	private int id;
	@XmlAttribute
	private LocalDateTime creationDate;
	@XmlAttribute
	private LocalDateTime editionDate;
	@XmlAttribute
	private String	 text;
	@XmlAttribute
	private int responsePostId;
	

	public Post() {}
	
	public Post (int id, LocalDateTime creationDate, LocalDateTime editionDate, String text,int responsePostId) {
		this.id = id;
		this.creationDate = creationDate;
		this.editionDate = editionDate;
		this.text = text;
		this.responsePostId = responsePostId;
	}
	public Post (int id, LocalDateTime creationDate, LocalDateTime editionDate, String text) {
		this.id = id;
		this.creationDate = creationDate;
		this.editionDate = editionDate;
		this.text = text;
		this.responsePostId = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(LocalDateTime editionDate) {
		this.editionDate = editionDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getResponsePostId() {
		return responsePostId;
	}

	public void setResponsePostId(int responsePostId) {
		this.responsePostId = responsePostId;
	}
	
}
