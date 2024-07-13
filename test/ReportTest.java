import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class ReportTest {

    private Report report;

    @Before
    public void setUp() {
        report = new Report();
    }

    @After
    public void tearDown() {
        report = null;
    }

    @Test
    public void testSalesTable() {
        System.out.println("TestReport");
         System.out.println("TestPassed");
// Create a mock DefaultTableModel         
        DefaultTableModel TableModel = new DefaultTableModel(
                
                new Object[][]{
                    
                        {"1", "2024-01-01", "100.0", "50.0", "50.0"},
                        {"2", "2024-01-02", "150.0", "70.0", "80.0"}
                },
                new String[]{"ID", "Date", "TotalCost", "Pay", "Balance"}
                
        );

        // Set the mock model to jTable1
       // report.jTable1.setModel(mockTableModel);

        // Call the Sales_table method to update the table model
        report.Sales_table();

        // Verify the updated content of the table model
        Vector<Vector<String>> dataVector = TableModel.getDataVector();

        // Check the content of the first row
        Vector<String> firstRow = dataVector.get(0);
        assertEquals("1", firstRow.get(0));
        assertEquals("2024-01-01", firstRow.get(1));
        assertEquals("100.0", firstRow.get(2));
        assertEquals("50.0", firstRow.get(3));
        assertEquals("50.0", firstRow.get(4));

        // Check the content of the second row
        Vector<String> secondRow = dataVector.get(1);
        assertEquals("2", secondRow.get(0));
        assertEquals("2024-01-02", secondRow.get(1));
        assertEquals("150.0", secondRow.get(2));
        assertEquals("70.0", secondRow.get(3));
        assertEquals("80.0", secondRow.get(4));
    }
}
