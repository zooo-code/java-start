package recent.hy.lv2;

import java.util.Scanner;

public class velChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String velocity = sc.nextLine();
        String[] v = velocity.split(" ");
        int[] intV = new int[v.length];
        for (int i = 0; i < v.length ; i++){
            intV[i] = Integer.parseInt(v[i]);
        }

        int a = 0;
        int d = 0;
        for (int i = 1; i < intV.length ; i++){
            if(intV[i-1] < intV[i]){
                a++;
            } else{
                d++;
            }
        }

        if(a== 7){
            System.out.println("ascending");
        } else if(d == 7){
            System.out.println("descending");
        } else{
            System.out.println("mixed");
        }
    }
}
