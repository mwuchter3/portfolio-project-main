package components.matrix;

public class MatrixUsageExample1 {

    public static void main(String[] args) {
        Matrix matA = new Matrix1L(2, 2);
        Matrix matB = new Matrix1L(2, 2);

        matA.changeEntry(0, 0, 1.0);
        matA.changeEntry(0, 1, 2.0);
        matA.changeEntry(1, 0, 3.0);
        matA.changeEntry(1, 1, 4.0);

        matB.changeEntry(0, 0, 5.0);
        matB.changeEntry(0, 1, 6.0);
        matB.changeEntry(1, 0, 7.0);
        matB.changeEntry(1, 1, 8.0);

        matA.elementAdd(matB);

        System.out.println("Result of element-wise addition:");
        for (int i = 0; i < matA.rows(); i++) {
            for (int j = 0; j < matA.columns(); j++) {
                System.out.print(matA.getEntry(i, j) + " ");
            }
            System.out.println();
        }
    }
}

