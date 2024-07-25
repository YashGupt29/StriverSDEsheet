package dailychallenge;

public class p1 {
    public static void main(String[] args) {
        System.out.println(losingPlayer(2,7));
    }
    public  static String losingPlayer(int x, int y) {
        boolean alice=false;
        StringBuilder s=new StringBuilder();
        while(x>0 && y>3)
        {
            x=x-1;
            y=y-4;
            alice=!alice;
        }
        if(alice)
        {
            s.append("Alice");
        }else {
            s.append("Bob");
        }
        return s.toString();

    }
}

