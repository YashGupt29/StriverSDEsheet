
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        StringBuilder s = new StringBuilder(input);

        in.close();

        System.out.println(repetitions(s));
    }
    public static int repetitions(StringBuilder s)
    {
        int ans=0;
        for (int i = 0; i < s.length()-1 ; i++) {
            if(s.charAt(i)==s.charAt(i+1))
            {
                ans++;
            }
        }
        return ans;
    }
}
