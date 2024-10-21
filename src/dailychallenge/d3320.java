package dailychallenge;

import java.util.Arrays;

public class d3320 {
    public static void main(String[] args) {
        System.out.println(countWinningSequences("FFF"));
    }
    static int MOD=(int)(1e9) + 7;
    static char [] BOB_MOVES={'F','E','W'};
    public static int countWinningSequencess(String s) {
        int n = s.length();
        int [][][] dp = new int[n][3][2 * n + 1];
        for (int[][] round : dp) {
            for (int[] move : round) {
                Arrays.fill(move, -1);
            }
        }
        return helper(s,0,'X',0,dp);

    }
    public static int countWinningSequences(String s) {
        int n = s.length();
        int [][][] dp = new int[n+1][3][2 * n + 1];
        for (int i = 1; i <2*n; i++) {
            dp[n][0][i]=1;
            dp[n][1][i]=1;
            dp[n][2][i]=1;
        }
           for (int index = n-1; index >= 0; index--) {
               char aliceMoves=s.charAt(index);
               for(char bobMove:BOB_MOVES) {
                   int bobIndex = bobMove == 'F' ? 0 : bobMove == 'W' ? 1 : 2;

                        for (int scoreDiff = 0; scoreDiff < 2 * n; scoreDiff++) {
                            int ways=0;
                            for(char lastMove:BOB_MOVES)
                            {
                                if (bobMove != lastMove) {
                                    int nextBobIndex = lastMove == 'F' ? 0 : lastMove == 'W' ? 1 : 2;
                                    int newScoreDiff = scoreDiff;
                                    if ((aliceMoves == 'F' && bobMove == 'W') || (aliceMoves == 'E' && bobMove == 'F') || (aliceMoves == 'W' && bobMove == 'E')) {
                                        newScoreDiff++;
                                    } else if ((bobMove == 'F' && aliceMoves == 'W') ||
                                            (bobMove == 'W' && aliceMoves == 'E') ||
                                            (bobMove == 'E' && aliceMoves == 'F')) {
                                        newScoreDiff--;
                                    }
                                    if (newScoreDiff >= 0 && newScoreDiff < 2 * n) {
                                        ways = (ways + dp[index + 1][nextBobIndex][newScoreDiff]) % MOD;
                                    }
                                }
                            }
                            dp[index][bobIndex][scoreDiff] = ways;
                        }
                    }
             }
        int totalWays = 0;
        for (char bobMove : BOB_MOVES) {
            int bobIndex = bobMove == 'F' ? 0 : bobMove == 'W' ? 1 : 2;
            totalWays = (totalWays + dp[0][bobIndex][n]) % MOD;
        }
        return totalWays;
    }
    public static int helper(String s ,int index,char lastMove,int scoreDiff,int [][][] dp)
    {
        if(index==s.length())
        {
            return scoreDiff>0?1:0;
        }
        int lastIndex=lastMove=='F'?0:lastMove=='W'?1:lastMove=='E'?2:0;
        if(dp[index][lastIndex][scoreDiff+s.length()]!=-1)
        {
            return dp[index][lastIndex][scoreDiff+s.length()];
        }
            int ways=0;
            char aliceMoves=s.charAt(index);
            for(char bobMoves:BOB_MOVES)
            {

                if(bobMoves!=lastMove)
                {
                    int newScoreDiff = scoreDiff;
                    if((aliceMoves=='F' && bobMoves=='W') || (aliceMoves=='E' && bobMoves=='F') || (aliceMoves=='W' && bobMoves=='E'))
                    {
                        newScoreDiff++;
                    }
                    else if((bobMoves == 'F' && aliceMoves == 'W') ||
                            (bobMoves == 'W' && aliceMoves == 'E') ||
                            (bobMoves == 'E' && aliceMoves == 'F'))
                    {
                        newScoreDiff--;
                    }
                    ways=ways+helper(s,index+1,bobMoves,newScoreDiff,dp);
                }

            }
            return dp[index][lastIndex][scoreDiff + s.length()] = ways;

    }
}

