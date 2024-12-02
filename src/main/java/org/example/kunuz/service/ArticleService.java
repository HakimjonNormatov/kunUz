package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleDto;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Region;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleRepo;
import org.example.kunuz.repository.CategoryRepo;
import org.example.kunuz.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    RegionRepo regionRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public List<Article> getAll(){
        return articleRepo.findAll();
    }
    public Article getById(UUID id){
        return articleRepo.findById(id).get();
    }
    public Result add(ArticleDto articleDto){
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setContent(articleDto.getContent());
        article.setSharedCount(articleDto.getSharedCount());
        article.setImageId(articleDto.getImageId());
        Region region = new Region();
        region.setOrderNumber(articleDto.getOrderNumber());
        region.setName_uz(articleDto.getName_uz());
        region.setName_ru(articleDto.getName_ru());
        region.setName_eng(articleDto.getName_eng());
        region.setVisible(articleDto.getVisibleOFRegion());
        regionRepo.save(region);
        article.setRegionId(region);
        Category category = new Category();
        category.setOrderNumber(articleDto.getOrderNumberOFCategory());
        category.setName_uz(articleDto.getName_uzOFCategory());
        category.setName_ru(articleDto.getName_ruOFCategory());
        category.setName_eng(articleDto.getName_engOFCategory());
        category.setVisible(articleDto.getVisibleOFCategory());
        Category save2 = categoryRepo.save(category);
        article.setCategoryId((List<Category>) save2);
        article.setModeratorId(articleDto.getModeratorId());
        article.setPublisherId(articleDto.getPublisherId());
        article.setStatus(articleDto.getStatus());
        article.setVisible(articleDto.getVisible());
        article.setViewCount(articleDto.getViewCount());
        return new Result(true , "Qo`ildi");
    }
    public Result update(UUID id , ArticleDto articleDto){
        Optional<Article> byId = articleRepo.findById(id);
        if (byId.isPresent()){
            Article article = new Article();
            article.setTitle(articleDto.getTitle());
            article.setDescription(articleDto.getDescription());
            article.setContent(articleDto.getContent());
            article.setSharedCount(articleDto.getSharedCount());
            article.setImageId(articleDto.getImageId());
            Region region = new Region();
            region.setOrderNumber(articleDto.getOrderNumber());
            region.setName_uz(articleDto.getName_uz());
            region.setName_ru(articleDto.getName_ru());
            region.setName_eng(articleDto.getName_eng());
            region.setVisible(articleDto.getVisibleOFRegion());
            regionRepo.save(region);
            article.setRegionId(region);
            Category category = new Category();
            category.setOrderNumber(articleDto.getOrderNumberOFCategory());
            category.setName_uz(articleDto.getName_uzOFCategory());
            category.setName_ru(articleDto.getName_ruOFCategory());
            category.setName_eng(articleDto.getName_engOFCategory());
            category.setVisible(articleDto.getVisibleOFCategory());
            Category save2 = categoryRepo.save(category);
            article.setCategoryId((List<Category>) save2);
            article.setModeratorId(article.getModeratorId());
            article.setPublisherId(articleDto.getPublisherId());
            article.setStatus(articleDto.getStatus());
            article.setVisible(articleDto.getVisible());
            article.setViewCount(articleDto.getViewCount());
            return new Result(true , "O`zgartirildi");
        }
        return new Result(false , "Topilmadi");
    }
    public Result delete(UUID id){
        articleRepo.deleteById(id);
        return new Result(true , "O`chirildi");
    }




}
