package mael.simplecodebase.controller;

import mael.simplecodebase.dto.SettingLiteraryTypeDTO;
import mael.simplecodebase.model.SettingLiteraryType;
import mael.simplecodebase.service.SettingLiteraryTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/setting-literary-type")
public class SettingLiteraryTypeController {
    private final SettingLiteraryTypeService baseService;

    protected SettingLiteraryTypeController(SettingLiteraryTypeService baseService) {

        this.baseService = baseService;
    }

    @GetMapping
    public ResponseEntity<List<SettingLiteraryType>>findAllInDTO() {
        return ResponseEntity.ok(this.baseService.findAll());
    }


}

