import java.util.ArrayList;
import java.util.List;

public class HangingVerticesDeterminator {

    public static List<Integer> determine(List<Integer> inputElements, List<Integer> outputElements) {

        List<Integer> inputs = new ArrayList<>(inputElements);
        List<Integer> outputs = new ArrayList<>(outputElements);

        inputs.retainAll(outputs);

        if (inputElements.isEmpty()) {
            System.out.println("6. Определение висящих вершин: висящих вершин нет");
        } else {
            System.out.println("6. Определение висящих вершин: " + inputs);
        }

        return inputs;
    }
}
