package domain.ws.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.fabric.Response;

import domain.Post;


@Path("/post")
public class PostService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("get")
  public List<Post> getPosts () {
	 List<Post> res=new ArrayList<Post>();
	try {
		res = Post.getPosts();
	} catch (SQLException e) {
		res.add(new Post());
	}
	
    return res;
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("tag/{tagId}")
  public List<Post> getPostsTag(@PathParam("tagId") int tagId) {
	 List<Post> res=new ArrayList<Post>();
	try {
		res = Post.getPostsTag(tagId);
	} catch (SQLException e) {
		res.add(new Post());
	}
	
    return res;
  }
  
 
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("text")
  public String text () {
	return "hola";
  }
}
