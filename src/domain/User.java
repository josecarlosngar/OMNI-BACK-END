package domain;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import database.UserDAO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@XmlAttribute
	private int id;
	@JsonIgnore
	private String username;
	@JsonIgnore
	private String password;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String surname;
	@JsonIgnore
	private String email;
	@XmlAttribute
	private String role;
	@XmlAttribute
	private String image;
	@XmlAttribute
	private Date registrationMoment;

	public User() {
	}

	public User(int id, String username, String password, String name, String surname, String email, String role,
			String image) {
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setRole(role);
		this.setImage(image);
		Date datetime = new Date();
		this.setRegistrationMoment(datetime);

	}

	private static UserDAO userDAO = new UserDAO();

	public void addUsers() throws SQLException {
		userDAO.addUsers(this);
	}
	
	
	public List<User> getUsers() throws SQLException {
		return UserDAO.getUsers();
	}
	public static User login(String email, String password) throws SQLException {
		return UserDAO.login(email,password);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRegistrationMoment() {
		return registrationMoment;
	}

	public void setRegistrationMoment(Date registrationMoment) {
		this.registrationMoment = registrationMoment;
	}
}