package ghevents;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GHEventsTestManager {
	@Mock
    GHEvents ghEvents;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getEventsTest()
    {
        List<UserEvents.Event> list = new ArrayList<>();
        UserEvents events = new UserEvents("tester");
        list.add(events.new Event("CreateEvent", "2019-01-06 17:26:27"));
        list.add(events.new Event("PushEvent", "2019-02-01 18:20:22"));
         
       when(ghEvents.getEvents("tester")).thenReturn(list);
         
        //test
       List<UserEvents.Event> eventList = ghEvents.getEvents("tester");
         
        assertEquals(2, eventList.size());
        verify(ghEvents, times(1)).getEvents("tester");
    }
}
