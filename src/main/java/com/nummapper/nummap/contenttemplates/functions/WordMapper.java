package com.nummapper.nummap.contenttemplates.functions;

import com.nummapper.nummap.contenttemplates.enumerate.Animal;
import com.nummapper.nummap.contenttemplates.enumerate.Category;
import com.nummapper.nummap.contenttemplates.enumerate.Furniture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class WordMapper {

    public  Map<Integer, List<String>> mapDivisorsToWords(Category category,Map<Integer, List<Integer>> numbers) {

        Map<Integer, List<String>> mappingResult = new HashMap<>();

        numbers.forEach((key, value) -> {
            mappingResult.put(key,mapNumbersToStrings(value, category));
        });

        return mappingResult;
    }

    private List<String> mapNumbersToStrings(List<Integer> numbersList, Category category) {

        List<String> temporaryDivisionsValues = new ArrayList<>();

        for (Integer number: numbersList) {
            String valueOfMappedDivisor = category.getName().equals(Category.ANIMALS.getName())?
                    Animal.getNameByPosition(number) : Furniture.getNameByPosition(number);
            temporaryDivisionsValues.add(valueOfMappedDivisor);
        }
        return temporaryDivisionsValues;
    }

}
