import java.util.*;

public class OrderDeterminator {

    public Map<Integer, Integer> columnToOrder = new HashMap<>();
    public int raiseCounter;
    public List<int[][]> matrixList;

    public List<Integer> inputElements;

    public OrderDeterminator(int raiseCounter, List<int[][]> matrixList) {
        this.raiseCounter = raiseCounter;
        this.matrixList = matrixList;

        for (int i = 1; i < matrixList.get(0).length; i++) {
            columnToOrder.put(i, 0);
        }
    }

    public void determineOrder() {
        for (int i = 0; i <= raiseCounter; i++) {
            function(i);
        }

        System.out.println("1. Определение порядка элементов: " + columnToOrder);

        System.out.println("2. Определение «тактности» системы: " + raiseCounter);
    }

    public void function(int pi) {
        List<Integer> firstSuitableElementsOfColumns = findSuitableElementsOfColumns(pi, pi);
        List<Integer> secondSuitableElementsOfColumns = findSuitableElementsOfColumns(pi + 1, pi);

        firstSuitableElementsOfColumns.retainAll(secondSuitableElementsOfColumns);

        if (pi == 0) {
            inputElements = secondSuitableElementsOfColumns;
        }

        firstSuitableElementsOfColumns.forEach((elem) -> {
            columnToOrder.put(elem, pi);
        });
    }

    public int[] getLastElementsOfColumns(int lambda) {

        int[][] matrix;

        try {
            matrix = matrixList.get(lambda);
        } catch (IndexOutOfBoundsException e) {
            return new int[matrixList.get(0).length - 1];
        }

        return matrix[matrix.length - 1];
    }

    public List<Integer> findSuitableElementsOfColumns(int lambda, int pi) {
        if (lambda == 0) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < matrixList.get(0).length - 1; i++) {
                list.add(i + 1);
            }

            return list;
        }

        List<Integer> result = new ArrayList<>();

        boolean isGreater = lambda > pi;

        for (int i = 0; i < getLastElementsOfColumns(lambda - 1).length - 1; i++) {
            int elem = getLastElementsOfColumns(lambda - 1)[i];

            if ((elem == 0 && isGreater) || (elem > 0 && !isGreater)) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
