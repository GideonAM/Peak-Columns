import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter number of rows for matrix");
        Scanner userInput = new Scanner(System.in);
        int rowOneInput = userInput.nextInt();

        System.out.println("Enter number of columns for matrix");
        int columnOneInput = userInput.nextInt();
        int[][] matrix = new int[rowOneInput][columnOneInput];

        // for inserting elements into matrix
        System.out.println("Enter matrix elements one row at a time: ");
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = userInput.nextInt();

        System.out.println("Input 2D array " + Arrays.deepToString(matrix));
        peakColumns(matrix);
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
            System.out.println("Ensure given matrix is in the right form with numbers only");
        }
    }

}