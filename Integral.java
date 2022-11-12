import java.util.Scanner;

public class Integral {
    public static void main(String[] args){
        double xg = 0.0;
        double yg = 0.0;
        double sum = 0.0;//分母
        double sumx = 0.0;//分子--xg
        double sumy = 0.0;//分子--yg
        double[][] a = new double[4][4];
        double[] hsx = new double[4];
        double[] hsy = new double[4];

        Scanner sc = new Scanner(System.in);

        System.out.printf("\n格子点の重心を導出します。\n\n");
        System.out.println("各座標点の重みを入力してください。");
        for(int i = 0; i < 4; i++){
            for(int j = 3; j > -1; j--){
                System.out.printf("x = %d, y = %d -- ", i, j);
                a[i][j] = sc.nextDouble();
            }
        }
        sc.close();
        for(int i = 0; i < 4; i++){
            for(int j = 3; j > -1; j--){
                hsx[i] = hsx[i] + a[i][j];
                hsy[i] = hsy[i] + a[j][i]; 
            }
        }
        for(int i = 0; i < 4; i++){
            sumx = sumx + i * hsx[i];
            sumy = sumy + i * hsy[i];
            sum = sum + hsx[i];
        }
        if(sumx != 0.0){
            xg = sumx / sum;
            yg = sumy / sum;
        }
        System.out.printf("\n計算結果は以下の通りです。\n");
        System.out.printf("sumx = %f\nsumy = %f\nsum = %f\n", sumx, sumy, sum);
        System.out.printf("------------------------\nxg = %f\nyg = %f\n", xg, yg);
    }
}
