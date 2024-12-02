package org.example.kunuz.service;

import org.example.kunuz.dto.CategoryDto;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAll(){
        return categoryRepo.findAll();
    }
    public Category getById(Long id){
        return categoryRepo.findById(id).get();
    }
    public Result add(CategoryDto categoryDto){
        Category category = new Category();
        category.setOrderNumber(categoryDto.getOrderNumber());
        category.setName_uz(categoryDto.getName_uz());
        category.setName_ru(categoryDto.getName_ru());
        category.setName_eng(categoryDto.getName_eng());
        category.setVisible(categoryDto.getVisible());
        categoryRepo.save(category);
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , CategoryDto categoryDto){
        Optional<Category> byId = categoryRepo.findById(id);
        if (byId.isPresent()){
            Category category = new Category();
            category.setOrderNumber(categoryDto.getOrderNumber());
            category.setName_uz(categoryDto.getName_uz());
            category.setName_ru(categoryDto.getName_ru());
            category.setName_eng(categoryDto.getName_eng());
            category.setVisible(categoryDto.getVisible());
            categoryRepo.save(category);
            return new Result(true , "Ozgartirildi");
        }
        return new Result(false , "Bunday foydalanuvchi topilmadi");
    }
    public Result delete(Long id){
        categoryRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }

}
