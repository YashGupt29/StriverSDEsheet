package strings;

public class s6 {
    public static void main(String[] args) {
        String s="abcde";
        String goal="abced";

        System.out.println(rotateStringOptimized(s,goal));

    }
    public static  boolean rotateString(String s, String goal) {
        if(s.equalsIgnoreCase(goal))
        {
            return true;
        }
        for (int i = 0; i <s.length()-1 ; i++) {
            String newString="";
            newString=s.substring(i+1)+s.substring(0,i+1);
            if(newString.equalsIgnoreCase(goal))
            {
                return true;
            }

        }
        return  false;

    }
    public static boolean rotateStringOptimized(String s, String goal) {
        // Check if lengths are different; if so, they cannot be rotations
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate the string with itself
        String concatenated = s + s;

        // Check if goal is a substring of the concatenated string
        return concatenated.contains(goal);
    }
}
