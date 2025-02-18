/**
 * ProofOfConcept.
 */
public class Matrix {
    /**
     * The array of arrays of doubles.
     */
    private final double[][] matrix;

    /**
     * Constructor to initialize the matrix.
     * @param rows Number of rows.
     * @param cols Number of columns.
     */
    public Matrix(int rows, int cols) {
        this.matrix = new double[rows][cols];
    }

    /**
     * Change an entry in the matrix.
     * @param r Row index.
     * @param c Column index.
     * @param value New value to set.
     */
    public void changeEntry(int r, int c, double value) {
        assert (r >= 0 && r < this.matrix.length);
        assert (c >= 0 && c < this.matrix[0].length);

        this.matrix[r][c] = value;
    }

    /**
     * Get an entry in the matrix.
     * @param r Row index.
     * @param c Column index.
     *
     * @return A double of the number at r and c.
     */
    public double getEntry(int r, int c) {
        assert (r >= 0 && r < this.matrix.length);
        assert (c >= 0 && c < this.matrix[0].length);

        return this.matrix[r][c];
    }

    /**
     * Get number of rows in a Matrix.
     * @return Returns the number of rows.
     */
    public int rows() {
        return this.matrix.length;
    }

    /**
     * Get number of columns in a Matrix.
     * @return Returns the number of rows.
     *
     * @requires this to have atleast one row.
     */
    public int columns() {
        return this.matrix[0].length;
    }

    /**
     * Add two matrices togther.
     * @param mtrx Matrix to add to this
     *
     * @requires this and mtrx to have the same number of columns and rows as each other.
     */
    public void elementAdd(Matrix mtrx) {
        for (int r = 0; r < this.rows(); r++) {
            for (int c = 0; c < this.columns(); c++) {
                double thisElement = this.getEntry(r, c);
                double mtrxElement = mtrx.getEntry(r, c);
                this.changeEntry(r, c, thisElement + mtrxElement);
            }
        }
    }

    /**
     * Calculate the dot product of two matrices.
     * @param mtrx Matrix to calculate dot product with this
     *
     * @return A double value of the dot product.
     *
     * @requires this and mtrx to have the same number of columns and rows as each other.
     */
    public double dotProduct(Matrix mtrx) {
        double sum = 0;
        for (int r = 0; r < this.rows(); r++) {
            for (int c = 0; c < this.columns(); c++) {
                sum += (this.getEntry(r, c)  + mtrx.getEntry(r, c));
            }
        }
        return sum;
    }


    /**
     * Just for testing to see the matrix.
     */
    public void printMatrix() {
        for (double[] row : this.matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }


    /**
     * Main function.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Matrix mat = new Matrix(3, 3);
        mat.changeEntry(0, 0, 1.0);
        mat.changeEntry(1, 1, 5.0);
        mat.changeEntry(2, 2, 10.0);
        mat.changeEntry(1, 2, 7.0);
        mat.printMatrix();

        Matrix mat2 = new Matrix(3, 3);
        mat2.changeEntry(0, 0, 1.0);
        mat2.changeEntry(1, 1, 2);
        mat2.changeEntry(2, 2, 3);
        mat2.changeEntry(2, 1, 4);
        mat2.printMatrix();
        mat.elementAdd(mat2);
        mat.printMatrix();

        System.out.println(mat.dotProduct(mat2));
    }
}
