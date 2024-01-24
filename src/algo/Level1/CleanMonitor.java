package algo.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class CleanMonitor {

    public int[] solution(String[] wallpaper) {

        int leastX = wallpaper[0].length();
        int leastY = wallpaper.length;
        int maxX = 0;
        int maxY = 0;

        for(int i = 0 ; i < wallpaper.length ; i++){
            char[] now = wallpaper[i].toCharArray();
            for (int j = 0 ; j < now.length ; j++){
                int nowX = j;
                int nowY = i;
                if (now[j] == '#'){
                    if(leastX>nowX){
                        leastX=nowX;
                    }
                    if(leastY>nowY){
                        leastY=nowY;
                    }
                    if(maxX<nowX){
                        maxX=nowX;
                    }
                    if(maxY<nowY){
                        maxY=nowY;
                    }
                }
            }
        }
        return new int[]{leastY, leastX, maxY + 1, maxX + 1};
    }
    public static void main(String[] args) {

    }
}
