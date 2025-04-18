package components.matrix;

/**
 * Default implementations of all enhanced Matrix operations.
 * Provides element-wise and algebraic methods based on the kernel.
 */
public abstract class MatrixSecondary implements Matrix {

    /**
     * Adds another matrix to this matrix element-wise.
     *
     * @param mtrx the matrix to add
     * @requires mtrx.rows() == rows() && mtrx.columns() == columns()
     * @updates this
     * @ensures this.getEntry(i, j) == \old(this.getEntry(i, j)) + mtrx.getEntry(i, j)
     */
    @Override
    public void elementAdd(MatrixKernel mtrx) {
        assert this.rows() == mtrx.rows();
        assert this.columns() == mtrx.columns();
        for (int r = 0; r < this.rows(); r++) {
            for (int c = 0; c < this.columns(); c++) {
                double sum = this.getEntry(r, c) + mtrx.getEntry(r, c);
                this.changeEntry(r, c, sum);
            }
        }
    }

    /**
     * Multiplies this matrix by another matrix element-wise.
     *
     * @param mtrx the matrix to multiply
     * @requires mtrx.rows() == rows() && mtrx.columns() == columns()
     * @updates this
     * @ensures this.getEntry(i, j) == \old(this.getEntry(i, j)) * mtrx.getEntry(i, j)
     */
    @Override
    public void elementMultiply(MatrixKernel mtrx) {
        assert this.rows() == mtrx.rows();
        assert this.columns() == mtrx.columns();
        for (int r = 0; r < this.rows(); r++) {
            for (int c = 0; c < this.columns(); c++) {
                double prod = this.getEntry(r, c) * mtrx.getEntry(r, c);
                this.changeEntry(r, c, prod);
            }
        }
    }

    /**
     * Computes the matrix multiplication of this matrix and another matrix.
     *
     * @param mtrx the matrix to multiply with
     * @return a new matrix representing the product
     * @requires this.columns() == mtrx.rows()
     * @ensures \result.rows() == this.rows() && \result.columns() == mtrx.columns()
     */
    @Override
    public Matrix matrixMultiply(MatrixKernel mtrx) {
        assert this.columns() == mtrx.rows();
        int outRows    = this.rows();
        int outCols    = mtrx.columns();
        int commonDim  = this.columns();
        Matrix out = this.newInstance();
        out.transferFrom(new Matrix1L(outRows, outCols));
        for (int i = 0; i < outRows; i++) {
            for (int j = 0; j < outCols; j++) {
                double sum = 0.0;
                for (int k = 0; k < commonDim; k++) {
                    sum += this.getEntry(i, k) * mtrx.getEntry(k, j);
                }
                out.changeEntry(i, j, sum);
            }
        }
        return out;
    }

    /**
     * Computes the dot (Frobenius) product of this matrix and another.
     *
     * @param mtrx the matrix to dot-multiply
     * @return sum of element-wise products
     * @requires mtrx.rows() == rows() && mtrx.columns() == columns()
     */
    @Override
    public double dotProduct(MatrixKernel mtrx) {
        assert this.rows() == mtrx.rows();
        assert this.columns() == mtrx.columns();
        double sum = 0.0;
        for (int r = 0; r < this.rows(); r++) {
            for (int c = 0; c < this.columns(); c++) {
                sum += this.getEntry(r, c) * mtrx.getEntry(r, c);
            }
        }
        return sum;
    }

    /**
     * Computes the 3×1 cross product of this matrix and another.
     *
     * @param mtrx the 3×1 vector matrix to cross with
     * @return a new 3×1 matrix of the cross product
     * @requires rows() == 3 && columns() == 1
     *           && mtrx.rows() == 3 && mtrx.columns() == 1
     */
    @Override
    public Matrix crossProduct(MatrixKernel mtrx) {
        assert this.rows() == 3 && this.columns() == 1;
        assert mtrx.rows() == 3 && mtrx.columns() == 1;
        double a0 = this.getEntry(0, 0);
        double a1 = this.getEntry(1, 0);
        double a2 = this.getEntry(2, 0);
        double b0 = mtrx.getEntry(0, 0);
        double b1 = mtrx.getEntry(1, 0);
        double b2 = mtrx.getEntry(2, 0);
        Matrix out = this.newInstance();
        out.transferFrom(new Matrix1L(3, 1));
        out.changeEntry(0, 0, a1 * b2 - a2 * b1);
        out.changeEntry(1, 0, a2 * b0 - a0 * b2);
        out.changeEntry(2, 0, a0 * b1 - a1 * b0);
        return out;
    }
}
