package bitManipulation.medium;

public class m4 {
    public static void main(String[] args) {
        System.out.println(findXOR(2,95));

    }
    public static int findXOR(int l,int r)
    {
        return find(l-1) ^find(r);

    }
    public static int find( int r) {

        return r%4==0?r:r%4==1?1:r%4==2?r+1:0;
    }
}
