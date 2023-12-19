package algo.Level2.stackQueue;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
public class GoodBracket {


    public static void main(String[] args) {
        GoodBracket goodBracket = new GoodBracket();
        String s = "()()";
        boolean solution = goodBracket.solution(s);
        System.out.println("solution = " + solution);
    }


    boolean solution(String s) {

        char[] chars = s.toCharArray();
        if (chars[0] ==')'){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (stack.isEmpty()){
                if (aChar ==')') return false;
                stack.push(aChar);
            } else{
                Character peek = stack.peek();
                if (peek != aChar){
                    stack.pop();
                } else{
                    stack.push(aChar);
                }
            }
        }

        return stack.isEmpty();
    }
}
