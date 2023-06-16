package com.nummapper.nummap.contenttemplates.services;

import com.nummapper.nummap.contenttemplates.dto.DivisorRequest;
import com.nummapper.nummap.contenttemplates.dto.DivisorResponse;
import com.nummapper.nummap.contenttemplates.enumerate.Animal;
import com.nummapper.nummap.contenttemplates.enumerate.Category;
import com.nummapper.nummap.contenttemplates.enumerate.Furniture;
import com.nummapper.nummap.contenttemplates.functions.DivisorFinder;
import com.nummapper.nummap.contenttemplates.functions.NumberFilter;
import com.nummapper.nummap.contenttemplates.functions.WordMapper;
import com.nummapper.nummap.utility.UnitTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnitTest
class DivisorMapperServiceTest {

    @Autowired
    private DivisorMapperService divisorMapperService;

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private DivisorFinder divisorFinder;

    @Autowired
    private NumberFilter numberFilter;

    @Test
    void mapDivisorsToValuesAnimal() {
        //Given
        DivisorRequest divisorRequest = createDivisorRequest();
        //When
        DivisorResponse response = divisorMapperService.mapDivisorsToValues(divisorRequest);
        //Then
        assertEquals(Animal.DOG.getName(),response.getResponse().get(1).get(0));
        assertEquals(Animal.DOG.getName(),response.getResponse().get(2).get(0));
        assertEquals(Animal.CAT.getName(),response.getResponse().get(2).get(1));
        assertEquals(Animal.DOG.getName(),response.getResponse().get(4).get(0));
        assertEquals(Animal.CAT.getName(),response.getResponse().get(4).get(1));
        assertEquals(Animal.LION.getName(),response.getResponse().get(4).get(2));

        assertEquals(Animal.DOG.getName(),response.getResponse().get(10).get(0));
        assertEquals(Animal.CAT.getName(),response.getResponse().get(10).get(1));
        assertEquals(Animal.TIGER.getName(),response.getResponse().get(10).get(2));
        assertEquals(Animal.RABBIT.getName(),response.getResponse().get(10).get(3));

    }

    @Test
    void mapDivisorsToValuesFurniture() {
        //Given
        DivisorRequest divisorRequest = createDivisorRequest();
        divisorRequest.setCategory(Category.FURNITURE);
        //When
        DivisorResponse response = divisorMapperService.mapDivisorsToValues(divisorRequest);
        //Then
        assertEquals(Furniture.CHAIR.getName(),response.getResponse().get(1).get(0));
        assertEquals(Furniture.CHAIR.getName(),response.getResponse().get(2).get(0));
        assertEquals(Furniture.TABLE.getName(),response.getResponse().get(2).get(1));
        assertEquals(Furniture.CHAIR.getName(),response.getResponse().get(4).get(0));
        assertEquals(Furniture.TABLE.getName(),response.getResponse().get(4).get(1));
        assertEquals(Furniture.BED.getName(),response.getResponse().get(4).get(2));

        assertEquals(Furniture.CHAIR.getName(),response.getResponse().get(10).get(0));
        assertEquals(Furniture.TABLE.getName(),response.getResponse().get(10).get(1));
        assertEquals(Furniture.DESK.getName(),response.getResponse().get(10).get(2));
        assertEquals(Furniture.CABINET.getName(),response.getResponse().get(10).get(3));
    }

    private DivisorRequest createDivisorRequest() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(4);
        numbers.add(10);
        numbers.add(40);
        return DivisorRequest.builder()
                .category(Category.ANIMALS)
                .numbers(numbers)
                .build();
    }
}