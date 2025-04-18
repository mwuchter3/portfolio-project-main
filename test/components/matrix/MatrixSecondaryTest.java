package components.matrix;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixSecondaryTest {

    /**
     * Helper to build a Matrix from a 2D array.
     */
    private Matrix build(double[][] data) {
        int r = data.length;
        int c = data[0].length;

        Matrix m = new Matrix1L(r, c);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m.changeEntry(i, j, data[i][j]);
            }
        }

        return m;
    }

    @Test
    public void testElementAdd() {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{5, 6}, {7, 8}};

        Matrix m1 = build(a);
        Matrix m2 = build(b);

        Matrix before = build(a);
        m1.elementAdd(m2);

        assertEquals(6.0, m1.getEntry(0, 0), 0.0);
        assertEquals(8.0, m1.getEntry(0, 1), 0.0);
        assertEquals(10.0, m1.getEntry(1, 0), 0.0);
        assertEquals(12.0, m1.getEntry(1, 1), 0.0);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(b[i][j], m2.getEntry(i, j), 0.0);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(before.getEntry(i, j), a[i][j], 0.0);
            }
        }
    }

    @Test
    public void testElementMultiply() {
        Matrix m1 = build(new double[][]{{2, 3}, {4, 5}});
        Matrix m2 = build(new double[][]{{6, 7}, {8, 9}});

        m1.elementMultiply(m2);

        assertEquals(12.0, m1.getEntry(0, 0), 0.0);
        assertEquals(21.0, m1.getEntry(0, 1), 0.0);
        assertEquals(32.0, m1.getEntry(1, 0), 0.0);
        assertEquals(45.0, m1.getEntry(1, 1), 0.0);
    }

    @Test
    public void testMatrixMultiply() {
        Matrix A = build(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix B = build(new double[][]{{7, 8}, {9, 10}, {11, 12}});
        Matrix C = A.matrixMultiply(B);

        assertEquals(2, C.rows());
        assertEquals(2, C.columns());

        assertEquals(58.0,  C.getEntry(0, 0), 0.0);
        assertEquals(64.0,  C.getEntry(0, 1), 0.0);
        assertEquals(139.0, C.getEntry(1, 0), 0.0);
        assertEquals(154.0, C.getEntry(1, 1), 0.0);

        Matrix expectedA = build(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix expectedB = build(new double[][]{{7, 8}, {9, 10}, {11, 12}});

        for (int i = 0; i < A.rows(); i++) {
            for (int j = 0; j < A.columns(); j++) {
                assertEquals(expectedA.getEntry(i, j), A.getEntry(i, j), 0.0);
            }
        }

        for (int i = 0; i < B.rows(); i++) {
            for (int j = 0; j < B.columns(); j++) {
                assertEquals(expectedB.getEntry(i, j), B.getEntry(i, j), 0.0);
            }
        }
    }

    @Test
    public void testDotProduct() {
        Matrix m1 = build(new double[][]{{1, 2}, {3, 4}});
        Matrix m2 = build(new double[][]{{5, 6}, {7, 8}});

        double expected = 1*5 + 2*6 + 3*7 + 4*8;
        assertEquals(expected, m1.dotProduct(m2), 0.0);
    }

    @Test
    public void testCrossProduct() {
        Matrix u = build(new double[][]{{1}, {2}, {3}});
        Matrix v = build(new double[][]{{4}, {5}, {6}});
        Matrix w = u.crossProduct(v);

        assertEquals(3, w.rows());
        assertEquals(1, w.columns());

        assertEquals((2*6 - 3*5), w.getEntry(0, 0), 0.0);
        assertEquals((3*4 - 1*6), w.getEntry(1, 0), 0.0);
        assertEquals((1*5 - 2*4), w.getEntry(2, 0), 0.0);

        assertEquals(1, u.getEntry(0, 0), 0.0);
        assertEquals(2, u.getEntry(1, 0), 0.0);
        assertEquals(3, u.getEntry(2, 0), 0.0);
        assertEquals(4, v.getEntry(0, 0), 0.0);
        assertEquals(5, v.getEntry(1, 0), 0.0);
        assertEquals(6, v.getEntry(2, 0), 0.0);
    }
}
