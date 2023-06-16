package com.nummapper.nummap.contenttemplates.services;

import com.nummapper.nummap.contenttemplates.dto.DivisorRequest;
import com.nummapper.nummap.contenttemplates.dto.DivisorResponse;
import com.nummapper.nummap.contenttemplates.enumerate.Category;
import com.nummapper.nummap.contenttemplates.functions.DivisorFinder;
import com.nummapper.nummap.contenttemplates.functions.NumberFilter;
import com.nummapper.nummap.contenttemplates.functions.WordMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DivisorMapperService {

    private final WordMapper wordMapper;
    private final DivisorFinder divisorFinder;
    private final NumberFilter numberFilter;


    public DivisorResponse mapDivisorsToValues(DivisorRequest divisorRequest) {
        Category category = divisorRequest.getCategory();
        List<Integer> numbers = divisorRequest.getNumbers();

        List<Integer> numbersCheck = numberFilter.filterInRange(numbers);
        List<Integer> uniqueList = numbersCheck.stream().distinct().collect(Collectors.toList());

        Map<Integer, List<Integer>> filteredDivisorsFormNumbers = divisorFinder.findDivisorsMap(uniqueList);

        Map<Integer, List<String>> mappingResult = wordMapper.mapDivisorsToWords(category, filteredDivisorsFormNumbers);

        return DivisorResponse.builder().response(mappingResult).build();
    }


}
