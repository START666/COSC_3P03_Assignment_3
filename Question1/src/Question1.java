/**
 * Created by Eric Chen on 16/3/13.
 */
public class Question1 {
    public static void main(String[] args){new Question1();}
    public Question1(){
        System.out.println("Test Algorithm");

        int[] data = new int[]{21,1,3,18,4,11, 17, 5, 8, 6, 4, 7, 12, 3};

        LIS2(data,data.length);
        System.out.println("Length: "+LIS2(data,data.length));
        System.out.println("Longest Increasing Subsequence:");
        outputLIS(data,data.length-1);

//        System.out.println(LIS(data,data.length));
//        System.out.println(calSum(100));

    }

    /********************** COSC 3P03 A3 Q1***************************
     *
     * Found online as C, rebuild as Java by Eric Chen
     * */
    private int[] dp = new int[31];
    private int lis;

    private int LIS2(int[] arr,int size){
        for(int i=0;i<size;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if (arr[i] > arr[j] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    if(dp[i]>lis){
                        lis=dp[i];
                    }
                }
            }
        }
        return lis;
    }

    private void outputLIS(int[] arr,int index){
        boolean isLIS = false;
        if(index<0 || lis ==0){
            return;
        }
        if(dp[index]==lis){
            lis--;
            isLIS = true;
        }

        outputLIS(arr,--index);

        if(isLIS){
            System.out.print(arr[index+1]+" ");
        }
    }

    /*****************************************************************/
    private int upper_bound(int arr[],int s, int e, int key){
        int mid;
        if(arr[e] <= key) return e+1;
        while(s<e){
            mid = s+(e-s)/2;
            if(arr[mid]<=key) s = mid+1;
            else e=mid;
        }
        return s;
    }

    private int LIS(int d[],int n){
        int len=1;
        int[] end = new int[n+1];
        end[1] = d[0];
        for(int i=1;i<n;i++){
            int pos=upper_bound(end,1,len,d[i]);
            end[pos] = d[i];
            if(len<pos) len = pos;
        }
        return len;
    }

    private int LIS_length(int[] data, int length){

        int[] B = new int[length];
        int nLISLen = 1;
        B[0] = data[0];

        for(int i=1;i<length;i++){
            if(data[i] > B[nLISLen-1]){
                B[nLISLen] = data[i];
                nLISLen++;
            }else{
                int pos = BinarySearch(B,data[i],nLISLen);
                B[pos]=data[i];
            }

        }
        return nLISLen;
    }

    private int BinarySearch(int[] data, int value, int length){
        int begin=0;
        int end = length -1;
        while(begin <= end){
            int mid = begin+(end-begin)/2;
            if(data[mid] == value) return mid;
            else if(data[mid]>value) end = mid -1;
            else begin = mid +1;
        }
        return begin;
    }
}
