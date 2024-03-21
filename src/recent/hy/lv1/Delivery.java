package recent.hy.lv1;

import java.util.Scanner;

//https://softeer.ai/app/assessment/index.html?xid=97791&xsrfToken=BPoSucxBTts9fAxbS1WV7pBGlzToPN03&testType=practice
public class Delivery {
    //n 개의 마을 존재
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        int N = Integer.parseInt(n);
        String[] split = s.nextLine().split(" ");

        int start = 0;
        int min = 99999999;
        for (String a : split){
            if (start == 0){
                start = Integer.parseInt(a);
                continue;
            }
            int nextValue = Integer.parseInt(a);
            int gap = nextValue - start;
            start = nextValue;
            min = Math.min(gap, min);


        }
        start = 0;
        int answer = 0;
        for (String a : split){

            if (start == 0){
                start = Integer.parseInt(a);
                continue;
            }
            int nextValue = Integer.parseInt(a);

            int gap = nextValue - start;

            start = nextValue;
            if (gap == min){
                answer++;
            }

        }
        System.out.println(answer);
    }
}
