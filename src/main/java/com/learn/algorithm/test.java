import java.util.LinkedHashMap;
import java.util.Map;

public class test
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Map<String, Integer> seqMap = new LinkedHashMap<>();
        seqMap.put("c",100);
        seqMap.put("d",200);
        seqMap.put("a",500);
        seqMap.put("d",300);
        for(Map.Entry<String,Integer> entry:seqMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }


    public static void quickSort(int[] arr,int start,int end){
        if(start > end){
            return;
        }
        int i = start;
        int j = end;
        int temp = arr[start];
        while(i<j){
            while(i<j && arr[j]>=temp){
                j--;
            }
            arr[i] = arr[j];
            while(i<j && arr[i]<=temp){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        quickSort(arr,i+1,end);
        quickSort(arr,start,i-1);
    }

}