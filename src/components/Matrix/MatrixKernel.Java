public interface MatrixKernel extends Standard {

    /**
     * Changes the entry at the specified row and column to the given value.
     *
     * @param r the row index
     * @param c the column index
     * @param value the new value to set
     * @requires 0 <= r < rows() and 0 <= c < columns()
     * @ensures getEntry(r, c) == value, entry at r,c is now value
     */
    void changeEntry(int r, int c, double value);

    /**
     * Returns the entry at the specified row and column.
     *
     * @param r the row index
     * @param c the column index
     * @return the value at (r, c)
     * @requires 0 <= r < rows() and 0 <= c < columns()
     * @ensures getEntry == this.getEntry(r, c)
     */
    double getEntry(int r, int c);

    /**
     * Returns the number of rows in the matrix.
     *
     * @return the number of rows
     * @ensures rows >= 0
     */
    int rows();

    /**
     * Returns the number of columns in the matrix.
     *
     * @return the number of columns
     * @ensures columns >= 0
     */
    int columns();
}