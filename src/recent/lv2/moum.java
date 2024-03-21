package recent.lv2;

import java.util.ArrayList;
import java.util.List;
//https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java
public class moum {

    final String[] a = {"A","E", "I","O","U"};
    public int solution(String word) {

        int answer = 0;
        StringBuilder br = new StringBuilder();
        List<String> arr = new ArrayList<>();
        for (String s : a) {
            dfs(arr, s);
        }
        answer = arr.indexOf(word)+1;
        return answer;
    }

    public void dfs(List<String> elem , String str){

        if(str.length() > a.length){
            return;
        }
        if(!elem.contains(str)){
            elem.add(str);
        }

        for(int i = 0 ;  i < a.length;i++ ){
            dfs(elem , str+ a[i]);
        }
    }
}
