package org.example.kunuz.service;

import org.example.kunuz.dto.AttachDto;
import org.example.kunuz.model.Attach;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.AttachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachService {

    @Autowired
    AttachRepo attachRepo;

    public List<Attach>getAll(){
        return attachRepo.findAll();
    }

    public Attach getById(UUID id){
        return attachRepo.findById(id).get();
    }

    public Result add(AttachDto attachDto){
        Attach attach = new Attach();
        attach.setOriginalName(attachDto.getOriginalName());
        attach.setPath(attachDto.getPath());
        attach.setSize(attachDto.getSize());
        attach.setExtension(attachDto.getExtension());
        attachRepo.save(attach);
        return new Result(true , "Qoshildi");
    }

    public Result update(UUID id , AttachDto attachDto){
        Optional<Attach> byId = attachRepo.findById(id);
        if(byId.isPresent()){
            Attach attach = new Attach();
            attach.setOriginalName(attachDto.getOriginalName());
            attach.setPath(attachDto.getPath());
            attach.setSize(attachDto.getSize());
            attach.setExtension(attachDto.getExtension());
            attachRepo.save(attach);
            return new Result(true , "Ozgartirildi");
        }
        return new Result(false, "Topilmadi");
    }
    public Result delete(UUID id){
        attachRepo.deleteById(id);
        return new Result(true , "Ochirildi");
    }

}
