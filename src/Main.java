import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] A = {{1, 8, 3, 4, 0},
                     {6, 7, 2, 7, 0}};

        int[][] B = {{3, 5, 6, 7, 7},
                    {4, 2, 2, 8, 9},
                    {6, 3, 2, 9, 7}};

        int[][] C = {{12, 2, 4},
                {17, 10, 1},
                {92, 80, 79}};

        peakColumns(A);
        peakColumns(B);
        peakColumns(C);
    }

    private static void peakColumns(int[][] inputArray) {
/*       get max element in subArray
         get index of max element in subArray
         if max element is the minimum in its column print it and its index
          */

        try {
            for (int i = 0; i < inputArray.length; i++) {
                int maxElementInRow = Arrays.stream(inputArray[i]).max().orElse(0);

                for (int j = 0; j < inputArray[i].length; j++) {
                    if (inputArray[i][j] >= maxElementInRow) {
                        var temp = new ArrayList<Integer>();
                        for (int[] element : inputArray) {
                            temp.add(element[j]);
                        }

                        var minElementInColumn = temp.stream().min(Integer::compareTo).get();
                        if (maxElementInRow <= minElementInColumn)
                            System.out.printf("(%s,%s) = %s", i + 1, j + 1, maxElementInRow);

                        System.out.println();
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Ensure given matrix is in the right form");
        }
    }

}