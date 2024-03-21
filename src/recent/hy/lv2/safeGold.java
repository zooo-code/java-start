package recent.hy.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class safeGold {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String wn = sc.nextLine();
        String[] WN= wn.split(" ");

        int W = Integer.parseInt(WN[0]);
        int N = Integer.parseInt(WN[1]);

        int[] price = new int[N];
        Map<Integer, Integer> lock = new HashMap<>();
        for (int i = 0 ; i < N ;i++){
            String mp = sc.nextLine();
            String[] MP = mp.split(" ");
            int M = Integer.parseInt(MP[0]);
            int P = Integer.parseInt(MP[1]);
            if(lock.get(P) != null){
                int temp = lock.get(P);
                temp += M;
                lock.put(P,temp);
            }else{
                lock.put(P,M);
            }

            price[i] = P;
        }
        Arrays.sort(price);
        int answer = 0;
        boolean flag = true;
        for(int i = price.length -1 ; 0<=i ; i--){

            int weight = lock.get(price[i]);

            if (weight >= W){
                answer += W * price[i];

                weight -= W;
                lock.put(price[i],weight);
                W = 0;
            } else {
                answer += weight * price[i];

                W -= weight;
                lock.put(price[i],0);
            }

            if (W ==0){
                System.out.println(answer);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println(answer);
        }

    }
}
