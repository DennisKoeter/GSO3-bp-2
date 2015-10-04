package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cas
 */
public class ContactTests {
    
    public ContactTests() {
    }
    private Contact c1;
    private Contact c2;
    
    private Appointment a1;
    private Appointment a2;
    private Appointment a3;
    @Before
    public void setUp() {
        c1 = new Contact("Cas");
        c2 = new Contact("Dennis");
        
        a1 = new Appointment("test Appointment 1", new TimeSpan(new Time(2015,1,1,12,0), new Time(2015,1,1,12,30)));
        a2 = new Appointment("test Appointment 1", new TimeSpan(new Time(2015,1,1,12,31), new Time(2015,1,1,13,0)));
        a3 = new Appointment("test Appointment 1", new TimeSpan(new Time(2015,1,1,13,1), new Time(2015,1,1,13,30)));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void constructorTest(){
        Contact c = new Contact("asdf");
    }
    
    @Test
    public void getNameTest() {
        assertEquals("getName() failed", "Cas", c1.getName());
        assertEquals("getName() failed", "Dennis", c2.getName());
    }
    
    @Test
    public void addAppointmentTest() {
        assertTrue("Could not add appointment", c1.addAppointment(a1));
        assertTrue("Could not add appointment", c1.addAppointment(a2));
        
        List<Appointment> agenda = new ArrayList<Appointment>();
        int iteratorCount = 0;
        int agendaCount = 0;
        
        Iterator<Appointment> i = c1.appointments();
        
        while(i.hasNext()) {
            agenda.add(i.next());     
            iteratorCount++;
        }
        
        assertEquals("Contact didn't get exactly two appointments", 2, iteratorCount);
        
        for(Appointment a : agenda) {
            if(a.equals(a1) || a.equals(a2)) agendaCount++;
        }
        
        assertEquals("Contact didn't get correct appointments", 2, agendaCount);
    }
    
    @Test
    public void removeAppointmentTest() {
        assertTrue("Could not add appointment", c1.addAppointment(a1));
        assertTrue("Could not add appointment", c1.addAppointment(a2));
        
        c1.removeAppointment(a1);
        c1.removeAppointment(a2);
        
        int iteratorCount = 0;
        
        Iterator<Appointment> i = c1.appointments();
        
        while(i.hasNext()) {   
            iteratorCount++;
        }
        
        assertEquals("Not all added appointments were removed", 0, iteratorCount);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void removeAppointmentTest2() {
        assertTrue("Could not add appointment", c1.addAppointment(a1));
        assertTrue("Could not add appointment", c1.addAppointment(a2));
        
        c1.removeAppointment(a3);
    }
    

}
