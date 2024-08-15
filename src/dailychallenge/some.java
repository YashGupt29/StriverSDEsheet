package dailychallenge;

public class some {
    public static void main(String[] args) {
        int [][] arr={{1,0,1},{0,0,0},{0,0,0},{0,0,1}};
        System.out.println(minFlips(arr));

    }

        public static int minFlips(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int rowFlips = 0;
            int colFlips = 0;

            // Count flips needed for rows
            for (int i = 0; i < m; i++) {
                rowFlips += countFlipsForPalindrome(grid[i]);
            }

            // Count flips needed for columns
//            for (int j = 0; j < n; j++) {
//                int[] colArray = new int[m];
//                for (int i = 0; i < m; i++) {
//                    colArray[i] = grid[i][j];
//                }
//                colFlips += countFlipsForPalindrome(colArray);
//            }

            // Total flips required to make all rows and columns palindromic
            int totalFlips = rowFlips ;

            // Count total number of 1's in the grid
            int totalOnes = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    totalOnes += grid[i][j];
                }
            }

            // Calculate additional flips needed to make total number of 1's divisible by 4
            int remainder = totalOnes % 4;
            int additionalFlips = 0;
            if (remainder != 0) {
                additionalFlips = 4 - remainder;
            }

            // Return total flips plus additional flips needed for divisibility by 4
            return Math.min(totalFlips + additionalFlips,totalOnes);
        }

        private static int countFlipsForPalindrome(int[] arr) {
            int flips = 0;
            int length = arr.length;
            for (int i = 0; i < length / 2; i++) {
                if (arr[i] != arr[length - i - 1]) {
                    flips++;
                }
            }
            return flips;
        }


}


