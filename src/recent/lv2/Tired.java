package recent.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java
public class Tired {
    boolean[] visited;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        //최소 피로도, 소모 피로도
        //k 유저의 피로도 , [최소 필요 피로도, 소모 피로도]
        // return 탐험할 수 있는 최대 던전 수
        visited = new boolean[dungeons.length];
        // 완전 탐색을 통해 모든 경우를 만들어보고 돌게 시킨다.
        int cnt = 0;

        dfs(0,k,dungeons);


        answer = max;
        return answer;
    }

    public void dfs(int depth, int fatigue , int[][] dungeons){

        for(int i = 0 ; i < dungeons.length ; i++){
            if(visited[i] || dungeons[i][0] > fatigue){
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }

        max = Math.max(depth, max);
    }

}
