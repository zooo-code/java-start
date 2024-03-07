package algo.Level2;

public class NumberCardDiv {

    public static void main(String[] args) {

        int[] arrayA = {10,17};
        int[] arrayB = {5,20};
        int solution = solution(arrayA, arrayB);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // 1. 일단 A 를 나눌 수 있는 가장 큰수를 찾는다. 반면 그수가 B 를 나눌수 없어야 한다. 최대 공약수를 찾아야한다.
        // 2. 반대로 진행한다.
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1 ; i < arrayA.length ; i++){
            gcdA = gcd(gcdA,arrayA[i]);
            gcdB = gcd(gcdB,arrayB[i]);
        }
        System.out.println("gcdB = " + gcdB);
        System.out.println("gcdA = " + gcdA);
        //이제 서로 나눠지는지 확인

        gcdA = div(gcdA, arrayB);
        gcdB = div(gcdB, arrayA);

        if(gcdA == 0 && gcdB ==0){
            return answer;
        } else{
            return Math.max(gcdA,gcdB);

        }
    }

    private static int gcd(int a, int b) {
        if (a%b ==0){
            return b;
        }
        return gcd(b,a%b);
    }

    public static int div(int gcd , int[] array){
        for(int i = 0 ; i < array.length ;i++){
            //gcbB 로 나눠지는지
            if(array[i] % gcd == 0){
                gcd = 0;
                break;
            }
        }
        return gcd;
    }

}
