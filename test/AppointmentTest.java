import java.util.Vector;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AppointmentTest {

    private Appointment appointment;

    @Before
    public void setUp() {
        // Initialize the Appointment object before each test
        appointment = new Appointment();
        appointment.Connect();  // Connect to the database
    }

    @Test
    public void testGetAppointmentTableData() {
        // Test if the getAppointmentTableData method retrieves data from the database
        Vector<Vector<Object>> data = appointment.getAppointmentTableData();

        // Check if the data vector has at least one row
        assertTrue(data.size() > 0);

        // Check if the data in the first row is not null
        assertNotNull(data.get(0).get(0));
        assertNotNull(data.get(0).get(1));
        assertNotNull(data.get(0).get(2));
        assertNotNull(data.get(0).get(3));
        assertNotNull(data.get(0).get(4));
    }
}
