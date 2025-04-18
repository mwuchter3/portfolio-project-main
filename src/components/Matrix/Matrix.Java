package components.matrix;

/**
 * Matrix Interface.
 */
public interface Matrix extends MatrixKernel {

    /**
     * Adds another matrix to this matrix element-wise.
     *
     * @param mtrx the matrix to add
     * @requires mtrx.rows() == rows() and mtrx.columns() == columns()
     * @updates this
     * @ensures this.getEntry(i, j) == (this.getEntry(i, j)) + mtrx.getEntry(i, j)
     *  for all is and js.
     */
    void elementAdd(MatrixKernel mtrx);

    /**
     * Multiplies this matrix by another matrix element-wise.
     *
     * @param mtrx the matrix to multiply
     * @requires mtrx.rows() == rows() and mtrx.columns() == columns()
     * @updates this
     * @ensures this.getEntry(i, j) == (this.getEntry(i, j)) * mtrx.getEntry(i, j)
     *  for all is and js.
     */
    void elementMultiply(MatrixKernel mtrx);

    /**
     * Computes the matrix multiplication of this matrix and another matrix.
     *
     * @param mtrx the matrix to multiply with
     * @return a new matrix representing the product
     * @requires columns() == mtrx.rows()
     * @ensures this.rows() == rows() and result.columns() == mtrx.columns(),
     * a matrix following matrix mathmatical matrix multiplication.
     */
    Matrix matrixMultiply(MatrixKernel mtrx);

    /**
     * Computes the dot product of this matrix and another matrix by summing all
     * element-wise additions of their entries.
     *
     * @param mtrx the matrix to add element-wise
     * @return the sum of all entries after addition
     * @requires mtrx.rows() == rows() and mtrx.columns() == columns()
     * @ensures dotProduct is the sum of (this.getEntry(i, j) + mtrx.getEntry(i, j))
     *  for all is and js
     */
    double dotProduct(MatrixKernel mtrx);

    /**
     * Computes the cross product of this matrix and another matrix.
     *
     * @param mtrx the matrix (vector) to compute the cross product with
     * @return a new matrix representing the cross product
     * @requires rows() == 3 and columns() == 1 and mtrx.rows() == 3
     * and mtrx.columns() == 1
     * @ensures crossProduct.rows() == 3 and crossProduct.columns() == 1
     * and crossProduct follows the mathmatical matrix cross product.
     */
    Matrix crossProduct(MatrixKernel mtrx);
}
