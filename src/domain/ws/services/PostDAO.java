package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import domain.Post;
import domain.Tag;
import database.DatabaseConnectionFactory;

public class PostDAO {

  public static void addPost (Post post) throws SQLException {
    //get connection from connection pool
    Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
    try {
      final String sql = "insert into Post (creationDate, editionDate,text,likes,dislikes,userId) values (?,?,?,0,0,null)";
      //create the prepared statement with an option to get auto-generated keys
      PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      //set parameters
      stmt.setString(1, post.getCreationDate().toString());
      stmt.setString(2, post.getEditionDate().toString());
      stmt.setString(3, post.getText());

      stmt.execute();

      //Get auto-generated keys
      ResultSet rs = stmt.getGeneratedKeys();

      if (rs.next())
        post.setId(rs.getInt(1));

      rs.close();
      stmt.close();
    }
    finally {
      con.close();
    }
  }
  public static void removePost (int id) throws SQLException {
	    //get connection from connection pool
	    Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
	    try {
	      final String sql = "Delete from Post where post.id = ?";
	      
	      PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	      //set parameters
	   
	      stmt.setInt(1, id);

	      stmt.execute();

	      //Get auto-generated keys
	      ResultSet rs = stmt.getGeneratedKeys();
	      rs.close();
	      stmt.close();
	    }
	    finally {
	      con.close();
	    }
	  }
  
  public static void updatePost (int id,String text) throws SQLException {
	    //get connection from connection pool
	    Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
	    try {
	      final String sql = "UPDATE Post SET post.text = ? where post.id = ?";
	      
	      PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	      //set parameters
	      stmt.setString(1, text);
	      stmt.setInt(2, id);

	      stmt.execute();

	      //Get auto-generated keys
	      ResultSet rs = stmt.getGeneratedKeys();
	      rs.close();
	      stmt.close();
	    }
	    finally {
	      con.close();
	    }
	  }

  public List<Post> getPosts () throws SQLException {
	  //get connection from connection pool
	  Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

	  List<Post> posts = new ArrayList<Post>();
	  Statement stmt = null;
	  ResultSet rs = null;
	  try {
	    stmt = con.createStatement();

	    //create SQL statement using left outer join
	    /*StringBuilder sb = new StringBuilder("select post.id as postId, post.text as text, post.creationDate as creationDate,")
	      .append("post.editionDate as editionDate, Tag.id as tagId, Tag.name as tagName ")
	      .append("from Post join `post-tag` on Post.id = `post-tag`.postId ")
	      .append("join Tag on `post-tag`.tagId = tag.id ")
	      .append("order by post.creationDate");*/
	StringBuilder sb = new StringBuilder("select post.id as postId, post.text as text, post.creationDate as creationDate,")
	      .append("post.editionDate as editionDate ")
	      .append("from Post ")
	      .append("order by post.creationDate");
	//execute the query
	    rs = stmt.executeQuery(sb.toString());

	//iterate over result set and create Course objects
	//add them to course list
	    while (rs.next()) {
	      Post post = new Post();
	      post.setId(rs.getInt("postId"));
	      post.setText(rs.getString("text"));
	      post.setCreationDate(rs.getDate("creationDate"));
	      post.setEditionDate(rs.getDate("editionDate"));
	      posts.add(post);
	    }
	//check whether teacher id was null in the table
	   /*  
	     if (rs.wasNull()) //no teacher set for this course.
	        continue;
	      Tag tag = new Tag();
	      tag.setId(tagId);
	      tag.setName(rs.getString("name"));;
	      post.getTags().add(tag);
	    }*/

	    return posts;
	  }
	finally {
	  try {if (rs != null) rs.close();} catch (SQLException e) {}
	  try {if (stmt != null) stmt.close();} catch (SQLException e) {}
	  try {con.close();} catch (SQLException e) {}
	  }
	}
}
