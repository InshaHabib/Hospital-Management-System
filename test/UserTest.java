import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest {

    @Test
    public void testConstructor() {
        User user = new User("john.doe", "password123", "Doctor");

        assertEquals("john.doe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("Doctor", user.getUserType());

        // Additional assertions based on your specific logic
    }

    // You can add more tests for other methods or functionalities in the User class.
}
