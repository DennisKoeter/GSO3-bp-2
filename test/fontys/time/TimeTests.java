/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.Calendar;
import static org.junit.Assert.*;

/**
 *
 * @author cas
 */
public class TimeTests {
    public Time t;
    public TimeTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        t = new Time(2015,1,1,1,1);
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
    public void testCorrectConstructor() {
        Time a = new Time(2015,1,1,1,1); // Thursday, January 1st 2015
    }
    
    @Test
    public void testCalendarConstructor() {        
        Time a = new Time(t);
        
        assertEquals("Years are not equal", t.getYear(), a.getYear());
        assertEquals("Months are not equal", t.getMonth(), a.getMonth());
        assertEquals("Days are not equal", t.getDay(), a.getDay());
        assertEquals("Hours are not equal", t.getHours(), a.getHours());
        assertEquals("Minutes are not equal", t.getMinutes(), a.getMinutes());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalMonth1() {
        //@param m 1≤m≤12
        Time a = new Time(2015,13,1,1,1);
        fail("Creation of Time-object with month > 12 didn't fail.");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalMonth2() {
        //@param m 1≤m≤12
        Time a = new Time(2015,0,1,1,1);
        fail("Creation of Time-object with month < 1 didn't fail");
    }
    
    @Test(expected=IllegalArgumentException.class) 
    public void testIllegalDay1() {
        //@param d 1≤d≤31
        Time a = new Time(2015,1,32,1,1);
        fail("Creation of Time-object with day > 31 didn't fail");
    }
    
    @Test(expected=IllegalArgumentException.class) 
    public void testIllegalDay2() {
        //@param d 1≤d≤31
        Time a = new Time(2015,1,0,1,1);
        fail("Creation of Time-object with day < 1 didn't fail");
    }
    
    @Test(expected=IllegalArgumentException.class) 
    public void testIllegalHour1() {
        //@param h 0≤h≤23
        Time a = new Time(2015,1,1,24,1);
        fail("Creation of Time-object with hour > 24 didn't fail");
    }
    
    @Test(expected=IllegalArgumentException.class) 
    public void testIllegalHour2() {
        //@param h 0≤h≤23
        Time a = new Time(2015,1,1,-1,1);
        fail("Creation of Time-object with hour < 0 didn't fail");
    }
    
    @Test(expected=IllegalArgumentException.class) 
    public void testIllegalMinute1() {
        //@param min 0≤min≤59
        Time a = new Time(2015,1,1,1,60);
        fail("Creation of Time-object with min > 59 didn't fail");
    }
    
    @Test(expected=IllegalArgumentException.class) 
    public void testIllegalMinute2() {
        //@param min 0≤min≤59
        Time a = new Time(2015,1,1,1,-1);
        fail("Creation of Time-object with min < 0 didn't fail");
    }
    
    @Test
    public void testDayInWeek() {
        //@return the concerning day in the week of this time
        assertEquals("getDayInWeek() failed", DayInWeek.THU, t.getDayInWeek());
    }
    
    @Test
    public void testPlus() {
        // @param minutes (a negative value is allowed)
        // @return  this time plus minutes
        
        // Add one minute
        Time expected = new Time(2015,1,1,1,2);
        Time actual = (Time)t.plus(1);
        assertEquals("Years are not equal", expected.getYear(), actual.getYear());
        assertEquals("Months are not equal", expected.getMonth(), actual.getMonth());
        assertEquals("Days are not equal", expected.getDay(), actual.getDay());
        assertEquals("Hours are not equal", expected.getHours(), actual.getHours());
        assertEquals("Minutes are not equal", expected.getMinutes(), actual.getMinutes());
        
        // Add one hour
        expected = new Time(2015,1,1,2,1);
        actual = (Time)t.plus(60);
        assertEquals("Years are not equal", expected.getYear(), actual.getYear());
        assertEquals("Months are not equal", expected.getMonth(), actual.getMonth());
        assertEquals("Days are not equal", expected.getDay(), actual.getDay());
        assertEquals("Hours are not equal", expected.getHours(), actual.getHours());
        assertEquals("Minutes are not equal", expected.getMinutes(), actual.getMinutes());
        
        // Subtract one minute
        expected = new Time(2015,1,1,1,0);
        actual = (Time)t.plus(-1);
        assertEquals("Years are not equal", expected.getYear(), actual.getYear());
        assertEquals("Months are not equal", expected.getMonth(), actual.getMonth());
        assertEquals("Days are not equal", expected.getDay(), actual.getDay());
        assertEquals("Hours are not equal", expected.getHours(), actual.getHours());
        assertEquals("Minutes are not equal", expected.getMinutes(), actual.getMinutes());
        
        // Subtract one hour
        expected = new Time(2014,12,31,23,1);
        actual = (Time)t.plus(-60);
        assertEquals("Years are not equal", expected.getYear(), actual.getYear());
        assertEquals("Months are not equal", expected.getMonth(), actual.getMonth());
        assertEquals("Days are not equal", expected.getDay(), actual.getDay());
        assertEquals("Hours are not equal", expected.getHours(), actual.getHours());
        assertEquals("Minutes are not equal", expected.getMinutes(), actual.getMinutes());
    }
    
    @Test
    public void testDifference() {
        // @return the difference between this time and [time] expressed in minutes
        int expected;
        
        Time a = new Time(2015,1,1,1,2);    //   1 minute
        Time b = new Time(2015,1,1,2,1);    //  60 minutes
        Time c = new Time(2015,1,1,1,0);    // - 1 minute
        Time d = new Time(2015,1,1,0,1);    // -60 minutes
        
        assertEquals(  1, t.difference(a));
        assertEquals( 60, t.difference(b));
        assertEquals(- 1, t.difference(c));
        assertEquals(-60, t.difference(d));
    }
    
    @Test
    public void testCompareTo() {
        Time same = new Time(2015,1,1,1,1);
        Time earlier = new Time(2014,1,1,1,1);
        Time later = new Time(2016,1,1,1,1);
        
        assertEquals(0,  t.compareTo(same));
        assertEquals(-1, t.compareTo(earlier));
        assertEquals(1,  t.compareTo(later));
    }
}
