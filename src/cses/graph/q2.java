package cses.graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2 {
    static class Triplet{
        int x,y,path;
        Triplet(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static int [] dx={1,-1,0,0};
    static int [] dy={0,0,1,-1};
    static char [] directions={'D','U','R','L'};
    public static boolean check(int x,int y,int n,int m)
    {
        return x<n && y<m && x>=0 && y>=0;
    }
    public static void solve(int n, int m, char[][] arr) {
         Queue<Triplet> queue=new LinkedList<>();
         int [][] dist=new int[n][m];
         char [][] move=new char[n][m];
         for(int [] v:dist)
         {
             Arrays.fill(v,Integer.MAX_VALUE);
         }
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 if(arr[i][j]=='A')
                 {
                     dist[i][j]=0;
                     queue.add(new Triplet(i,j));
                     break;
                 }
             }
         }
         while(!queue.isEmpty())
         {
             Triplet node=queue.poll();
             int x=node.x;
             int y=node.y;
             for (int i = 0; i < 4; i++) {
                 int newX=x + dx[i];
                 int newY=y + dy[i];
                 if(check(newX,newY,n,m) && dist[newX][newY]>dist[x][y]+1 && arr[newX][newY]!='#') {
                     move[newX][newY]=directions[i];
                     dist[newX][newY] = dist[x][y] + 1;
                     queue.add(new Triplet(newX, newY));
                     if(arr[newX][newY]=='B')
                     {
                         System.out.println("YES");
                         System.out.println(dist[newX][newY]);
                         StringBuilder path=new StringBuilder();
                         int pathx=newX;
                         int pathy=newY;
                         while(arr[pathx][pathy]!='A')
                         {
                             path.append(move[pathx][pathy]);
                             if(move[pathx][pathy]=='U')
                             {
                                 pathx++;
                             } else if (move[pathx][pathy]=='D') {
                                 pathx--;
                             }
                             else if(move[pathx][pathy]=='R')
                             {
                                 pathy--;
                             } else if (move[pathx][pathy]=='L') {
                                 pathy++;
                             }
                         }
                         System.out.println(path.reverse().toString());
                         return;
                     }
                 }
             }
         }
        System.out.println("NO");

        }

        public static void main(String[] args) throws IOException {

            int n = InputReader.nextInt();
            int m = InputReader.nextInt();

            char [][] arr = InputReader.nextChar2DArray(n,m);

            solve(n, m, arr);
        }

        static class InputReader {

            private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            private static StringTokenizer st;

            public static String next() throws IOException {
                if (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            }

            public static int nextInt() throws IOException {
                return Integer.parseInt(next());
            }

            public static long nextLong() throws IOException {
                return Long.parseLong(next());
            }

            public static double nextDouble() throws IOException {
                return Double.parseDouble(next());
            }

            public static int[] nextIntArray(int n) throws IOException {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = nextInt();
                }
                return arr;
            }

            public static long[] nextLongArray(int n) throws IOException {
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = nextLong();
                }
                return arr;
            }

            public static int[][] nextInt2DArray(int rows, int cols) throws IOException {
                int[][] arr = new int[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        arr[i][j] = nextInt();
                    }
                }
                return arr;
            }

            public static long[][] nextLong2DArray(int rows, int cols) throws IOException {
                long[][] arr = new long[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        arr[i][j] = nextLong();
                    }
                }
                return arr;
            }
            public static char[][] nextChar2DArray(int rows, int cols) throws IOException {
                char[][] grid = new char[rows][cols];
                for (int i = 0; i < rows; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < cols; j++) {
                        grid[i][j] = line.charAt(j);
                    }
                }
                return grid;
            }
        }
}
