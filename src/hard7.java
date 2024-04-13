import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class hard7
{
    public static void main(String[] args) {
        int[][] interval = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(mergeOptimized(interval)));

    }

    public static int [][] merge(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans= new ArrayList<>();
        for (int i = 0; i <arr.length ; i++)
        {
            int start=arr[i][0];
            int end=arr[i][1];
            if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1)) {
                continue;
            };
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j][0]<=end)
                {
                    end=Math.max(end,arr[j][1]);
                }
                else {
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        int[][] newArr = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> pair = ans.get(i);
            newArr[i][0] = pair.get(0);
            newArr[i][1] = pair.get(1);
        }
        return newArr;
    }
    public static int [][] mergeOptimized(int[][] arr){
        Arrays.sort(arr,Comparator.comparingInt(a->a[0]));
        List<List<Integer>> ans=new ArrayList<>() ;

        for (int i = 0; i < arr.length ; i++) {
            if(ans.isEmpty() || arr[i][0]>ans.getLast().get(1))
            {
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
            else {
                ans.getLast().set(1,Math.max(ans.getLast().get(1),arr[i][1]));

            }
        }
        int[][] newArr = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> pair = ans.get(i);
            newArr[i][0] = pair.get(0);
            newArr[i][1] = pair.get(1);
        }
        return newArr;

    }

    }

