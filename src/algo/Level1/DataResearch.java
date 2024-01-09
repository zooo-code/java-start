package algo.Level1;

import java.util.*;
//todo Sorted 문법 알기
public class DataResearch {

    public static void main(String[] args) {
        DataResearch dataResearch = new DataResearch();
        int[][] data = {{1, 20300104, 100, 80},{2, 20300804, 847, 37},{3, 20300401, 10, 8}};
        String ext ="date" ;
        int val_ext =20300501;
        String sort_by ="remain";
        int[][] solution = dataResearch.solution(data, ext, val_ext, sort_by);
        System.out.println("solution = " + Arrays.deepToString(solution));


        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 6);

        // 오름차순으로 정렬하는 Comparator
        Comparator<Integer> ascendingComparator = (a, b) -> a.compareTo(b);

        // 내림차순으로 정렬하는 Comparator
        Comparator<Integer> descendingComparator = (a, b) -> b.compareTo(a);

        // 숫자 리스트를 오름차순으로 정렬
        numbers.sort(ascendingComparator);
        System.out.println("Ascending order: " + numbers);

        // 숫자 리스트를 내림차순으로 정렬
        numbers.sort(descendingComparator);
        System.out.println("Descending order: " + numbers);

    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {


        //어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext
        //뽑아낼 정보의 기준 값을 나타내는 정수 val_ext
        //정보를 정렬할 기준이 되는 ㅇ문자열 sort_by
        String[] index = { "code", "date", "maximum", "remain" };
        List<String> strings = Arrays.asList(index);
        int extIdx = strings.indexOf(ext);
        int sortIdx = strings.indexOf(sort_by);

        return Arrays.stream(data)
                .filter(eachData -> eachData[extIdx] < val_ext)
                .sorted(Comparator.comparingInt(o -> o[sortIdx]))
                .toArray(int[][]::new);


    }


}
