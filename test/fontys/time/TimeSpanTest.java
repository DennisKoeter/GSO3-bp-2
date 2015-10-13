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
import static org.junit.Assert.*;

/**
 *
 * @author Dennis
 */
public class TimeSpanTest {
    Time bt;
    Time et;
    TimeSpan2 t;
    TimeSpan2 t2;
    TimeSpan2 t3;
    TimeSpan2 t4;
    Time x;
    Time y;
    int a;
    int b;
    public TimeSpanTest() {
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
        et = new Time(2015,1,1,1,1);
        t = new TimeSpan2(bt, et);
        x = null;
        y = null;
        a = 0;
        b = 0;
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
    public void testConstructor(){
        TimeSpan2 t = new TimeSpan2(bt, et);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testWrongConstructor(){
        TimeSpan2 t = new TimeSpan2(et, bt);
        TimeSpan2 q = new TimeSpan2(et, et);
        fail("constructor doesn't catch errors");
    }
    
    @Test
    public void testGetBeginTime(){
        x = new Time(2000,1,1,1,1);
        y = (Time)t.getBeginTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
    }
    
    @Test
    public void testGetEndTime(){
        x = new Time(2015,1,1,1,1);
        y = (Time)t.getEndTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
    }
    
    @Test
    public void testLength(){
        a = t.length();
        b = bt.difference(et);
        
        assertEquals("lengths aren't equal", a, b);
    }
    
    @Test
    public void testSetEndTime(){
        x = new Time(2020,1,1,1,1);
        t.setEndTime(x);
        y = (Time)t.getEndTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testSetEndTimeArgumentsException(){
        t.setEndTime(bt);
        fail("no exception thrown");
    }
    
    @Test
    public void testSetBeginTime(){
        x = new Time(1985,1,1,1,1);
        t.setBeginTime(x);
        y = (Time)t.getBeginTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testSetBeginTimeArgumentsException(){
        t.setBeginTime(et);
        fail("no exception thrown");
    }
    
    @Test
    public void testMove(){
        t.move(10);
        x = (Time)t.getBeginTime();
        y = new Time(2000,1,1,1,11);
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
        
        x = (Time)t.getEndTime();
        y = new Time(2015,1,1,1,11);
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
    }
    
    @Test
    public void testChangeLengthWith(){
        t.changeLengthWith(10);
        x = (Time)t.getEndTime();
        y = new Time(2015,1,1,1,11);
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testChangeLengthWithArgumentsException(){
        t.changeLengthWith(-10000);
        fail("no exception thrown");
    }
    @Test (expected=IllegalArgumentException.class)
    public void testChangeLengthWithArgumentsException2(){
        t.changeLengthWith(t.length() * -1);
        fail("no exception thrown");
    }
    
    @Test
    public void testIsPartOf(){
        t2 = new TimeSpan2(new Time(2001,1,1,1,1), new Time(2014,1,1,1,1));
        t3 = new TimeSpan2(new Time(2030,1,1,1,1), new Time(2035,1,1,1,1));
        assertTrue("timespan is not part of bigger timespan", t2.isPartOf(t));
        assertFalse("timespan is part of wrong timespan", t3.isPartOf(t));
    }
    
    @Test
    public void testUnionWith(){
        t2 = new TimeSpan2(new Time(2014,1,1,1,1), new Time(2016,1,1,1,1));
        t3 = (TimeSpan2)t2.unionWith(t);
        t4 = new TimeSpan2(new Time(2014,1,1,1,1), new Time(2015,1,1,1,1));
        x = (Time)t3.getBeginTime();
        y = (Time)t4.getBeginTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
        
        x = (Time)t3.getEndTime();
        y = (Time)t4.getEndTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
        
        TimeSpan2 t5 = new TimeSpan2(new Time(2014,1,1,1,1), new Time(2016,1,1,1,1));
        TimeSpan2 t6 = new TimeSpan2(new Time(2018,1,1,1,1), new Time(2021,1,1,1,1));
        TimeSpan2 t7 = new TimeSpan2(new Time(2019,1,1,1,1), new Time(2020,1,1,1,1));
        
        assertNull("null not returned", (TimeSpan2)t5.unionWith(t6));
        assertNull("null not returned", (TimeSpan2)t6.unionWith(t5));
        assertNull("null not returned", (TimeSpan2)t6.unionWith(t7));
        assertNull("null not returned", (TimeSpan2)t7.unionWith(t6));
    }
    
    @Test
    public void testIntersectionWith(){
        t2 = new TimeSpan2(new Time(2014,1,1,1,1), new Time(2016,1,1,1,1));
        t3 = (TimeSpan2)t2.intersectionWith(t);
        t4 = new TimeSpan2(new Time(2000,1,1,1,1), new Time(2016,1,1,1,1));
        x = (Time)t3.getBeginTime();
        y = (Time)t4.getBeginTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
        
        x = (Time)t3.getEndTime();
        y = (Time)t4.getEndTime();
        
        assertEquals("Years are not equal", y.getYear(), x.getYear());
        assertEquals("Months are not equal", y.getMonth(), x.getMonth());
        assertEquals("Days are not equal", y.getDay(), x.getDay());
        assertEquals("Hours are not equal", y.getHours(), x.getHours());
        assertEquals("Minutes are not equal", y.getMinutes(), x.getMinutes());
        
        TimeSpan2 t5 = new TimeSpan2(new Time(2014,1,1,1,1), new Time(2016,1,1,1,1));
        TimeSpan2 t6 = new TimeSpan2(new Time(2018,1,1,1,1), new Time(2021,1,1,1,1));
        TimeSpan2 t7 = new TimeSpan2(new Time(2019,1,1,1,1), new Time(2020,1,1,1,1));
        
        assertNull("null not returned", (TimeSpan2)t5.intersectionWith(t6));
        assertNull("null not returned", (TimeSpan2)t6.intersectionWith(t5));
        assertNull("null not returned", (TimeSpan2)t6.intersectionWith(t7));
        assertNull("null not returned", (TimeSpan2)t7.intersectionWith(t6));
    }
}
