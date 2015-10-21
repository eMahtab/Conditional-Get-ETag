package co.edureka.jaxrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
@Path("/say")
public class HelloWorldService {
 
	@GET
	
	public Response getMsg() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date current=new Date();
		String date=sdf.format(current);
		System.out.println(date);
		
		CacheControl cc=new CacheControl();
		cc.setMaxAge(60);
		cc.setPrivate(true);
		//cc.setNoStore(true);  It will not cache
		
		ResponseBuilder builder = Response.ok("Great :"+date.toString(), "text/plain");
		builder.cacheControl(cc);
		 return builder.build();
 
	}
 
}