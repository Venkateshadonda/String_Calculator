package Incubytes.assessment;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class String_Calculator {
    public static int Add(String input){
        if(!input.isEmpty()) {
            List<Integer> outputnumber = strArrToIntList(getSplit(input));
            negatives(outputnumber);
            return outputnumber.stream()
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
    }

    private static void negatives(List<Integer> outputnumber) {
        StringBuilder stringBuilder = new StringBuilder();
        outputnumber.stream()
                .filter(number->number<0)
                .forEach(number->stringBuilder.append(number).append(" "));
        if(!stringBuilder.toString().isEmpty()){
            throw new RuntimeException("Negative Values Not Allowed "+stringBuilder.toString());
        }
    }

    private static List<Integer> strArrToIntList(String[] inputArr) {
        return Arrays.stream(inputArr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] getSplit(String input) {
        if(input.startsWith("//")){
            Matcher matcher=Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.matches()){
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
            throw new RuntimeException("Wrong custom delimiter format");
        }
        return input.split(",|\n");
    }
}