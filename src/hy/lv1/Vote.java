package hy.lv1;


import java.util.Scanner;

//https://softeer.ai/app/assessment/index.html?xid=97777&xsrfToken=nudG2teq5jATkpS9t6qP7iTMOVeaw12S&testType=practice
public class Vote {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String T = scanner.nextLine();
        int t = Integer.parseInt(T);
        for(int i = 0 ; i < t ; i++){
            StringBuilder br = new StringBuilder();
            String V = scanner.nextLine();
            int vote = Integer.parseInt(V);
            int a = vote/5;
            int b = vote%5;
            for(int j = 0 ; j < a ;j++){
                br.append("++++ ");
            }
            for(int j = 0 ; j < b ;j++){
                br.append("|");
            }

            System.out.println(br.toString());
        }

    }


}
