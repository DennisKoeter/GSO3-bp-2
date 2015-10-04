/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dennis
 */
public class AppointmentTest {
    Appointment a;
    TimeSpan t;
    Time bt;
    Time et;
    Contact c1;
    Contact c2;
    
    public AppointmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bt = new Time(2000,1,1,1,1);
        et = new Time(2001,1,1,1,1);
        t = new TimeSpan(bt, et);
        a = new Appointment("nothing special", t);
        c1 = new Contact("Cas");
        c2 = new Contact("Dennis");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testAppointment(){
        a = new Appointment("nothing special", t);
    }
    
    @Test
    public void testGetSubject(){
        assertEquals("subjects aren't equal", "nothing special", a.getSubject());
    }
    
    @Test
    public void testGetTimeSpan(){
        TimeSpan x = (TimeSpan)a.getTimespan();
        Time btx = (Time)x.getBeginTime();
        Time etx = (Time)x.getEndTime();
       
        assertEquals("Years are not equal", bt.getYear(), btx.getYear());
        assertEquals("Months are not equal", bt.getMonth(), btx.getMonth());
        assertEquals("Days are not equal", bt.getDay(), btx.getDay());
        assertEquals("Hours are not equal", bt.getHours(), btx.getHours());
        assertEquals("Minutes are not equal", bt.getMinutes(), btx.getMinutes());
        
        assertEquals("Years are not equal", et.getYear(), etx.getYear());
        assertEquals("Months are not equal", et.getMonth(), etx.getMonth());
        assertEquals("Days are not equal", et.getDay(), etx.getDay());
        assertEquals("Hours are not equal", et.getHours(), etx.getHours());
        assertEquals("Minutes are not equal", et.getMinutes(), etx.getMinutes());
    }
    
    @Test
    public void testInvitees(){
        a.addContact(c1);
        a.addContact(c2);
        
        Iterator<Contact> i = a.invitees();
        
        int j = 0;
        
        while(i.hasNext()){
            if(i.next() == c1) j++;
            if(i.next() == c2) j++;
        }
        
        assertTrue("Contacts don't match", j == 2);
    }
    
    @Test
    public void testAddContact(){
        a.addContact(c1);
        Iterator<Contact> i = a.invitees();
        
        int j = 0;
        
        while(i.hasNext()){
            if(i.next() == c1) j++;
        }
        
        assertTrue("Contacts don't match", j == 1);
    }
    
    @Test
    public void testRemoveContact(){
        assertTrue(a.addContact(c1));
        assertFalse(a.addContact(c1));
        a.addContact(c2);
        
        a.removeContact(c1);
        
        Iterator<Contact> i = a.invitees();
        
        int j = 0;
        
        while(i.hasNext()){
            if(i.next() == c1) j++;
        }
        
        assertTrue("Contacts don't match", j == 0);
    }
}
