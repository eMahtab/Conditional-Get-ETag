package co.edureka.jaxrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	
	public Response getMsg() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date current=new Date();
		String date=sdf.format(current);
		System.out.println(date);
		
		ResponseBuilder builder = Response.ok("Great :"+date.toString(), "text/plain");
		builder.expires(new Date((current.getTime()+2*60*1000)));
		 return builder.build();
 
	}
 
}