package components.matrix;

public class MatrixUsageExample2 {

    public static void main(String[] args) {
        Matrix vectorA = new Matrix1L(3, 1);
        Matrix vectorB = new Matrix1L(3, 1);

        vectorA.changeEntry(0, 0, 1.0);
        vectorA.changeEntry(1, 0, 2.0);
        vectorA.changeEntry(2, 0, 3.0);

        vectorB.changeEntry(0, 0, 4.0);
        vectorB.changeEntry(1, 0, 5.0);
        vectorB.changeEntry(2, 0, 6.0);

        Matrix cross = vectorA.crossProduct(vectorB);

        System.out.println("Cross product of two 3x1 vectors:");
        for (int i = 0; i < cross.rows(); i++) {
            System.out.println(cross.getEntry(i, 0));
        }
    }
}