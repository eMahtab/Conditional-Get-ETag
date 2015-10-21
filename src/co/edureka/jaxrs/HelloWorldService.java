package co.edureka.jaxrs;

import java.text.ParseException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
@Path("/et")
public class HelloWorldService {
   
	private static int count=1;
	@GET
	@Produces("text/plain")
	public Response getMsg(@Context Request request) throws ParseException {
		
	    System.out.println("Got Request "+count);
		count++;
			
		Date current=new Date();		
		int minutes=current.getMinutes();		
		
	    CacheControl cc=new CacheControl();
		cc.setMaxAge(60);
		
		EntityTag etag=new EntityTag(""+minutes);
		
		ResponseBuilder builder=request.evaluatePreconditions(etag);
		if(builder !=null){
			builder.cacheControl(cc);
			return builder.build();
		}		
		
		//Sending updated Response
		builder=Response.ok("Time "+minutes,"text/plain");
		builder.cacheControl(cc);
		builder.tag(etag);
		return builder.build(); 
	} 
}