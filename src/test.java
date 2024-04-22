public class test {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };



        System.out.println(numIslands(grid));

    };



    public static int numIslands(char[][] grid) {
        if (grid.length == 1) {
            return firstRow(grid);
        }
        int count = 0; // Initialize count to 0
        if(grid[0][0]=='1') count=1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && i > 0 && j > 0 && grid[i - 1][j] != '1' && grid[i][j - 1] != '1') {
                    count++;
                }
            }
        }
        return count;
    }

    public static int firstRow(char[][] grid) {
        if (grid[0].length == 1) { // Check if there's only one element in the grid
            return grid[0][0] == '1' ? 1 : 0;
        }
        int count = 0;
        if (grid[0][0] == '1') {
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[0][i] == '0') {
                    count++;
                }
            }
        }
        if (grid[0][grid[0].length - 1] == '1') {
            count++;
        }
        return count;
    }


}
