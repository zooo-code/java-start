package algo.Level1;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963?language=java
 */
public class First {


    public static void main(String[] args) {
        First first = new First();
        String[] name = {"may", "kein", "kain", "radi"};
        int [] yearning = {5, 10, 1, 3};
        String[][] photo =  {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}};
        System.out.println(first.solution(name, yearning, photo));
    }


    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> a =new HashMap<>();
        for (int i = 0 ; i < name.length ; i++){
            a.put(name[i],yearning[i]);
        }
        for (int i = 0 ; i < photo.length ;i++) {
            int now = 0;
            for (String photoName : photo[i]) {
                Integer b = a.get(photoName);
                if (b != null){
                    now += b;
                }
            }
            answer[i] = now;

        }
        return answer;
    }
}
