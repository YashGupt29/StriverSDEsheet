package graphStriver.dsu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class c5 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},{1,1,0,1,1},{1,1,0,1,1},{0,0,1,0,0},{0,0,1,1,1},{0,0,1,1,1}};
        System.out.println(largestIsland(grid));  // Output should be 3
    }
    public static boolean check(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int noOfCells = n * m;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        UnionFind dsu = new UnionFind(noOfCells);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) continue;
                for (int i = 0; i < 4; i++) {
                    int nx = row + dx[i];
                    int ny = col + dy[i];
                    if (check(nx, ny, n, m) && grid[nx][ny] == 1) {
                        int nodeNo = row * m + col;
                        int adjNo = nx * m + ny;
                        dsu.merge(nodeNo, adjNo);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dsu.par));
        System.out.println(Arrays.toString(dsu.rank));
        int largestIslandSize = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    largestIslandSize = Math.max(largestIslandSize, dsu.rank[dsu.find(row * m + col)]);
                }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) continue;
                Set<Integer> components = new HashSet<>();
                int newSize = 1;
                for (int i = 0; i < 4; i++) {
                    int nx = row + dx[i];
                    int ny = col + dy[i];
                    if (check(nx, ny, n, m) && grid[nx][ny] == 1) {
                        int componentId = dsu.find(nx * m + ny);
                        if (!components.contains(componentId)) {
                            components.add(componentId);
                            newSize += dsu.rank[componentId];
                        }
                    }
                }
                largestIslandSize = Math.max(largestIslandSize, newSize);
            }
        }
        return largestIslandSize;
    }
}
