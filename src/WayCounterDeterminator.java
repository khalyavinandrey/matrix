import java.util.ArrayList;
import java.util.List;

public class WayCounterDeterminator {

    public static List<List<String>> determine(List<Integer> inputElements,
                                                List<Integer> outputElements,
                                                List<int[][]> matrixList) {

        List<List<String>> result = new ArrayList<>();

        for (int lambda = 1; lambda <= matrixList.size(); lambda++) {
            int[][] matrix = matrixList.get(lambda - 1);

            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (inputElements.contains(i + 1) && outputElements.contains(j + 1) && matrix[i][j] == lambda) {
                        result.add(List.of("i: " + (i + 1) + ", j: " + (j + 1) + ", lambda: " + lambda + ", количество путей: " + (matrix[i][j])));
                    }
                }
            }
        }

        System.out.println("7. Определение числа путей длиной lambda: " + result);

        return result;
    }
}
