package mael.simplecodebase.controller;

import mael.simplecodebase.service.SettingLiteraryTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/literary-type")
public class SettingLiteraryTypeController extends AbstractSModelController<SettingLiteraryTypeService> {

    protected SettingLiteraryTypeController(SettingLiteraryTypeService baseService) {
        super(baseService);
    }

}

