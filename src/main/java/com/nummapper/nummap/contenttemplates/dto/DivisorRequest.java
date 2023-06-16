package com.nummapper.nummap.contenttemplates.dto;

import com.nummapper.nummap.contenttemplates.enumerate.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DivisorRequest {
    private Category category;
    private List<Integer> numbers;
}
