package com.zuhlke.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private List<String> invalidNumbers = new ArrayList<>();


    public int add(String numbers) {
        if (numbers.isEmpty() || numbers.isBlank()) {
            return 0;
        }
        int sum = 0;
        String delimiter = "[\\n,]";
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, numbers.indexOf('\n'));
            numbers = numbers.substring(numbers.indexOf('\n')+1);

        }
        String[] nums = numbers.split( delimiter );
        for (String number : nums) {
            int temp = Integer.parseInt(number);
            if (temp > 0 && temp < 1000) {
                sum += temp;
            } else if (temp < 0){
                invalidNumbers.add(number);
            }
        }
        if (!invalidNumbers.isEmpty())
        {
            throw new IllegalArgumentException("negatives not allowed - " + invalidNumbers.stream().collect(Collectors.joining(" ")));
        }

        return sum;
    }
}
