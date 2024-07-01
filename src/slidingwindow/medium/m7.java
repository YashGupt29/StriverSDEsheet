package slidingwindow.medium;

public class m7 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));

    }
    public static int numberOfSubstrings(String s) {
        int [] chr={-1,-1,-1};
        int cnt=0;
        for (int i = 0; i <s.length() ; i++) {
            chr[s.charAt(i)-'a']=i;
            cnt=cnt+1+Math.min(Math.min(chr[0],chr[1]),chr[2]);
        }
        return cnt;

    }
}
