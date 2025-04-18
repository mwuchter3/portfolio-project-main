package components.matrix;

import org.junit.Test;
import static org.junit.Assert.*;

public class Matrix1LKernelTest {

    @Test
    public void testDefaultConstructor() {
        Matrix m = new Matrix1L();
        
        assertEquals(3, m.rows());
        assertEquals(3, m.columns());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0.0, m.getEntry(i, j), 0.0);
            }
        }
    }

    @Test
    public void testDimConstructor() {
        Matrix m = new Matrix1L(2, 4);

        assertEquals(2, m.rows());
        assertEquals(4, m.columns());

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(0.0, m.getEntry(i, j), 0.0);
            }
        }
    }

    @Test
    public void testGetEntryDefaultValues() {
        Matrix m = new Matrix1L(2, 2);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals("Entry (" + i + "," + j + ") should be 0.0", 0.0, m.getEntry(i, j), 0.0);
            }
        }
    }

    @Test
    public void testChangeEntry() {
        Matrix m = new Matrix1L(2, 2);

        m.changeEntry(1, 1, 5.5);

        assertEquals("Entry (1,1) should be updated to 5.5", 5.5, m.getEntry(1, 1), 0.0);
        assertEquals("Entry (0,0) should remain 0.0", 0.0, m.getEntry(0, 0), 0.0);
    }

    @Test
    public void testClear() {
        Matrix m = new Matrix1L(2, 2);

        m.changeEntry(0, 1, 3.3);
        m.clear();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(0.0, m.getEntry(i, j), 0.0);
            }
        }
    }

    @Test
    public void testTransferFrom() {
        Matrix test = new Matrix1L(1, 1);
        Matrix src  = new Matrix1L(2, 3);

        src.changeEntry(1, 2, 3);
        test.transferFrom(src);

        assertEquals(2, test.rows());
        assertEquals(3, test.columns());
        assertEquals(3, test.getEntry(1, 2), 0.0);

        assertEquals(0, src.rows());
        assertEquals(0, src.columns());
    }

    @Test
    public void testNewInstance() {
        Matrix m = new Matrix1L(4, 5);
        Matrix copy = m.newInstance();

        assertEquals(4, copy.rows());
        assertEquals(5, copy.columns());

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(0.0, copy.getEntry(i, j), 0.0);
            }
        }
    }
}
