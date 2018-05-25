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
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.role = role;
		this.image = image;
		LocalDateTime localdatetime = LocalDateTime.now();
		this.registrationmoment = localdatetime;

	}
}