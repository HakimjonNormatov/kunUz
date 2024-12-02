package org.example.kunuz.service;

import org.example.kunuz.dto.CommentDto;
import org.example.kunuz.model.*;
import org.example.kunuz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    RegionRepo regionRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    public Comment getById(Long id) {
        return commentRepo.findById(id).get();
    }

    public Result add(CommentDto commentDto) {
        Comment comment = new Comment();
        Profile profile = new Profile();
        profile.setName(commentDto.getName());
        profile.setSurname(commentDto.getSurname());
        profile.setEmail(commentDto.getEmail());
        profile.setPhone(commentDto.getPhone());
        profile.setPassword(commentDto.getPassword());
        profile.setStatus(commentDto.getStatus());
        profile.setRole(commentDto.getRole());
        profile.setVisible(commentDto.getVisibleProf());
        profile.setPhotoId(commentDto.getPhotoId());
        profileRepo.save(profile);
        comment.setProfileId(profile);
        comment.setContent(commentDto.getContent());
        Article article = new Article();
        article.setTitle(commentDto.getTitle());
        article.setDescription(commentDto.getDescription());
        article.setContent(commentDto.getContentOFArticle());
        article.setSharedCount(commentDto.getSharedCount());
        article.setImageId(commentDto.getImageId());
        Region region = new Region();
        region.setOrderNumber(commentDto.getOrderNumber());
        region.setName_uz(commentDto.getName_uz());
        region.setName_ru(commentDto.getName_ru());
        region.setName_eng(commentDto.getName_eng());
        region.setVisible(commentDto.getVisibleOFRegion());
        Region save = regionRepo.save(region);
        article.setRegionId(save);
        Category category = new Category();
        category.setOrderNumber(commentDto.getOrderNumberOFCategory());
        category.setName_uz(commentDto.getName_uzOFCategory());
        category.setName_ru(commentDto.getName_ruOFCategory());
        category.setName_eng(commentDto.getName_engOfCategory());
        category.setVisible(commentDto.getVisibleOFCategory());
        Category save2 = categoryRepo.save(category);
        article.setCategoryId((List<Category>) save2);
        article.setModeratorId(commentDto.getModeratorId());
        article.setPublisherId(commentDto.getPublisherId());
        article.setStatus(commentDto.getStatus());
        article.setVisible(commentDto.getVisible());
        article.setViewCount(commentDto.getViewCount());
        Article save1 = articleRepo.save(article);
        comment.setArticleId((List<Article>) save1);
        comment.setReplyId(commentDto.getReplyId());
        comment.setVisible(commentDto.getVisible());
        commentRepo.save(comment);
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , CommentDto commentDto) {
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId.isPresent()) {
            Comment comment = new Comment();
            Profile profile = new Profile();
            profile.setName(commentDto.getName());
            profile.setSurname(commentDto.getSurname());
            profile.setEmail(commentDto.getEmail());
            profile.setPhone(commentDto.getPhone());
            profile.setPassword(commentDto.getPassword());
            profile.setStatus(commentDto.getStatus());
            profile.setRole(commentDto.getRole());
            profile.setVisible(commentDto.getVisibleProf());
            profile.setPhotoId(commentDto.getPhotoId());
            profileRepo.save(profile);
            comment.setProfileId(profile);
            comment.setContent(commentDto.getContent());
            Article article = new Article();
            article.setTitle(commentDto.getTitle());
            article.setDescription(commentDto.getDescription());
            article.setContent(commentDto.getContentOFArticle());
            article.setSharedCount(commentDto.getSharedCount());
            article.setImageId(commentDto.getImageId());
            Region region = new Region();
            region.setOrderNumber(commentDto.getOrderNumber());
            region.setName_uz(commentDto.getName_uz());
            region.setName_ru(commentDto.getName_ru());
            region.setName_eng(commentDto.getName_eng());
            region.setVisible(commentDto.getVisibleOFRegion());
            Region save = regionRepo.save(region);
            article.setRegionId(save);
            Category category = new Category();
            category.setOrderNumber(commentDto.getOrderNumberOFCategory());
            category.setName_uz(commentDto.getName_uzOFCategory());
            category.setName_ru(commentDto.getName_ruOFCategory());
            category.setName_eng(commentDto.getName_engOfCategory());
            category.setVisible(commentDto.getVisibleOFCategory());
            Category save2 = categoryRepo.save(category);
            article.setCategoryId((List<Category>) save2);
            article.setModeratorId(commentDto.getModeratorId());
            article.setPublisherId(commentDto.getPublisherId());
            article.setStatus(commentDto.getStatus());
            article.setVisible(commentDto.getVisible());
            article.setViewCount(commentDto.getViewCount());
            Article save1 = articleRepo.save(article);
            comment.setArticleId((List<Article>) save1);
            comment.setReplyId(commentDto.getReplyId());
            comment.setVisible(commentDto.getVisible());
            commentRepo.save(comment);

            return new Result(true , "Ozgartirildi");
        }
        return new Result(false , "Bunday foydalanuvchi topilmadi");
    }
    public Result delete(Long id){
        commentRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }

}
