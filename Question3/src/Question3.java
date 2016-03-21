import java.util.Scanner;

/**
 * Created by Eric Chen on 16/3/21.
 */
public class Question3 {
    public static void main(String[] args){new Question3();}
    private int m;
    private int n;
    private int[] L;
    public Question3(){

        int[] price = { 0, 100, 90, 80, 70, 1, 60, 50 };
        m = price.length-1;
        System.out.println("Please input the length you want to ride: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        L = new int[n+1];
        for(int i=0;i<=n;i++){
            L[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<=n;i++){
            if(i<=m){
                if(i==0 || i==1) L[i]=price[i];
                else{
                    for(int k=1;k<i;k++){
                        L[i]=Math.min(price[i],L[k]+price[i-k]);
                    }
                }
            }else{
                int min = Integer.MAX_VALUE;
                for(int j=i-m;j<i;j++){
                    if(min>L[j]+price[i-j]){
                        min = L[j]+price[i-j];
                    }
                }
                L[i]=min;
            }
        }

        System.out.println(L[n]);



    }

}
