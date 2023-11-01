import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReachableMatrixBuilder {

    public final List<int[][]> matrixList;

    public final int[][] initialMatrix;

    public int raiseCounter;

    public ReachableMatrixBuilder(int[][] initialMatrix) {
        this.matrixList = new ArrayList<>();
        this.initialMatrix = initialMatrix;
        add(initialMatrix);
    }

    public int[][] build() {
        int[][] matrixToUpdate = initialMatrix;

        do {
            matrixList.add(matrixToUpdate);
            matrixToUpdate = raise(matrixToUpdate);
            raiseCounter++;
        } while (!isMatrixNull(matrixToUpdate));

        int[][] reachabilityMatrix = buildReachabilityMatrix();

        printMatrix(reachabilityMatrix);

        return reachabilityMatrix;
    }

    public int[][] raise(int[][] matrix) {
        int[][] result = new int[matrix.length][initialMatrix[0].length];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < initialMatrix[0].length - 1; j++) {
                for (int k = 0; k < matrix[0].length - 1; k++) {
                    result[i][j] += matrix[i][k] * initialMatrix[k][j];
                }
            }
        }

        add(result);

        return result;
    }

    public boolean isMatrixNull(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printMatrix(int[][] matrix) {
        System.out.println("Матрица достижимости:");

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void add(int[][] matrix) {
        Map<Integer, Integer> sumForColumn = new HashMap<>();

        for (int i = 0; i < matrix[i].length; ++i) {
            int sumForRow = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                sumForRow += matrix[i][j];

                if (j == matrix[i].length - 1) {
                    matrix[i][j] = sumForRow;
                    break;
                }

                sumForColumn.put(j, sumForColumn.getOrDefault(j, 0) + matrix[i][j]);
            }

            if (i == matrix.length - 1) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = sumForColumn.getOrDefault(j, 0);
                }
                break;
            }
        }
    }

    public int[][] buildReachabilityMatrix() {
        int[][] result = new int[initialMatrix.length][initialMatrix[0].length];

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result[i].length - 1; j++) {
                int resultForRowAndColumn = 0;

                for (int[][] matrix : matrixList) {
                    resultForRowAndColumn += matrix[i][j];
                }

                result[i][j] = resultForRowAndColumn;
            }
        }

        add(result);

        return result;
    }
}
