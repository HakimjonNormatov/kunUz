package org.example.kunuz.service;

import org.example.kunuz.dto.CommentLikeDto;
import org.example.kunuz.model.*;
import org.example.kunuz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentLikeService {

    @Autowired
    CommentLikeRepo commentLikeRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    RegionRepo regionRepo;

    public List<CommentLike>getAll(){
        return commentLikeRepo.findAll();
    }
    public CommentLike getById(Long id){
        return commentLikeRepo.findById(id).get();
    }
    public Result add(CommentLikeDto commentLikeDto){
        CommentLike commentLike = new CommentLike();
        Profile profile = new Profile();
        profile.setName(commentLikeDto.getName());
        profile.setSurname(commentLikeDto.getSurname());
        profile.setEmail(commentLikeDto.getEmail());
        profile.setPhone(commentLikeDto.getPhone());
        profile.setPassword(commentLikeDto.getPassword());
        profile.setStatus(commentLikeDto.getStatusOFProfile());
        profile.setRole(commentLikeDto.getRole());
        profile.setVisible(commentLikeDto.getVisible());
        profile.setPhotoId(commentLikeDto.getPhotoId());
        Profile save = profileRepo.save(profile);
        commentLike.setProfileId((List<Profile>)save);
        Comment comment = new Comment();
        Profile profile1 = new Profile();
        profile1.setName(commentLikeDto.getName());
        profile1.setSurname(commentLikeDto.getSurname());
        profile1.setEmail(commentLikeDto.getEmail());
        profile1.setPhone(commentLikeDto.getPhone());
        profile1.setPassword(commentLikeDto.getPassword());
        profile1.setStatus(commentLikeDto.getStatus());
        profile1.setRole(commentLikeDto.getRole());
        profile1.setVisible(commentLikeDto.getVisible());
        profile1.setPhotoId(commentLikeDto.getPhotoId());
        profileRepo.save(profile1);
        comment.setProfileId(profile1);
        comment.setContent(commentLikeDto.getContent());
        Article article = new Article();
        article.setTitle(commentLikeDto.getTitle());
        article.setDescription(commentLikeDto.getDescription());
        article.setContent(commentLikeDto.getContentOFArticle());
        article.setSharedCount(commentLikeDto.getSharedCount());
        article.setImageId(commentLikeDto.getImageId());
        Region region = new Region();
        region.setOrderNumber(commentLikeDto.getOrderNumber());
        region.setName_uz(commentLikeDto.getName_uz());
        region.setName_ru(commentLikeDto.getName_ru());
        region.setName_eng(commentLikeDto.getName_eng());
        region.setVisible(commentLikeDto.getVisibleOFRegion());
        Region save1 = regionRepo.save(region);
        article.setRegionId(save1);
        Category category = new Category();
        category.setOrderNumber(commentLikeDto.getOrderNumberOFCategory());
        category.setName_uz(commentLikeDto.getName_uzOFCategory());
        category.setName_ru(commentLikeDto.getName_ruOFCategory());
        category.setName_eng(commentLikeDto.getName_engOfCategory());
        category.setVisible(commentLikeDto.getVisibleOFCategory());
        Category save2 = categoryRepo.save(category);
        article.setCategoryId((List<Category>) save2);
        article.setModeratorId(commentLikeDto.getModeratorId());
        article.setPublisherId(commentLikeDto.getPublisherId());
        article.setStatus(commentLikeDto.getStatus());
        article.setVisible(commentLikeDto.getVisible());
        article.setViewCount(commentLikeDto.getViewCount());
        Article save3 = articleRepo.save(article);
        comment.setArticleId((List<Article>) save3);
        comment.setReplyId(commentLikeDto.getReplyId());
        comment.setVisible(commentLikeDto.getVisible());
        commentRepo.save(comment);
        commentLike.setCommentId(comment);
        commentLike.setStatus(commentLikeDto.getStatus());
        commentLikeRepo.save(commentLike);
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , CommentLikeDto commentLikeDto){
        Optional<CommentLike> byId = commentLikeRepo.findById(id);
        if (byId.isPresent()){
            CommentLike commentLike = new CommentLike();
            Profile profile = new Profile();
            profile.setName(commentLikeDto.getName());
            profile.setSurname(commentLikeDto.getSurname());
            profile.setEmail(commentLikeDto.getEmail());
            profile.setPhone(commentLikeDto.getPhone());
            profile.setPassword(commentLikeDto.getPassword());
            profile.setStatus(commentLikeDto.getStatusOFProfile());
            profile.setRole(commentLikeDto.getRole());
            profile.setVisible(commentLikeDto.getVisible());
            profile.setPhotoId(commentLikeDto.getPhotoId());
            Profile save = profileRepo.save(profile);
            commentLike.setProfileId((List<Profile>)save);
            Comment comment = new Comment();
            Profile profile1 = new Profile();
            profile1.setName(commentLikeDto.getNameOFProf());
            profile1.setSurname(commentLikeDto.getSurnameOFProf());
            profile1.setEmail(commentLikeDto.getEmailOFProf());
            profile1.setPhone(commentLikeDto.getPhoneOFProf());
            profile1.setPassword(commentLikeDto.getPasswordOFProf());
            profile1.setStatus(commentLikeDto.getStatusOFProf());
            profile1.setRole(commentLikeDto.getRoleOFProf());
            profile1.setVisible(commentLikeDto.getVisibleOFProf());
            profile1.setPhotoId(commentLikeDto.getPhotoIdOFProf());
            profileRepo.save(profile1);
            comment.setProfileId(profile1);
            comment.setContent(commentLikeDto.getContent());
            Article article = new Article();
            article.setTitle(commentLikeDto.getTitle());
            article.setDescription(commentLikeDto.getDescription());
            article.setContent(commentLikeDto.getContentOFArticle());
            article.setSharedCount(commentLikeDto.getSharedCount());
            article.setImageId(commentLikeDto.getImageId());
            Region region = new Region();
            region.setOrderNumber(commentLikeDto.getOrderNumber());
            region.setName_uz(commentLikeDto.getName_uz());
            region.setName_ru(commentLikeDto.getName_ru());
            region.setName_eng(commentLikeDto.getName_eng());
            region.setVisible(commentLikeDto.getVisibleOFRegion());
            Region save1 = regionRepo.save(region);
            article.setRegionId(save1);
            Category category = new Category();
            category.setOrderNumber(commentLikeDto.getOrderNumberOFCategory());
            category.setName_uz(commentLikeDto.getName_uzOFCategory());
            category.setName_ru(commentLikeDto.getName_ruOFCategory());
            category.setName_eng(commentLikeDto.getName_engOfCategory());
            category.setVisible(commentLikeDto.getVisibleOFCategory());
            Category save2 = categoryRepo.save(category);
            article.setCategoryId((List<Category>) save2);
            article.setModeratorId(commentLikeDto.getModeratorId());
            article.setPublisherId(commentLikeDto.getPublisherId());
            article.setStatus(commentLikeDto.getStatusOFArticle());
            article.setVisible(commentLikeDto.getVisibleOFArticle());
            article.setViewCount(commentLikeDto.getViewCount());
            Article save3 = articleRepo.save(article);
            comment.setArticleId((List<Article>) save3);
            comment.setReplyId(commentLikeDto.getReplyId());
            comment.setVisible(commentLikeDto.getVisibleOFComment());
            commentRepo.save(comment);
            commentLike.setCommentId(comment);
            commentLike.setStatus(commentLikeDto.getStatus());
            commentLikeRepo.save(commentLike);
            return new Result(true , "Ozgartirildi");
        }
        return new Result(false , "Topilmadi");
    }
    public Result delete(Long id){
        commentLikeRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }

}
