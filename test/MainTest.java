import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class MainTest {

    @Test
    public void testConstructor() {
        Main main = new Main(1, "JohnDoe", "Doctor");

        assertEquals("JohnDoe", main.uname);
        assertEquals("Doctor", main.usertype);
        assertEquals(1, main.newid);
        assertEquals(1, main.idd);

        // Additional assertions based on your specific logic
    }

    // You can add more tests for other methods or functionalities in the Main class.
}
