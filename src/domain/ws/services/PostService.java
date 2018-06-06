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

import com.mysql.fabric.Response;

import domain.Post;
import domain.User;

@Path("/post")
public class PostService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get")
	public List<Post> getPosts() {
		List<Post> res = new ArrayList<Post>();
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
		List<Post> res = new ArrayList<Post>();
		try {
			res = Post.getPostsTag(tagId);
		} catch (SQLException e) {
			res.add(new Post());
		}

		return res;
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("add")
	public String addPost(@FormParam("userId")int userId, @FormParam("text")String text,@FormParam("tagIds") String tags) {
		String res;
		//String text="";
		//int userId=1;
		//int[] tagIds= {2,3};
		tags.split(",");
		List<Integer> tagIds=new ArrayList<Integer>();
		for(String id:tags.split(",")) {
			tagIds.add(Integer.parseInt(id));
		}
		if (text != null && tagIds.size() > 0) {
			try {
				Post.addPost(userId, text, tagIds);
				res = "post.commit.ok";
			} catch (SQLException e) {
				res = "post.commit.error";
			}
		} else {
			res = "post.commit.error";
		}
		return res;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("text")
	public String text() {
		return "hola";
	}
}
