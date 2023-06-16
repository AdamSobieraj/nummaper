package com.nummapper.nummap.contenttemplates.functions;

import com.nummapper.nummap.contenttemplates.functions.DivisorFinder;
import com.nummapper.nummap.utility.UnitTestSingle;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@UnitTestSingle
class DivisorFinderTest {

    @InjectMocks
    private DivisorFinder divisorFinder;

    @Test
    void findDivisors() {
        //Given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(10);
        //When
        Map<Integer, List<Integer>> result = divisorFinder.findDivisorsMap(numbers);
        //Then
        assertEquals(1, result.get(1).get(0));
        assertEquals(1, result.get(2).get(0));
        assertEquals(2, result.get(2).get(1));
        assertEquals(1, result.get(4).get(0));
        assertEquals(2, result.get(4).get(1));
        assertEquals(4, result.get(4).get(2));
        assertEquals(1, result.get(10).get(0));
        assertEquals(2, result.get(10).get(1));
        assertEquals(5, result.get(10).get(2));
        assertEquals(10, result.get(10).get(3));

    }
}