package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleLikeDto;
import org.example.kunuz.model.*;
import org.example.kunuz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleLikeService {

    @Autowired
    ArticleLikeRepo articleLikeRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    RegionRepo regionRepo;


    public List<ArticleLike> getAll(){
        return articleLikeRepo.findAll();
    }
    public ArticleLike getById(Long id){
        return articleLikeRepo.findById(id).get();
    }
    public Result add(ArticleLikeDto articleLikeDto){
        ArticleLike articleLike = new ArticleLike();
        Profile profile = new Profile();
        profile.setName(articleLikeDto.getName());
        profile.setSurname(articleLikeDto.getSurname());
        profile.setEmail(articleLikeDto.getEmail());
        profile.setPhone(articleLikeDto.getPhone());
        profile.setPassword(articleLikeDto.getPassword());
        profile.setStatus(articleLikeDto.getStatusOFProfile());
        profile.setRole(articleLikeDto.getRole());
        profile.setVisible(articleLikeDto.getVisible());
        profile.setPhotoId(articleLikeDto.getPhotoId());
        Profile save = profileRepo.save(profile);
        articleLike.setProfileId((List<Profile>) save);
        Article article = new Article();
        article.setTitle(articleLikeDto.getTitle());
        article.setDescription(articleLikeDto.getDescription());
        article.setContent(articleLikeDto.getContent());
        article.setSharedCount(articleLikeDto.getSharedCount());
        article.setImageId(articleLikeDto.getImageId());
        Region region = new Region();
        region.setOrderNumber(articleLikeDto.getOrderNumber());
        region.setName_uz(articleLikeDto.getName_uz());
        region.setName_ru(articleLikeDto.getName_ru());
        region.setName_eng(articleLikeDto.getName_eng());
        region.setVisible(articleLikeDto.getVisibleOFRegion());
        Region save1 = regionRepo.save(region);
        article.setRegionId(save1);
        Category category = new Category();
        category.setOrderNumber(articleLikeDto.getOrderNumberOFCategory());
        category.setName_uz(articleLikeDto.getName_uzOFCategory());
        category.setName_ru(articleLikeDto.getName_ruOFCategory());
        category.setName_eng(articleLikeDto.getName_eng());
        category.setVisible(articleLikeDto.getVisibleOFCategory());
        Category save2 = categoryRepo.save(category);
        article.setCategoryId((List<Category>) save2);
        article.setModeratorId(articleLikeDto.getModeratorId());
        article.setPublisherId(articleLikeDto.getPublisherId());
        article.setStatus(articleLikeDto.getStatus());
        article.setVisible(articleLikeDto.getVisible());
        article.setViewCount(articleLikeDto.getViewCount());
        Article save3 = articleRepo.save(article);
        articleLike.setArticleId(save3);
        articleLike.setStatus(articleLikeDto.getStatus());
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , ArticleLikeDto articleLikeDto){
        Optional<ArticleLike> byId = articleLikeRepo.findById(id);
        if (byId.isPresent()){
            ArticleLike articleLike = new ArticleLike();
            Profile profile = new Profile();
            profile.setName(articleLikeDto.getName());
            profile.setSurname(articleLikeDto.getSurname());
            profile.setEmail(articleLikeDto.getEmail());
            profile.setPhone(articleLikeDto.getPhone());
            profile.setPassword(articleLikeDto.getPassword());
            profile.setStatus(articleLikeDto.getStatusOFProfile());
            profile.setRole(articleLikeDto.getRole());
            profile.setVisible(articleLikeDto.getVisible());
            profile.setPhotoId(articleLikeDto.getPhotoId());
            Profile save = profileRepo.save(profile);
            articleLike.setProfileId((List<Profile>) save);
            Article article = new Article();
            article.setTitle(articleLikeDto.getTitle());
            article.setDescription(articleLikeDto.getDescription());
            article.setContent(articleLikeDto.getContent());
            article.setSharedCount(articleLikeDto.getSharedCount());
            article.setImageId(articleLikeDto.getImageId());
            Region region = new Region();
            region.setOrderNumber(articleLikeDto.getOrderNumber());
            region.setName_uz(articleLikeDto.getName_uz());
            region.setName_ru(articleLikeDto.getName_ru());
            region.setName_eng(articleLikeDto.getName_eng());
            region.setVisible(articleLikeDto.getVisibleOFRegion());
            Region save1 = regionRepo.save(region);
            article.setRegionId(save1);
            Category category = new Category();
            category.setOrderNumber(articleLikeDto.getOrderNumberOFCategory());
            category.setName_uz(articleLikeDto.getName_uzOFCategory());
            category.setName_ru(articleLikeDto.getName_ruOFCategory());
            category.setName_eng(articleLikeDto.getName_eng());
            category.setVisible(articleLikeDto.getVisibleOFCategory());
            Category save2 = categoryRepo.save(category);
            article.setCategoryId((List<Category>) save2);
            article.setModeratorId(articleLikeDto.getModeratorId());
            article.setPublisherId(articleLikeDto.getPublisherId());
            article.setStatus(articleLikeDto.getStatus());
            article.setVisible(articleLikeDto.getVisible());
            article.setViewCount(articleLikeDto.getViewCount());
            Article save3 = articleRepo.save(article);
            articleLike.setArticleId(save3);
            articleLike.setStatus(articleLikeDto.getStatus());
            return new Result(true , "O`zgartirildi");
        }
        return new Result(false , "Topilmadi");
    }
    public Result delete(Long id){
        articleLikeRepo.deleteById(id);
        return new Result(true , "O`chirildi");
    }




}
