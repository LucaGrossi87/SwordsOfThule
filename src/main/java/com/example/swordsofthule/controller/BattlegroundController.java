package com.example.swordsofthule.controller;

import com.example.swordsofthule.dto.battlegroundDTO.BattlegroundCreateRequest;
import com.example.swordsofthule.dto.battlegroundDTO.BattlegroundDeleteResponse;
import com.example.swordsofthule.dto.battlegroundDTO.BattlegroundEditRequest;
import com.example.swordsofthule.dto.battlegroundDTO.BattlegroundResponse;
import com.example.swordsofthule.entity.Battleground;
import com.example.swordsofthule.service.BattlegroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/battlegrounds")
public class BattlegroundController {

    @Autowired
    BattlegroundService bgService;

    @GetMapping
    public List<BattlegroundResponse> getAllBattlegrounds() {
        return bgService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping ("/{id}")
    public BattlegroundResponse getBattlegroundById(@PathVariable Long id){
        Optional<Battleground> bg = bgService.findById(id);
        return bg.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public BattlegroundResponse createBattleground(@RequestBody BattlegroundCreateRequest bgCreateReq){
        Battleground bg = convertToEntity(bgCreateReq);
        Battleground savedBg = bgService.save(bg);
        return convertToDTO(savedBg);
    }

    @PutMapping ("/{id}")
    public BattlegroundResponse editBattleground(@PathVariable Long id, @RequestBody BattlegroundEditRequest bgEditReq){
        Battleground bg = converToEntity(bgEditReq);
        bg.setId(id);
        Battleground updatedBg = bgService.save(bg);
        return convertToDTO(updatedBg);
    }

    @DeleteMapping ("/{id}")
    public BattlegroundDeleteResponse deleteBattleground (@PathVariable Long id){
        bgService.deleteById(id);
        BattlegroundDeleteResponse response = new BattlegroundDeleteResponse();
        response.setId(id);
        response.setMessage("Battleground eliminato");
        return response;
    }

    private BattlegroundResponse convertToDTO (Battleground bg) {
        BattlegroundResponse dto= new BattlegroundResponse();
        dto.setId(bg.getId());
        dto.setName(bg.getName());
        dto.setType(bg.getType());
        return dto;
    }

    private Battleground convertToEntity (BattlegroundCreateRequest dto){
        return new Battleground(dto.getName(),dto.getType());
    }

    private Battleground converToEntity (BattlegroundEditRequest dto){
        return new Battleground(dto.getName(), dto.getType());
    }
}
