package org.example.kunuz.service;

import org.example.kunuz.dto.ProfileDto;
import org.example.kunuz.model.Profile;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    public List<Profile>getAll(){
        return profileRepo.findAll();
    }
    public Profile getById(Long id){
        Optional<Profile> byId = profileRepo.findById(id);
        return byId.get();
    }
    public Result add(ProfileDto profileDto){

        boolean exists = profileRepo.existsByEmailAndPhone(profileDto.getEmail(), profileDto.getPhone());
        if (exists){
            return new Result(false , "Bunday accaunt mavjud");
        }
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPhone(profileDto.getPhone());
        profile.setPassword(profileDto.getPassword());
        profile.setStatus(profileDto.getStatus());
        profile.setRole(profileDto.getRole());
        profile.setVisible(profileDto.getVisible());
        profile.setPhotoId(profileDto.getPhotoId());
        profileRepo.save(profile);
        return new Result(true , "Qoshildi");
    }
    public Result update(Long id , ProfileDto profileDto){
        Optional<Profile> byId = profileRepo.findById(id);
        if (byId.isPresent()){
            Profile profile = new Profile();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPhone(profileDto.getPhone());
            profile.setPassword(profileDto.getPassword());
            profile.setStatus(profileDto.getStatus());
            profile.setRole(profileDto.getRole());
            profile.setVisible(profileDto.getVisible());
            profile.setPhotoId(profileDto.getPhotoId());
            profileRepo.save(profile);
            return new Result(true , "Ozgartirildi");
        }
        return new Result(false , "Bunday foydalanuvchi topilmadi");
    }
    public Result delete(Long id){
        profileRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }


}
