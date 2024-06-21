package recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class r3 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));

    }
    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> ans=new ArrayList<>();
        char [][] board=new char[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        helper(ans,board,0);
        return ans;
    }
    public static void helper(List<List<String>> ans,char [][] board,int col)
    {
        if(col==board[0].length)
        {
            ans.add(make(board));
            return;
        }
        for(int row=0;row<board.length;row++)
        {
            if(validation(board,row,col))
            {
                board[row][col]='Q';
                helper(ans,board,col+1);
                board[row][col]='.';
            }
        }

    }
    public static  List<String> make(char[][] board)
    {
        List<String> arr=new ArrayList<>();
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
             ans.append(board[i][j]);
            }
            arr.add(ans.toString());
            ans=new StringBuilder();

        }
        return arr;

    }
    public static boolean validation(char [][] board,int row,int col)
    {
        int realrow=row;
        int realcol=col;
        while(row>=0 && col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row--;
            col--;
        }
        row=realrow;
        col=realcol;
        while(col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            col--;
        }
        row=realrow;
        col=realcol;

        while(row<board.length && col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row++;
            col--;
        }
        return true;

    }
}
