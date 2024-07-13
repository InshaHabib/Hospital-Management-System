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
public class LoginTest {
    
    public LoginTest() {
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

    /**
     * Test of Connect method, of class Login.
     */
    @Test
   
public void testConnect() {
    System.out.println("Connect");
    
    Login instance = new Login();

    try {
        instance.Connect();
        assertNotNull("Connection should not be null", instance.con);
    } catch (Exception ex) {
        fail("Exception thrown while connecting: " + ex.getMessage());
    }
}


    /**
     * Test of main method, of class Login.
     */
    @Test
public void testMain() {
    System.out.println("main");
   
    String[] args = null;

    try {
        Login.main(args);
    } catch (Exception ex) {
        fail("Exception thrown in main method: " + ex.getMessage());
    }
}

    
}
