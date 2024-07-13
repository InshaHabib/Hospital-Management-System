import junit.framework.TestCase;
import org.junit.Test;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.SQLException;

public class ItemTest extends TestCase {

    @Test
    public void testAutoID() {
        Item item = new Item();

        item.Connect(); // Simulate database connection
        item.AutoID();
        String generatedId = item.getLbldrugid().getText();
        // Assuming the generated ID follows the pattern "IUXXX" where XXX is a number
        assertTrue(generatedId.matches("IU\\d+"));
    }

    @Test
    public void testDrugTable() {
        Item item = new Item();

        item.Connect(); // Simulate database connection
        item.drug_table();
        // Assuming the jTable1 should be populated after calling drug_table
        assertTrue(item.getJTable1().getRowCount() > 0);
    }

    // Add more test cases as needed

    @Override
    protected void tearDown() throws Exception {
        // Perform any cleanup if needed
        super.tearDown();
    }
}
