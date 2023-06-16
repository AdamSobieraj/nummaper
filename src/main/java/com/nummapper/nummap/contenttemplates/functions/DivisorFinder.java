package com.nummapper.nummap.contenttemplates.functions;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class DivisorFinder {

    public Map<Integer, List<Integer>> findDivisorsMap(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toMap(
                        number -> number,
                        this::findDistinctDivisorsForNumber
                ));
    }

    private List<Integer> findDistinctDivisorsForNumber(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .boxed()
                .collect(Collectors.toList());
    }

}
