package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Post;
import domain.Tag;
import domain.User;
import database.DatabaseConnectionFactory;

public class PostTagDAO {

  public static void addPostTag (int postId, int tagId) throws SQLException {
    //get connection from connection pool
    Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
    try {
      final String sql = "insert into `post-tag` (postId,tagId) values (?,?)";
      //create the prepared statement with an option to get auto-generated keys
      PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      //set parameters
      
      stmt.setInt(1, postId);
      stmt.setInt(2, tagId);

      stmt.execute();

      //Get auto-generated keys
      ResultSet rs = stmt.getGeneratedKeys();

      /* if (rs.next()) {
    	  
        post.setId(rs.getInt(1));
        
      }*/

      rs.close();
      stmt.close();
    }
    finally {
      con.close();
    }
  }
}
