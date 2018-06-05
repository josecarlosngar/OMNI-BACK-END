package domain.ws.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
  
}
