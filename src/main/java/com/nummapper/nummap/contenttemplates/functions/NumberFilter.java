package com.nummapper.nummap.contenttemplates.functions;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NumberFilter {

    private final static Integer UPPER_BOUND = 20;
    private final static Integer LOWER_BOUND = 1;

    public List<Integer> filterInRange(List<Integer> list) {
        return list.stream()
                .filter(value -> value >= LOWER_BOUND && value <= UPPER_BOUND)
                .collect(Collectors.toList());
    }
}
