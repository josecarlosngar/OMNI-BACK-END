package domain.ws.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.User;
import database.UserDAO;



@Path("/user")
public class UserService {
	
	
	  @GET
	  @Produces (MediaType.APPLICATION_JSON)
	  @Path("get")
	  public List<User> getUsers () throws SQLException {
		  
		 List<User> users = new ArrayList<User>();
		
		 users= UserDAO.getUsers();
		 return users;
		}
	  
	  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Path("login")
	  public User login(@FormParam("email")String email,@FormParam("password")String password) {
		 User res;
		 try {
				res = User.login(email,password);
			} catch (SQLException e) {
				res=new User();
			}
	    return res;
	  }
	  
	  
	}

