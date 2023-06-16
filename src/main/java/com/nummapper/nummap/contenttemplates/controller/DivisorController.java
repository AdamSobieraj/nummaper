package com.nummapper.nummap.contenttemplates.controller;

import com.nummapper.nummap.contenttemplates.dto.DivisorRequest;
import com.nummapper.nummap.contenttemplates.dto.DivisorResponse;
import com.nummapper.nummap.contenttemplates.services.DivisorMapperService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nummapper.nummap.configuration.UrlConstants.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = API + DIVISOR)
public class DivisorController {

    private final DivisorMapperService divisorMapperService;

    @GetMapping(DIVISORS)
    public ResponseEntity<?> findDivisors(@RequestBody DivisorRequest divisorRequest) {
        DivisorResponse response = divisorMapperService.mapDivisorsToValues(divisorRequest);
        return ResponseEntity.ok(response);
    }


}
