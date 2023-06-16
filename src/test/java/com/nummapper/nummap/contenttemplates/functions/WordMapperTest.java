package com.nummapper.nummap.contenttemplates.functions;

import com.nummapper.nummap.contenttemplates.enumerate.Animal;
import com.nummapper.nummap.contenttemplates.enumerate.Category;
import com.nummapper.nummap.contenttemplates.exceptions.DataNotFoundException;
import com.nummapper.nummap.utility.UnitTestSingle;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@UnitTestSingle
class WordMapperTest {

    private final static String DATA_NOT_FOUND = "Value of the :40 is incorrect - unknown";

    @InjectMocks
    private WordMapper wordMapper;

    @Test
    void mapDivisorsToWords() {
        //Given
        Map<Integer, List<Integer>> data = new HashMap<>();
        List<Integer> numbersForOne = new ArrayList<>();
        List<Integer> numbersForTwo = new ArrayList<>();
        List<Integer> numbersForFour = new ArrayList<>();
        List<Integer> numbersForTen = new ArrayList<>();


        numbersForOne.add(1);


        numbersForTwo.add(1);
        numbersForTwo.add(2);

        numbersForFour.add(1);
        numbersForFour.add(2);
        numbersForFour.add(4);

        numbersForTen.add(1);
        numbersForTen.add(2);
        numbersForTen.add(5);
        numbersForTen.add(10);

        data.put(1,numbersForOne);
        data.put(2,numbersForTwo);
        data.put(4,numbersForFour);
        data.put(10,numbersForTen);
        //When
        Map<Integer, List<String>> mappingResult = wordMapper.mapDivisorsToWords(Category.ANIMALS, data);
        //Then
        assertEquals(Animal.DOG.getName(),mappingResult.get(1).get(0));
        assertEquals(Animal.DOG.getName(),mappingResult.get(2).get(0));
        assertEquals(Animal.CAT.getName(),mappingResult.get(2).get(1));
        assertEquals(Animal.DOG.getName(),mappingResult.get(4).get(0));
        assertEquals(Animal.CAT.getName(),mappingResult.get(4).get(1));
        assertEquals(Animal.LION.getName(),mappingResult.get(4).get(2));
        assertEquals(Animal.DOG.getName(),mappingResult.get(10).get(0));
        assertEquals(Animal.CAT.getName(),mappingResult.get(10).get(1));
        assertEquals(Animal.TIGER.getName(),mappingResult.get(10).get(2));
        assertEquals(Animal.RABBIT.getName(),mappingResult.get(10).get(3));

    }

    @Test
    void mapDivisorsToValuesFurnitureException() {
        //Given
        Map<Integer, List<Integer>> data = new HashMap<>();
        List<Integer> numbersForOne = new ArrayList<>();
        List<Integer> numbersForTwo = new ArrayList<>();
        List<Integer> numbersForFour = new ArrayList<>();
        List<Integer> numbersForTen = new ArrayList<>();


        numbersForOne.add(1);


        numbersForTwo.add(1);
        numbersForTwo.add(2);

        numbersForFour.add(1);
        numbersForFour.add(2);
        numbersForFour.add(4);

        numbersForTen.add(1);
        numbersForTen.add(2);
        numbersForTen.add(5);
        numbersForTen.add(10);
        numbersForTen.add(40);

        data.put(1,numbersForOne);
        data.put(2,numbersForTwo);
        data.put(4,numbersForFour);
        data.put(10,numbersForTen);
        //When
        DataNotFoundException dataNotFoundException = assertThrows(DataNotFoundException.class,
                () ->  wordMapper.mapDivisorsToWords(Category.ANIMALS, data));
        //Then
        assertEquals(DATA_NOT_FOUND, dataNotFoundException.getMessage());
    }
}