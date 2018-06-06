package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import database.PostDAO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Post {
	@XmlAttribute
	private int id;
	@XmlAttribute
	private Date creationDate;
	@XmlAttribute
	private boolean edited;
	@XmlAttribute
	private Date editionDate;
	@XmlAttribute
	private String	 text;
	@XmlAttribute
	private List<Tag> tags;
	@XmlAttribute
	private User user;
	

	/*
	@XmlAttribute
	private int responsePostId;
*/
	public Post() {
		this.tags=new ArrayList<Tag>();
	}
	
	/*public Post (int id, LocalDateTime creationDate, LocalDateTime editionDate, String text,int responsePostId) {
		this.id = id;
		this.creationDate = creationDate;
		this.editionDate = editionDate;
		this.text = text;
		this.responsePostId = responsePostId;
	}*/
	public Post (int id, Date creationDate, Date editionDate, String text) {
		this.id = id;
		this.creationDate = creationDate;
		this.editionDate = editionDate;
		this.text = text;
		this.tags=new ArrayList<Tag>();
		//this.responsePostId = 0;
	}

	private static PostDAO postDAO = new PostDAO();

	public static void addPost(int userId, String text, List<Integer> tagIds) throws SQLException {
		postDAO.addPost(userId,text,tagIds);
	}
	public static void removePost(int id) throws SQLException {
		postDAO.removePost(id);
	}
	public static void updatePost(int id,String text) throws SQLException {
		postDAO.updatePost(id,text);
	}

	public static List<Post> getPosts() throws SQLException {
		return postDAO.getPosts();
	}
	public static List<Post> getPostsTag(int tagId) throws SQLException{
		return postDAO.getPostsTag(tagId);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
/*
	public int getResponsePostId() {
		return responsePostId;
	}

	public void setResponsePostId(int responsePostId) {
		this.responsePostId = responsePostId;
	}
	*/

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	
}
