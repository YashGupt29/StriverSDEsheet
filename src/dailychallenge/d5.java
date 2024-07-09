package dailychallenge;

public class d5 {
    public static void main(String[] args) {
        String s="aaa";
        System.out.println(getEncryptedString(s,3));
    }
    public static String getEncryptedString(String s, int k) {
        int n=s.length();
       StringBuilder st=new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            st.append(s.charAt(k % n));
            k++;
        }
        return st.toString();

    }
}
