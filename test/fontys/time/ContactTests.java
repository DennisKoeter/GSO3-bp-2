package fontys.time;

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
    private Contact a;
    private Contact b;
    @Before
    public void setUp() {
        a = new Contact("Cas");
        b = new Contact("Dennis");
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
        assertEquals("getName() failed", "Cas", a.getName());
        assertEquals("getName() failed", "Dennis", b.getName());
    }
    

}
