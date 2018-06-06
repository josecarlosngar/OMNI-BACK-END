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
import domain.User;
import database.DatabaseConnectionFactory;

public class TagDAO {

 
  public List<Tag> getTagsPost(int postId) throws SQLException {
	  //get connection from connection pool
	  Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

	  List<Tag> tags = new ArrayList<Tag>();
	  Statement stmt = null;
	  ResultSet rs = null;
	  try {
	    stmt = con.createStatement();

	StringBuilder sb = new StringBuilder("select tag.id as id, tag.name as name ")
	      .append("from Tag join `post-tag` on tag.id = `post-tag`.tagId ")
	      .append("where `post-tag`.postId="+postId+" ")
	      .append("order by tag.name");
	//execute the query
	    rs = stmt.executeQuery(sb.toString());

	
	    while (rs.next()) {
	      Tag tag = new Tag();
	      tag.setId(rs.getInt("id"));
	      tag.setName(rs.getString("name"));
	      tags.add(tag);
	    }
	    return tags;
	  }
	  finally {
		  try {if (rs != null) rs.close();} catch (SQLException e) {}
		  try {if (stmt != null) stmt.close();} catch (SQLException e) {}
		  try {con.close();} catch (SQLException e) {}
		  }
		}
	  public List<Tag> getTags() throws SQLException {
		  //get connection from connection pool
		  Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		  List<Tag> tags = new ArrayList<Tag>();
		  Statement stmt = null;
		  ResultSet rs = null;
		  try {
		    stmt = con.createStatement();

		StringBuilder sb = new StringBuilder("select tag.id as id, tag.name as name ")
		      .append("from Tag ")
		      .append("order by tag.name");
		//execute the query
		    rs = stmt.executeQuery(sb.toString());

		
		    while (rs.next()) {
		      Tag tag = new Tag();
		      tag.setId(rs.getInt("id"));
		      tag.setName(rs.getString("name"));
		      tags.add(tag);
		    }
		    return tags;
		  }
	finally {
	  try {if (rs != null) rs.close();} catch (SQLException e) {}
	  try {if (stmt != null) stmt.close();} catch (SQLException e) {}
	  try {con.close();} catch (SQLException e) {}
	  }
	}
	  
	  public List<Tag> getSearchTags(String search) throws SQLException {
		  //get connection from connection pool
		  Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		  List<Tag> tags = new ArrayList<Tag>();
		  Statement stmt = null;
		  ResultSet rs = null;
		  try {
		    stmt = con.createStatement();

		StringBuilder sb = new StringBuilder("select tag.id as id, tag.name as name ")
			  .append("from Tag ")
		      .append("where tag.name like'%"+search+"%' ")
		      .append("order by tag.name");
		//execute the query
		    rs = stmt.executeQuery(sb.toString());

		
		    while (rs.next()) {
		      Tag tag = new Tag();
		      tag.setId(rs.getInt("id"));
		      tag.setName(rs.getString("name"));
		      tags.add(tag);
		    }
		    return tags;
		  }
	finally {
	  try {if (rs != null) rs.close();} catch (SQLException e) {}
	  try {if (stmt != null) stmt.close();} catch (SQLException e) {}
	  try {con.close();} catch (SQLException e) {}
	  }
	}
}
