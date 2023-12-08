package com.klu.Project;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;



@ApplicationPath("/abc")
@Path("/")
public class RestController extends Application {
  @GET
  @Path("/f1")
 // @Produces(MediaType.APPLICATION_JSON)
  //@Produces(MediaType.TEXT_PLAIN)
  @Produces(MediaType.TEXT_HTML)
 public String fun1(@QueryParam("a")int a,@QueryParam("b")int b) {
	  Integer c=a+b;
	  
    
    System.out.print("HELLO WORLD");
   return "hello world - "+ c.toString();
 }
  
  
  
  
  @POST
  @Path("/f1")
  @Produces(MediaType.APPLICATION_JSON)
 public String fun2()
 {
	 return "Post data";
 }
 
 
}