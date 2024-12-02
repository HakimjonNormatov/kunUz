package org.example.kunuz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long profileId;
    private String content;
    private UUID articleId;
    private Long replyId;
    private String visible;

    //Profile
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String status;
    private String role;
    private String visibleProf;
    private Integer photoId;

    //Article
    private String title;
    private String description;
    private String contentOFArticle;
    private String sharedCount;
    private Long imageId;
    private Long regionId;
    private Long categoryId;
    private Long moderatorId;
    private Long publisherId;
    private String statusOFArticle;
    private String visibleOFArticle;
    private Long viewCount;

    //Region
    private Long orderNumber;
    private String name_uz;
    private String name_ru;
    private String name_eng;
    private String visibleOFRegion;

    //Category
    private Long orderNumberOFCategory;
    private String name_uzOFCategory;
    private String name_ruOFCategory;
    private String name_engOfCategory;
    private String visibleOFCategory;

}
