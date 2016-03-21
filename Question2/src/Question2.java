import java.util.Scanner;

/**
 * Created by Eric Chen on 16/3/21.
 */
public class Question2 {

    public static void main(String[] args){new Question2();}

    private int[] r;
    private int n;
    public Question2(){
        System.out.print("Please input the amount of n matrices :");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println();

        r = new int[n+1];
        for(int i=0;i<=n;i++){
            System.out.println("Please input r"+i+": ");
            r[i]=scanner.nextInt();
        }

        int[][] tracker = new int[n+1][n+1];
        int[][] m = new int[n+1][n+1];
        String[][] expressionMatrix = new String[n+1][n+1];

        System.out.println("Min. Multiplication: "+multiply(n,m,tracker,r));
        System.out.println("Expression:");
        track(1,n,tracker,expressionMatrix);

        System.out.println(expressionMatrix[1][n]);

    }


    private int multiply(int n, int[][] m, int [][] tracker,int [] row){
        for(int i=1;i<=n;i++){
            m[i][i]=0;
        }
        for(int r=2;r<=n;r++){
            for(int i=1;i<=n-r+1;i++){
                int j =i+r-1;
                m[i][j] = m[i + 1][j] +row[i - 1] * row[i] * row[j];
                tracker[i][j] = i;
                for(int k=i+1;k<j;k++) {
                    int t = m[i][k] + m[k + 1][j] + row[i - 1] * row[k] * row[j];
                    if(t<m[i][j]){
                        m[i][j]=t;
                        tracker[i][j]=k;
                    }
                }
            }
        }
        return m[1][n];
    }

    private void track(int i,int j,int[][] tracker,String[][] expressionMatrix){
        if(i==j) return;
        track(i,tracker[i][j],tracker,expressionMatrix);
        track(tracker[i][j]+1,j,tracker,expressionMatrix);

        int first_begin = i;
        int first_end = tracker[i][j];
        int second_begin = (tracker[i][j]+1);
        int second_end = j;

        if(first_begin==first_end && second_begin==second_end)
            expressionMatrix[first_begin][second_end] = "(M"+first_begin+" * M"+second_begin+")";
        if(first_begin!=first_end && second_begin==second_end)
            expressionMatrix[first_begin][second_end] = "("+expressionMatrix[first_begin][first_end]+" * M"+second_begin+")";
        if(first_begin==first_end && second_begin!=second_end)
            expressionMatrix[first_begin][second_end] = "(M"+first_begin+" * "+expressionMatrix[second_begin][second_end]+")";
        if(first_begin!=first_end && second_begin!=second_end)
            expressionMatrix[first_begin][second_end] = "("+expressionMatrix[first_begin][first_end]+" * "+expressionMatrix[second_begin][second_end]+")";

    }



}
