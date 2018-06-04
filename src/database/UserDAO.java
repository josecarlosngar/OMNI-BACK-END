package database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import database.DatabaseConnectionFactory;

import domain.User;

public class UserDAO {

	
	 public void addUsers (User user) throws SQLException {
		    //get connection from connection pool
		    Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		    try {
		      final String sql = "insert into User (id, username, password, name, surname, email, role, image, registrationMoment ) values (?,?,?,?,?,?,?,?,?)";
		      //create the prepared statement with an option to get auto-generated keys
		      PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		      //set parameters
		      stmt.setInt(1, user.getId());
		      stmt.setString(2, user.getUsername());
		      stmt.setString(3, user.getPassword());
		      stmt.setString(4, user.getName());
		      stmt.setString(5, user.getSurname());
		      stmt.setString(6, user.getEmail());
		      stmt.setString(7, user.getRole());
		      stmt.setString(8, user.getImage());
		      stmt.setString(9, user.getRegistrationMoment().toString());
		     

		      stmt.execute();

		      //Get auto-generated keys
		      ResultSet rs = stmt.getGeneratedKeys();

		      if (rs.next())
		        user.setId(rs.getInt(1));

		      rs.close();
		      stmt.close();
		    }
		    finally {
		      con.close();
		    }
		  }
	

	 
	 public static List<User> getUsers () throws SQLException {
		 
	 Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

	  List<User> users = new ArrayList<User>();
	  Statement stmt = null;
	  ResultSet rs = null;
	  try {
	    stmt = con.createStatement();

	    //create SQL statement using left outer join
	    StringBuilder sb = new StringBuilder("select user.id as id, user.username as username,")
	      .append("user.password as password, user.name as name, user.surname as surname, ")
	      .append("user.email as email, user.role as role, user.image as image user.registrationMoment as registrationMoment ")
	      .append("from User order by user.id");
	      

	//execute the query
	    rs = stmt.executeQuery(sb.toString());

	//iterate over result set and create Course objects
	//add them to course list
	    while (rs.next()) {
	      User user = new User();
	      user.setId(rs.getInt("id"));
	      user.setUsername(rs.getString("username"));
	      user.setPassword(rs.getString("password"));
	      user.setName(rs.getString("name"));
	      user.setSurname(rs.getString("surname"));
	      user.setEmail(rs.getString("email"));
	      user.setRole(rs.getString("role"));
	      user.setImage(rs.getString("image"));
	      user.setRegistrationMoment(rs.getDate("registrationMoment"));
	      users.add(user);

	   
	    }

	    return users;
	  }
	finally {
	  try {if (rs != null) rs.close();} catch (SQLException e) {}
	  try {if (stmt != null) stmt.close();} catch (SQLException e) {}
	  try {con.close();} catch (SQLException e) {}
	  }
	}
}
