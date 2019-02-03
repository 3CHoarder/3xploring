package ghevents;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * GHEvents class.
 *
 * This class has things about events of a Github user.
 */
@RestController
public class GHEvents {

	@CrossOrigin
	@RequestMapping(value = "/ghevents", method = RequestMethod.GET, produces = "application/json")
	public List<UserEvents.Event> getEvents(@RequestParam(value = "user", required = true) String user, Model model) {
		String ghuserEvtUrl = String.format("https://api.github.com/users/%s/events/public", user);
	   
		String line;
		StringBuilder sb = new StringBuilder();
	    try {
	        URL url = new URL(ghuserEvtUrl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	  
	        conn.setRequestMethod("GET");
	      
	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        while ((line = reader.readLine()) != null) {
	    	    sb.append(line);
	        }
	    } catch (IOException ex) {
		    return null;
	    }

	    UserEvents uevts = new UserEvents(user);
        JsonFactory factory = new JsonFactory();
        
        model.addAttribute("user", user);
        try {
			JsonParser  parser  = factory.createParser(sb.toString());
			String type = null, created_at = null;
			while(!parser.isClosed()) {
				JsonToken jsonToken = parser.nextToken();
	
				if(JsonToken.FIELD_NAME.equals(jsonToken)) {
					String fieldName = parser.getCurrentName();
	
					if("type".equals(fieldName)) {
						jsonToken = parser.nextToken();
						type = parser.getText();
					} else if ("created_at".equals(fieldName)) {
						jsonToken = parser.nextToken();
						created_at = parser.getText();
						uevts.addEvent(type, created_at);
						type = null;
						created_at = null;
					}
				}
			}
			model.addAttribute("events", uevts.getEvents());
        } catch (IOException ex) {
        	model.addAttribute("events", null);
        }
	  
	    return uevts.getEvents();
    }
}
