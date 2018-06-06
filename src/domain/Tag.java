package domain;


import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import database.PostDAO;
import database.TagDAO;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	
	private static TagDAO tagDAO = new TagDAO();

	
	public static List<Tag> getTagsPost(int postId) throws SQLException {
		return tagDAO.getTagsPost(postId);
	}
	public static List<Tag> getTags() throws SQLException {
		return tagDAO.getTags();
	}
	public static List<Tag> getSearchTags(String search) throws SQLException {
		return tagDAO.getSearchTags(search);
	}

	public Tag() {
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
