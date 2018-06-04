package domain;

import java.time.LocalDateTime;

public class User {

	private int id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String role;
	private String image;
	private LocalDateTime registrationmoment;

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
		LocalDateTime localdatetime = LocalDateTime.now();
		this.setRegistrationmoment(localdatetime);

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

	public LocalDateTime getRegistrationmoment() {
		return registrationmoment;
	}

	public void setRegistrationmoment(LocalDateTime registrationmoment) {
		this.registrationmoment = registrationmoment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}