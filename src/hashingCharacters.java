public class hashingCharacters {
    public static void main(String[] args) {
        String s="abcajdhlsa";
        char ch='a';
        int [] hash=new int[26];
        for(int i=0;i<s.length();i++)
        {
            hash[s.charAt(i)-'a']+=1;
        }
        System.out.println(hash[ch-'a']);
    }
}
