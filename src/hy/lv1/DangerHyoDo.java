package hy.lv1;

import java.util.Scanner;

//https://softeer.ai/practice/7368
public class DangerHyoDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String info = sc.nextLine();

        String[] infoSplit = info.split(" ");

        int a = Integer.parseInt(infoSplit[0]);
        int b = Integer.parseInt(infoSplit[1]);
        int d = Integer.parseInt(infoSplit[2]);

        // d 에 따른 값을 구해보자
        // d 의 거리를 움직여 일단 터치를 한 후에 상황이 변환 된다.
        // 일단 d 까지 터치하는 시간을 구하자.
        int answer = 0;
        int resMock = d/a;
        int res = d%a;
        if (resMock == 0){
            answer += res;
        }else if(resMock == 1 && res == 0){
            answer += resMock * a;
        }
        else {
            answer += res;
            answer += resMock * a + b*resMock;
        }

        // 이제 돌아오는 시간은 a, b 의 값에 변경이 온다.
        int temp = a;
        a = b;
        b = temp;

        resMock = d/a;
        res = d%a;
        if(resMock == 0){
            answer += res;
        } else {
            answer += res;
            answer += resMock*a+b*resMock;

        }
        System.out.println(answer);

    }
}
