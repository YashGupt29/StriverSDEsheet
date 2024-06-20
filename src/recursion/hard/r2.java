package recursion.hard;

public class r2 {
    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(arr,"ABCB"));

    }
    public static boolean exist(char[][] board, String word) {
        int index=0;
        int m=board.length;
        int n=board[0].length;

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==word.charAt(index))
                {
                   if(search(board,index,i,j,word,m,n))
                   {
                       return true;

                   }
                }
            }

        }
        return false;
    }
    public static  boolean search(char [][] board,int index,int row,int col,String word,int m,int n)
    {
        if(index==word.length())
        {
            return true;
        }

        if(row< 0 || col< 0|| row ==m ||col==n||board[row][col]!=word.charAt(index) || board[row][col]=='1')
        {
            return false;
        }
        char c=board[row][col];
        board[row][col]='!';
        boolean top=search(board,index+1,row-1,col,word,m,n);
        boolean bottom=search(board,index+1,row+1,col,word,m,n);
        boolean right =search(board,index+1,row,col+1,word,m,n);
        boolean left=search(board,index+1,row,col-1,word,m,n);
        board[row][col]=c;
        return top || bottom || right || left;



    }
}
