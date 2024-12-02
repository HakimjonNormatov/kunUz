package org.example.kunuz.service;

import org.example.kunuz.dto.Article_TypeDto;
import org.example.kunuz.model.Article_Type;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.Article_TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Article_TypeService {

    @Autowired
    Article_TypeRepo articleTypeRepo;

    public List<Article_Type>getAll(){
        return articleTypeRepo.findAll();
    }
    public Article_Type getById(Long id){
        return articleTypeRepo.findById(id).get();
    }
    public Result add(Article_TypeDto articleTypeDto){
        Article_Type articleType = new Article_Type();
        articleType.setOrderNumber(articleTypeDto.getOrderNumber());
        articleType.setName_uz(articleTypeDto.getName_uz());
        articleType.setName_ru(articleTypeDto.getName_ru());
        articleType.setName_eng(articleTypeDto.getName_eng());
        articleType.setVisible(articleTypeDto.getVisible());
        articleTypeRepo.save(articleType);
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , Article_TypeDto articleTypeDto){
        Optional<Article_Type> byId = articleTypeRepo.findById(id);
        if (byId.isPresent()){
            Article_Type articleType = new Article_Type();
            articleType.setOrderNumber(articleTypeDto.getOrderNumber());
            articleType.setName_uz(articleTypeDto.getName_uz());
            articleType.setName_ru(articleTypeDto.getName_ru());
            articleType.setName_eng(articleTypeDto.getName_eng());
            articleType.setVisible(articleTypeDto.getVisible());
            articleTypeRepo.save(articleType);
            return new Result(true , "Ozgartirildi");
        }
        return new Result(false , "Bunday foydalanuvchi topilmadi");
    }
    public Result Delete(Long id ){
        articleTypeRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }



}
