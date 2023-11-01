public class NotNullElementsInMainDiagonalChecker {

    public static String check(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j && matrix[i][j] != 0) {
                    System.out.println("3. На главной диагонали есть ненулевые элементы");
                    return "3. На главной диагонали есть ненулевые элементы";
                }
            }
        }

        System.out.println("3. На главной диагонали все элементы нулевые");

        return "3. На главной диагонали все элементы нулевые";
    }
}
