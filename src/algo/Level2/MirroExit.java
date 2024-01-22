package algo.Level2;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/159993?language=java
public class MirroExit {

    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        MirroExit mirroExit = new MirroExit();
        String[] maps = {"SOOOL",
                        "XXXXO",
                        "OOOOO",
                        "OXXXX",
                        "OOOOE"};
        int solution = mirroExit.solution(maps);
        System.out.println("solution = " + solution);
    }

    public int solution(String[] maps) {
        int answer = 0;
        char[][] miro = new char[maps.length][maps[0].length()];
        //레버 출구 시작점을 찾는다.
        //일단 레버의 위치를 찾아서 레버로 가는 가장 최단 거리를 구한다.
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        Location Lever = null;
        Location Start = null;
        Location Exit = null;
        for (int i = 0; i < maps.length; i++) {
            char[] charArray = maps[i].toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];
                miro[i][j] = c;
                if (c == 'S') {
                    Start = new Location(i, j, c);
                } else if (c == 'E') {
                    Exit = new Location(i, j, c);
                }
            }
        }
        int lever = bfs(Start, miro, visited);
        int exit = bfs(Exit, miro, visited);

        System.out.println("exit = " + exit);
        System.out.println("lever = " + lever);
        return answer;
    }


    public int bfs(Location location,char[][] miro , boolean[][] visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{location.x, location.y, 0});

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];
            visited[x][y] = true;
            if (miro[x][y] == location.target) {
                return count;
            }
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0&& nx <miro.length && 0<= ny && ny < miro[0].length && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,count +1});
                }
            }
        }
        return -1;
    }
}
class Location {
    int x, y;
    char target;
    Location(int x, int y,char target ) {
        this.x = x;
        this.y = y;
        this.target = target;
    }
}

