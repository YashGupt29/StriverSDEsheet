import java.util.Arrays;

public class medium11 {
    public static void main(String[] args) {
        int [][] arr={{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(arr);


    }
    public static void setZeroes(int [][] matrix)
    {
        int n=matrix.length;;
        int m=matrix[0].length;
        int col0=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                if(matrix[i][j]==0)
                {

                    matrix[i][0]=0;
                    if(j!=0) {
                        matrix[0][j] = 0;
                    }
                    else {
                        col0=0;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <m ; j++) {
                if(matrix[0][j]==0 || matrix[i][0]==0)
                {
                    matrix[i][j]=0;
                }
            }

        }
        if(matrix[0][0]==0) {
            for (int i = 0; i < m; i++) {
                matrix[0][i]=0;
            }
        }
        if(col0==0)
        {
            for (int i = 0; i < n; i++) {
                matrix[i][0]=0;
            }
        }
        for (int[] rows : matrix) {
            System.out.println(Arrays.toString(rows));
        }

    }
    public static  void setZeroesBetter(int [][] matrix)
    {
        int n=matrix.length;;
        int m=matrix[0].length;
        int[] row = new int[n];
        int [] col=new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                if(matrix[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                if(row[i]==1 || col[j]==1 )
                {
                   matrix[i][j]=0;
                }
            }

        }
        for (int[] rows : matrix) {
            System.out.println(Arrays.toString(rows));
        }


    }
    public static  void setZeroesBrute(int[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(matrix[i][j]==0)
                {
                    markRow(matrix,i,m);
                    markCol(matrix,j,n);
                }

            }
        }
        for (int k = 0; k < n; k++) {
            for (int z = 0; z < m; z++) {
                if(matrix[k][z]==-893838)
                {
                    matrix[k][z]=0;
                }

            }

        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static void markRow(int [][] matrix,int i,int m)
    {
        for(int j=0;j<m;j++)
        {
            if(matrix[i][j]!=0)
            {
                matrix[i][j]=-893838;
            }

        }

    }
    public static void markCol(int[][] matrix,int j,int n)
    {  for(int i=0;i<n;i++)
        {
            if(matrix[i][j]!=0)
            {
                matrix[i][j]=-893838;
            }

        }

    }

}
