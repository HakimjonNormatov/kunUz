package org.example.kunuz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long orderNumber;
    private String name_uz;
    private String name_ru;
    private String name_eng;
    private String visible;

}
