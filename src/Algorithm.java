import java.util.List;

public class Algorithm {

    private final int[][] initialMatrix;

    public Algorithm(int[][] matrix) {
        this.initialMatrix = matrix;
    }

    public void complete() {
        ReachableMatrixBuilder reachableMatrixBuilder = new ReachableMatrixBuilder(initialMatrix);

        int[][] reachableMatrix = reachableMatrixBuilder.build();

        OrderDeterminator orderDeterminator = new OrderDeterminator(reachableMatrixBuilder.raiseCounter, reachableMatrixBuilder.matrixList);

        //1, 2
        orderDeterminator.determineOrder();

        //3
        NotNullElementsInMainDiagonalChecker.check(reachableMatrix);

        //4
        List<Integer> inputElements = orderDeterminator.inputElements;
        System.out.println("4. Определение входных элементов потока: " + inputElements);

        //5
        List<Integer> outputElements = OutputElementsFinder.find(reachableMatrix);

        //6
        HangingVerticesDeterminator.determine(inputElements, outputElements);

        //7
        WayCounterDeterminator.determine(inputElements, outputElements, reachableMatrixBuilder.matrixList);

        //8
        AllWaysCounter.count(inputElements, outputElements, reachableMatrix);

        //9
        ElementsFormationDefinitor.get(reachableMatrix);
    }
}
