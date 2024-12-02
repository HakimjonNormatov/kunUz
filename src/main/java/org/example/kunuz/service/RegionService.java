package org.example.kunuz.service;

import org.example.kunuz.dto.RegionDto;
import org.example.kunuz.model.Region;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepo regionRepo;

    public List<Region> getAll(){
        return regionRepo.findAll();
    }
    public Region getById(Long id){
        return regionRepo.findById(id).get();
    }
    public Result add(RegionDto regionDto){
        Region region = new Region();
        region.setOrderNumber(regionDto.getOrderNumber());
        region.setName_uz(regionDto.getName_uz());
        region.setName_ru(regionDto.getName_ru());
        region.setName_eng(regionDto.getName_eng());
        region.setVisible(regionDto.getVisible());
        regionRepo.save(region);
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , RegionDto regionDto){
        Optional<Region> byId = regionRepo.findById(id);
        if (byId.isPresent()){
            Region region = new Region();
            region.setOrderNumber(regionDto.getOrderNumber());
            region.setName_uz(regionDto.getName_uz());
            region.setName_ru(regionDto.getName_ru());
            region.setName_eng(regionDto.getName_eng());
            region.setVisible(regionDto.getVisible());
            regionRepo.save(region);
            return new Result(true , "Ozgartirildi");
        }
        return new Result(false , "Bunday foydalanuvchi topilmadi");
    }
    public Result delete(Long id){
        regionRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }


}
