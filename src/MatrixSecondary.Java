public abstract class MatrixSecondary implements Matrix {
    /**
     * Adds another matrix to this matrix element-wise.
     *
     * @param mtrx the matrix to add
     * @requires mtrx.rows() == rows() and mtrx.columns() == columns()
     * @updates this
     * @ensures this.getEntry(i, j) == (this.getEntry(i, j)) + mtrx.getEntry(i, j) for all is and js.
     */
    void elementAdd(MatrixKernel mtrx){
        assert this.rows() == mtrx.rows;
        
        int rows = mtrx.rows();
        int columns = mtrx.columns();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                double newEntry = this.getEntry(r, c) + mtrx.getEntry(r, c);
                this.changeEntry(r, c, newEntry);
            }
        }
    }

    /**
     * Multiplies this matrix by another matrix element-wise.
     *
     * @param mtrx the matrix to multiply
     * @requires mtrx.rows() == rows() and mtrx.columns() == columns()
     * @updates this
     * @ensures this.getEntry(i, j) == (this.getEntry(i, j)) * mtrx.getEntry(i, j) for all is and js.
     */
    void elementMultiply(Matrix mtrx){
        assert this.rows() == mtrx.rows;

        int rows = mtrx.rows();
        int columns = mtrx.columns();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                double newEntry = this.getEntry(r, c) * mtrx.getEntry(r, c);
                this.changeEntry(r, c, newEntry);
            }
        }
    }

    /**
     * Computes the matrix multiplication of this matrix and another matrix.
     *
     * @param mtrx the matrix to multiply with
     * @return a new matrix representing the product
     * @requires columns() == mtrx.rows()
     * @ensures this.rows() == rows() and result.columns() == mtrx.columns(), a matrix following matrix mathmatical matrix multiplication.
     */
    MatrixEnhanced matrixMultiply(Matrix mtrx){
        assert this.columns() == mtrx.rows();

        int thisRows = this.rows();
        int mtrxColumns = mtrx.columns();
        int commonNum = this.columns();

        Matrix result = new Matrix(thisRows, mtrxColumns);

        for (int i = 0; i < thisRows; i++) {
            for (int j = 0; j < mtrxColumns; j++) {
                double sum = 0.0;
                for (int k = 0; k < commonNum; k++) {
                    sum += this.getEntry(i, k) * mtrx.getEntry(k, j);
                }
                result.changeEntry(i, j, sum);
            }
        }

        return result;
    }

    /**
     * Computes the dot product of this matrix and another matrix by summing all
     * element-wise additions of their entries.
     *
     * @param mtrx the matrix to add element-wise
     * @return the sum of all entries after addition
     * @requires mtrx.rows() == rows() and mtrx.columns() == columns()
     * @ensures dotProduct is the sum of (this.getEntry(i, j) + mtrx.getEntry(i, j)) for all is and js
     */
    double dotProduct(Matrix mtrx){
        assert this.rows() == mtrx.rows;

        int rows = mtrx.rows();
        int columns = mtrx.columns();

        double sum = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                sum += this.getEntry(r, c) * mtrx.getEntry(r, c);
            }
        }

        return sum;
    }

    /**
     * Computes the cross product of this matrix and another matrix.
     *
     * @param mtrx the matrix (vector) to compute the cross product with
     * @return a new matrix representing the cross product
     * @requires rows() == 3 and columns() == 1 and mtrx.rows() == 3 and mtrx.columns() == 1
     * @ensures crossProduct.rows() == 3 and crossProduct.columns() == 1 and crossProduct follows the mathmatical matrix cross product.
     */
    MatrixEnhanced crossProduct(Matrix mtrx){
        assert this.rows() == 3 && this.columns() == 1;
        assert mtrx.rows() == 3 && mtrx.columns() == 1;

        double a0 = this.getEntry(0, 0);
        double a1 = this.getEntry(1, 0);
        double a2 = this.getEntry(2, 0);

        double b0 = mtrx.getEntry(0, 0);
        double b1 = mtrx.getEntry(1, 0);
        double b2 = mtrx.getEntry(2, 0);

        MatrixEnhanced result = new MatrixEnhanced(3, 1);
        result.changeEntry(0, 0, a1 * b2 - a2 * b1);
        result.changeEntry(1, 0, a2 * b0 - a0 * b2);
        result.changeEntry(2, 0, a0 * b1 - a1 * b0);

        return result;
    }
 }
