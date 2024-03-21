package recent.hy.lv3;

import java.util.Arrays;
import java.util.Scanner;

//https://softeer.ai/app/assessment/index.html?xid=98950&xsrfToken=HSkWtkXuwT9SuGRlWOYMB2S5N3q7l80S&testType=practice
public class GradeScore {
    public static class Member implements Comparable<Member>{
        int id;
        int score;
        int rank;
        public Member(int id, int score){
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Member other){
            return Integer.compare(other.score,this.score);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Member[] total = new Member[N];
        int[][] competitions = new int[3][N];
        for(int i= 0 ; i < 3 ;i++){
            String[] competition = sc.nextLine().split(" ");
            for(int j = 0 ; j < competition.length ;j++){
                competitions[i][j] = Integer.parseInt(competition[j]);
                total[j] = new Member(j,0);
            }
        }

        for(int i = 0 ; i < 3 ; i++){
            Member[] all = new Member[N];
            for (int j = 0 ; j < N; j++){
                all[j] = new Member(j,competitions[i][j]);
                total[j].score += competitions[i][j];
            }
            Arrays.sort(all);

            int cnt = 1;
            for(int j = 0; j < all.length ; j++){
                all[j].rank = cnt;
                // System.out.println(" id " +all[j].id +" score " + all[j].score+ " rank "+ all[j].rank);
                // System.out.println("-----");
                cnt++;

            }
            StringBuilder br = new StringBuilder();
            int[] rank = new int[N];
            rank[all[0].id] = all[0].rank;
            for(int j = 1; j < all.length ; j++){
                if (all[j].score == all[j-1].score){
                    all[j].rank = all[j-1].rank;
                }
                rank[all[j].id] = all[j].rank;
            }
            br.append(rank[0]);
            for(int j = 1; j < rank.length ; j++){
                br.append(" ").append(rank[j]);

            }
            System.out.println(br.toString());
        }

        StringBuilder br = new StringBuilder();
        int[] totalRanks= new int[N];
        int totalcnt = 1;
        Arrays.sort(total);
        for (int i = 0 ; i < total.length ; i++){
            total[i].rank = totalcnt;
            totalcnt++;
        }
        totalRanks[total[0].id] = total[0].rank;
        for (int i = 1 ; i < total.length ; i++){
            if(total[i].score == total[i-1].score){
                total[i].rank = total[i-1].rank;
            }
            totalRanks[total[i].id] = total[i].rank;
        }
        br.append(totalRanks[0]);
        for(int j = 1; j < totalRanks.length ; j++){
            br.append(" ").append(totalRanks[j]);
        }
        System.out.println(br.toString());


    }
}
