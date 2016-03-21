/**
 * Created by Eric Chen on 16/3/21.
 */
public class Question4 {

    public static void main(String[] args){new Question4();}
    public Question4(){

        int[] data = new int[]{7,2,4,5,3};
        int n = data.length;
        int[][] S = new int[data.length][data.length];
        int[][] C = new int[data.length][data.length];

        System.out.println("Sum Matrix:");
        sumMatrix(data,S);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(S[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Cost Matrix:");
        addition(data,C);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }

    }

    private void sumMatrix(int[] a,int[][] S){
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j) continue;
                if(i==j) S[i][j] = a[i];
                else{
                    S[i][j] = S[i][j-1]+a[j];
                }
            }
        }
    }

    private void addition(int[] a,int[][] costMatrix){
        int n=a.length;
        for(int i=0;i<=n;i++){
            int initX = 0;
            int initY = i;
            for(int j=0;j<n;j++){
                int x=initX+j;
                int y=initY+j;
                if(y>=n) continue;
                if(x==y) costMatrix[x][y]=a[x];
                else{
                    costMatrix[x][y] = Math.min(2*costMatrix[x][y-1]+a[y],2*costMatrix[x+1][y]+a[x]);
                }
            }
        }
    }
}
