package bsOn2DArray;

public class contest {
    public static void main(String[] args) {
        int red=4;
        int blue=2;
        System.out.println(Math.max(maxHeightOfTriangle(blue,red),maxHeightOfTriangle(red,blue)));

    }
    public static int maxHeightOfTriangle(int red, int blue) {
        int count=0;
        while(red>=0 && blue>=0) {
            if (count % 2 != 0) {

                red = red - (count+1);
                if(red>=0)
                {
                    count++;
                }


            } else {

                blue = blue - (count+1);
                if(blue>=0)
                {
                    count++;
                }


            }
        }
        return count;
    }
}
