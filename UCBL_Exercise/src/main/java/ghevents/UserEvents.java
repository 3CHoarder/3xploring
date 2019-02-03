package ghevents;

import java.util.ArrayList;
import java.util.List;

public class UserEvents {
	private String login;
    private List<Event> events; 
    
    public UserEvents(String login) {
		this.login = login;
	}
    
    public void addEvent(String type, String created_at) {
    	if(events == null)
    		events = new ArrayList();
    	events.add(new Event(type, created_at));
    }

	public List<Event> getEvents() {
		return events;
	}

    public class Event {
		private String type;
		private String created_at;
		
    	public Event(String type, String created_at) {
			this.type = type;
			setCreated_at(created_at);
		}
		
    	public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			created_at = created_at.replace('T', ' ').replace('Z', ' ');
			this.created_at = created_at;
		}
    }
}
