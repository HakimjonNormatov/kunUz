package org.example.kunuz.service;

import org.example.kunuz.dto.SavedArticleDto;
import org.example.kunuz.model.*;
import org.example.kunuz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedArticleService {

    @Autowired
    SavedArticleRepo savedArticleRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    RegionRepo regionRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public List<SavedArticle>getAll(){
        return savedArticleRepo.findAll();
    }
    public SavedArticle getById(Long id){
        return savedArticleRepo.findById(id).get();
    }
    public Result add(SavedArticleDto savedArticleDto){
        SavedArticle savedArticle = new SavedArticle();
        Profile profile = new Profile();
        profile.setName(savedArticleDto.getName());
        profile.setSurname(savedArticleDto.getSurname());
        profile.setEmail(savedArticleDto.getEmail());
        profile.setPhone(savedArticleDto.getPhone());
        profile.setPassword(savedArticleDto.getPassword());
        profile.setStatus(savedArticleDto.getStatus());
        profile.setRole(savedArticleDto.getRole());
        profile.setVisible(savedArticleDto.getVisible());
        profile.setPhotoId(savedArticleDto.getPhotoId());
        Profile save = profileRepo.save(profile);
        savedArticle.setProfileId((List<Profile>)save);
        Article article = new Article();
        article.setTitle(savedArticleDto.getTitle());
        article.setDescription(savedArticleDto.getDescription());
        article.setContent(savedArticleDto.getContent());
        article.setSharedCount(savedArticleDto.getSharedCount());
        article.setImageId(savedArticleDto.getImageId());
        Region region = new Region();
        region.setOrderNumber(savedArticleDto.getOrderNumber());
        region.setName_uz(savedArticleDto.getName_uz());
        region.setName_ru(savedArticleDto.getName_ru());
        region.setName_eng(savedArticleDto.getName_eng());
        region.setVisible(savedArticleDto.getVisibleOFRegion());
        Region save1 = regionRepo.save(region);
        article.setRegionId(save1);
        Category category = new Category();
        category.setOrderNumber(savedArticleDto.getOrderNumberOFCategory());
        category.setName_uz(savedArticleDto.getName_uzOFCategory());
        category.setName_ru(savedArticleDto.getName_ruOFCategory());
        category.setName_eng(savedArticleDto.getName_engOFCategory());
        category.setVisible(savedArticleDto.getVisibleOFCategory());
        Category save2 = categoryRepo.save(category);
        article.setCategoryId((List<Category>) save2);
        article.setModeratorId(savedArticleDto.getModeratorId());
        article.setPublisherId(savedArticleDto.getPublisherId());
        article.setStatus(savedArticleDto.getStatusOFArticle());
        article.setVisible(savedArticleDto.getVisibleOFArticle());
        article.setViewCount(savedArticleDto.getViewCount());
        savedArticle.setArticleId(article);
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , SavedArticleDto savedArticleDto){
        Optional<SavedArticle> byId = savedArticleRepo.findById(id);
        if (byId.isPresent()){
            SavedArticle savedArticle = new SavedArticle();
            Profile profile = new Profile();
            profile.setName(savedArticleDto.getName());
            profile.setSurname(savedArticleDto.getSurname());
            profile.setEmail(savedArticleDto.getEmail());
            profile.setPhone(savedArticleDto.getPhone());
            profile.setPassword(savedArticleDto.getPassword());
            profile.setStatus(savedArticleDto.getStatus());
            profile.setRole(savedArticleDto.getRole());
            profile.setVisible(savedArticleDto.getVisible());
            profile.setPhotoId(savedArticleDto.getPhotoId());
            Profile save = profileRepo.save(profile);
            savedArticle.setProfileId((List<Profile>)save);
            Article article = new Article();
            article.setTitle(savedArticleDto.getTitle());
            article.setDescription(savedArticleDto.getDescription());
            article.setContent(savedArticleDto.getContent());
            article.setSharedCount(savedArticleDto.getSharedCount());
            article.setImageId(savedArticleDto.getImageId());
            Region region = new Region();
            region.setOrderNumber(savedArticleDto.getOrderNumber());
            region.setName_uz(savedArticleDto.getName_uz());
            region.setName_ru(savedArticleDto.getName_ru());
            region.setName_eng(savedArticleDto.getName_eng());
            region.setVisible(savedArticleDto.getVisibleOFRegion());
            Region save1 = regionRepo.save(region);
            article.setRegionId(save1);
            Category category = new Category();
            category.setOrderNumber(savedArticleDto.getOrderNumberOFCategory());
            category.setName_uz(savedArticleDto.getName_uzOFCategory());
            category.setName_ru(savedArticleDto.getName_ruOFCategory());
            category.setName_eng(savedArticleDto.getName_engOFCategory());
            category.setVisible(savedArticleDto.getVisibleOFCategory());
            Category save2 = categoryRepo.save(category);
            article.setCategoryId((List<Category>) save2);
            article.setModeratorId(article.getModeratorId());
            article.setPublisherId(savedArticleDto.getPublisherId());
            article.setStatus(savedArticleDto.getStatus());
            article.setVisible(savedArticleDto.getVisible());
            article.setViewCount(savedArticleDto.getViewCount());
            savedArticle.setArticleId(article);
            return new Result(true , "Ozgartirildi");
        }
        return new Result(false , "Topilmadi");
    }
    public Result delete(Long id){
        savedArticleRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }

}
