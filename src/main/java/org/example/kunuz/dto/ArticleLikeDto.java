package org.example.kunuz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLikeDto {

    private Long profileId;
    private Long articleId;
    private String status;

    //Profile
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String statusOFProfile;
    private String role;
    private String visible;
    private Integer photoId;

    //Article
    private String title;
    private String description;
    private String content;
    private String sharedCount;
    private Long imageId;
    private Long regionId;
    private Long categoryId;
    private Long moderatorId;
    private Long publisherId;
    private String statusOFArticle;
    private String visibleOFArticle;
    private Long viewCount;

    //RegionDto
    private Long orderNumber;
    private String name_uz;
    private String name_ru;
    private String name_eng;
    private String visibleOFRegion;

    //CategoryDto
    private Long orderNumberOFCategory;
    private String name_uzOFCategory;
    private String name_ruOFCategory;
    private String name_engOFCategory;
    private String visibleOFCategory;




}
