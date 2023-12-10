import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        //스택은 접시와 같고
        System.out.println("=Stack=");
        while (!stack.empty()) {
            System.out.println("s = " + stack.pop());
        }
        //큐는 줄과 같다.
        System.out.println("=queue");
        while (!queue.isEmpty()) {
            System.out.println("q = " + queue.poll());
        }
    }
}
