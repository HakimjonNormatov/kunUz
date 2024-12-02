package org.example.kunuz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentLikeDto {
    private Long profileId;
    private Long commentId;
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

    //Comment
    private Long profileIdOFComment;
    private String content;
    private UUID articleId;
    private Long replyId;
    private String visibleOFComment;

    //ProfileOFComment
    private String nameOFProf;
    private String surnameOFProf;
    private String emailOFProf;
    private String phoneOFProf;
    private String passwordOFProf;
    private String statusOFProf;
    private String roleOFProf;
    private String visibleOFProf;
    private Integer photoIdOFProf;

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
