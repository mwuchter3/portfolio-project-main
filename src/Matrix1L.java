
/**
 * Matrix represented as a 2D array of doubles with
 * implementations of primary methods.
 *
 * @convention
 * [All rows in this.rep have the same length]
 * and for all i, j: [rep[i][j] is a valid double]
 *
 * @correspondence
 * this = [matrix with rows = rep.length, columns = rep[0].length,
 *         where entry (i, j) = rep[i][j]]
 */
public class Matrix1L extends MatrixSecondary {

    /**
     * Representation of {@code this}.
     */
    private double[][] rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep(int rows, int cols) {
        this.rep = new double[rows][cols];
    }

    /**
     * No-argument constructor.
     */
    public Matrix1L() {
        this.createNewRep(3, 3);
    }

    /**
     * Constructor from dimensions.
     *
     * @param rows
     *            number of rows
     * @param cols
     *            number of columns
     */
    public Matrix1L(int rows, int cols) {
        assert rows >= 0 : "Violation of: rows >= 0";
        assert cols >= 0 : "Violation of: cols >= 0";

        this.createNewRep(rows, cols);
    }

    @Override
    public final Matrix newInstance() {
        return new Matrix1L(this.rows(), this.columns());
    }

    @Override
    public final void clear() {
        for (int i = 0; i < rep.length; i++) {
            for (int j = 0; j < rep[i].length; j++) {
                rep[i][j] = 0.0;
            }
        }
    }

    @Override
    public final void transferFrom(Matrix source) {
        this.createNewRep(source.rows(), source.columns());

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                rep[i][j] = source[i][j];
            }
        }
    }

    @Override
    public final void setElement(int row, int col, double value) {
        rep[row][col] = value;
    }

    @Override
    public final double getElement(int row, int col) {
        return rep[row][col];
    }

    @Override
    public final int rows() {
        return rep.length;
    }

    @Override
    public final int columns() {
        int result = 0;
        if (rep.length > 1) {
            result = rep[0].length;
        }
        return result;
    }

}