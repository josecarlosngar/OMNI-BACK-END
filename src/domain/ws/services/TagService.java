package domain.ws.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import domain.Post;
import domain.Tag;


@Path("/tag")
public class TagService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("get")
  public List<Tag> getTags () {
	 List<Tag> res=new ArrayList<Tag>();
	try {
		res = Tag.getTags();
	} catch (SQLException e) {
		res.add(new Tag());
	}
	
    return res;
  }
  

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("search/{search}")
  public List<Tag> getSearchTags(@PathParam("search") String search) {
	 List<Tag> res=new ArrayList<Tag>();
	try {
		res = Tag.getSearchTags(search);
	} catch (SQLException e) {
		res.add(new Tag());
	}
	
    return res;
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("pop/{number}")
  public List<Tag> getPopTags (@PathParam("number") int number) {
	 List<Tag> res=new ArrayList<Tag>();
	try {
		res = Tag.getPopTags(number);
	} catch (SQLException e) {
		res.add(new Tag());
	}
	
    return res;
  }
  
}
