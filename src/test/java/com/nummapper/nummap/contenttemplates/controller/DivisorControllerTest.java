package com.nummapper.nummap.contenttemplates.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nummapper.nummap.contenttemplates.dto.DivisorRequest;
import com.nummapper.nummap.contenttemplates.dto.DivisorResponse;
import com.nummapper.nummap.contenttemplates.enumerate.Category;
import com.nummapper.nummap.contenttemplates.services.DivisorMapperService;
import com.nummapper.nummap.utility.ControllerTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nummapper.nummap.configuration.UrlConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ControllerTest
@ContextConfiguration(classes = {DivisorController.class})
class DivisorControllerTest {

    private static final String MOUSE = "Mouse";
    private static final String CAT = "Cat";
    private static final String ELEPHANT = "Elephant";

    @MockBean
    private DivisorMapperService divisorMapperService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void findDivisors() {
        //Given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        when(divisorMapperService.mapDivisorsToValues(any(DivisorRequest.class))).thenReturn(createDivideResponse());
        //When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(API + DIVISOR + DIVISORS)
                        .content(objectMapper.writeValueAsString(createDivisorRequest()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper convertFromContent = new ObjectMapper();
        DivisorResponse returnPayload = convertFromContent.readValue(result.getResponse().getContentAsString(), new TypeReference<DivisorResponse>() {
        });
        //Then
        assertEquals(3, returnPayload.getResponse().keySet().size());
        assertEquals(MOUSE, returnPayload.getResponse().get(1).get(0));
        assertEquals(CAT, returnPayload.getResponse().get(2).get(1));
        assertEquals(ELEPHANT, returnPayload.getResponse().get(4).get(2));
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    private DivisorResponse createDivideResponse() {
        Map<Integer, List<String>> response = new HashMap<>();

        List<String> mapForOne = new ArrayList<>();
        List<String> mapForTwo = new ArrayList<>();
        List<String> mapForFour = new ArrayList<>();

        mapForOne.add(MOUSE);
        mapForTwo.addAll(mapForOne);
        mapForTwo.add(CAT);
        mapForFour.addAll(mapForTwo);
        mapForFour.add(ELEPHANT);

        response.put(1, mapForOne);
        response.put(2, mapForTwo);
        response.put(4, mapForFour);

        return DivisorResponse.builder().response(response).build();
    }

    private DivisorRequest createDivisorRequest() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        return DivisorRequest.builder()
                .category(Category.ANIMALS)
                .numbers(numbers)
                .build();
    }

}