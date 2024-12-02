package org.example.kunuz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article_TypeDto {

    private Long orderNumber;
    private String name_uz;
    private String name_ru;
    private String name_eng;
    private String visible;

}
