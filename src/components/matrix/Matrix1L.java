package components.matrix;

/**
 * A 2D-array implementation of {@link Matrix}.
 *
 * @convention All rows in rep have the same length.
 * @correspondence this = matrix of size rows()×columns(), entry (i,j)=rep[i][j]
 */
public class Matrix1L extends MatrixSecondary {

    /** Representation of this matrix. */
    private double[][] rep;

    /**
     * Create a new representation of the given shape.
     *
     * @param rows number of rows in the new matrix
     * @param cols number of columns in the new matrix
     * @convention rows >= 0 and cols >= 0
     * @ensures rows() = rows && columns() = cols
     */
    private void createNewRep(int rows, int cols) {
        this.rep = new double[rows][cols];
    }

    /**
     * Default constructor: creates a 3×3 zero matrix.
     *
     * @ensures rows() = 3 && columns() = 3
     * @ensures (\forall int i, j; 0 <= i < 3 && 0 <= j < 3; getEntry(i,j) == 0.0)
     */
    public Matrix1L() {
        this(3, 3);
    }

    /**
     * Constructor from dimensions.
     *
     * @param rows number of rows
     * @param cols number of columns
     * @requires rows >= 0 && cols >= 0
     * @ensures rows() = rows && columns() = cols
     * @ensures (\forall int i,j; 0 <= i < rows && 0 <= j < cols; getEntry(i,j) == 0.0)
     */
    public Matrix1L(int rows, int cols) {
        assert rows >= 0 : "Violation of: rows >= 0";
        assert cols >= 0 : "Violation of: cols >= 0";
        this.createNewRep(rows, cols);
    }

    /**
     * Creates a new instance of the same dynamic type and shape as this matrix.
     *
     * @return a new Matrix with the same number of rows and columns as this
     * @ensures newInstance().rows() = this.rows()
     *          && newInstance().columns() = this.columns()
     */
    public Matrix newInstance() {
        return new Matrix1L(this.rows(), this.columns());
    }

    /**
     * Sets all entries of this matrix to zero.
     *
     * @updates this
     * @ensures (\forall int i, j; 0 <= i < rows() && 0 <= j < columns(); getEntry(i,j) == 0.0)
     */
    public void clear() {
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                this.rep[i][j] = 0.0;
            }
        }
    }

    /**
     * Destroys the source matrix and transfers its representation to this.
     *
     * @param source the matrix to transfer from
     * @updates this, source
     * @requires source != null
     * @ensures this = #source
     * @ensures source = matrix of size 0×0
     */
    public void transferFrom(Matrix source) {
        Matrix1L src = (Matrix1L) source;
        this.rep = src.rep;
        src.createNewRep(0, 0);
    }

    /**
     * Changes the entry at (r, c) to the specified value.
     *
     * @param r the row index
     * @param c the column index
     * @param value the new value
     * @requires 0 <= r < rows() && 0 <= c < columns()
     * @updates this
     * @ensures getEntry(r, c) = value
     */
    @Override
    public void changeEntry(int r, int c, double value) {
        this.rep[r][c] = value;
    }

    /**
     * Returns the entry at (r, c).
     *
     * @param r the row index
     * @param c the column index
     * @return the value at (r, c)
     * @requires 0 <= r < rows() && 0 <= c < columns()
     * @ensures changeEntry(r, c, \result)
     */
    @Override
    public double getEntry(int r, int c) {
        return this.rep[r][c];
    }

    /**
     * Returns the number of rows.
     *
     * @return number of rows
     * @ensures \result = rep.length
     */
    @Override
    public int rows() {
        return this.rep.length;
    }

    /**
     * Returns the number of columns.
     *
     * @return number of columns
     * @ensures rep.length == 0 ? \result = 0 : \result = rep[0].length
     */
    @Override
    public int columns() {
        return this.rep.length == 0 ? 0 : this.rep[0].length;
    }
}
