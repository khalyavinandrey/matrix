import java.util.*;

public class ElementsFormationDefinitor {

    public static Map<Integer, List<Integer>> get(int[][] matrix) {
        Map<Integer, List<Integer>> result = new LinkedHashMap<>();

        for (int j = 0; j < matrix[0].length - 1; j++) {
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i][j] != 0) {
                    List<Integer> list = result.getOrDefault(j + 1, new ArrayList<>());
                    list.add(i + 1);
                    result.put(j + 1, list);
                }
            }
        }

        System.out.println("9. Определение всех элементов, участвующих в формировании данного: " + result);

        return result;
    }
}
