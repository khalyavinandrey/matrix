import java.util.ArrayList;
import java.util.List;

public class OutputElementsFinder {

    public static List<Integer> find(int[][] matrix) {
        List<Integer> outputElements = new ArrayList<>();
        int lastColumn = matrix[0].length - 1;

        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][lastColumn] == 0) {
                outputElements.add(i + 1);
            }
        }

        System.out.println("5. Определение выходных элементов потока: " + outputElements);

        return outputElements;
    }
}
