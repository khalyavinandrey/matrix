import java.util.ArrayList;
import java.util.List;

public class AllWaysCounter {

    public static List<List<String>> count(List<Integer> inputElements,
                                           List<Integer> outputElements,
                                           int[][] matrix) {

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (inputElements.contains(i + 1) && outputElements.contains(j + 1) && matrix[i][j] != 0) {
                    result.add(List.of("от i: " + (i + 1) + " до j: " + (j + 1) + " есть " + matrix[i][j] + " путей"));
                }
            }
        }

        System.out.println("8. Определение всевозможных путей между двумя элементами: " + result);

        return result;
    }
}
