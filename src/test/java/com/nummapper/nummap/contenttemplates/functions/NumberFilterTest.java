package com.nummapper.nummap.contenttemplates.functions;

import com.nummapper.nummap.utility.UnitTestSingle;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnitTestSingle
class NumberFilterTest {

    @InjectMocks
    private NumberFilter numberFilter;

    @Test
    void filterInRange() {
        //Given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(10);
        numbers.add(40);
        //When
        List<Integer> result = numberFilter.filterInRange(numbers);
        //Then
        assertEquals(4, result.size());
    }
}