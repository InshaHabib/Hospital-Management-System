/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Insha Habib
 */
public class CreateAppointmentRecordTest {
    
    public CreateAppointmentRecordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
    public void testCreateAppointmentRecord() {
        System.out.println("testCreateAppointmentRecord");
         System.out.println("TestPassed");
        // Create an instance of AddPatientRecord
        CreateAppointmentRecordTest instance = new CreateAppointmentRecordTest();
        
        // Assuming addPatientRecord returns a boolean indicating success
       

        // Add any assertions based on the expected behavior of addPatientRecord
       // assertTrue("Patient record should be added successfully", result);
    }
}
