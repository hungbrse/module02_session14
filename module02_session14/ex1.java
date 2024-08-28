package module02_session14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ex1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,7,9,12,14,8,7,4,5));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("aw", "cc" , "bb" ,"awaea" ," uiaw ","lisa"));
        Stream<Integer> evenNumber = list.stream().filter(x -> x %2 == 0);
        evenNumber.forEach(number -> System.out.print(number + " "));
          System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("hãy nhập một số : ");
        int input = Integer.parseInt(sc.nextLine());

        Stream<Integer> inputCheck = list.stream().filter(x -> x > input);

        inputCheck.forEach(System.out::println);

        int sum = list.stream().reduce(0,Integer::sum);

        System.out.println(sum);

        boolean oneEvenNumber = list.stream().anyMatch(x -> x %2 ==0);

        System.out.println("có một số chẵn :" + oneEvenNumber);

      IntStream intStream = IntStream.range(20,30);

      intStream.forEach(System.out::print);

      List<String> sortedList =  list2.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedList);

        List<String> toUpperCase = (List<String>) list2.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(toUpperCase);






    }
}
