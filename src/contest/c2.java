import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c2 {

    public static int countOperations(int[][] matrix) {
        int n = matrix.length;
        int operationCount = 0;

        // Step 1: Change negative values in the main diagonal to 0
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] < 0) {
                operationCount++;  // Operation to change negative to 0
                matrix[i][i] = 0;
            }
        }

        // Step 2: Process the matrix for negative values in other cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    operationCount=operationCount + (-matrix[i][j]);  // Operation to make it non-zero
                    matrix[i][j] = 0;  // Change negative to 1
                }
            }
        }

        return operationCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());  // Number of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());  // Size of the square matrix

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            // Count the operations needed for the current matrix
            int result = countOperations(matrix);
            System.out.println(result);
        }
    }
}
