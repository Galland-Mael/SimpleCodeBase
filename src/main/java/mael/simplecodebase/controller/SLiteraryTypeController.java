package mael.simplecodebase.controller;

import mael.simplecodebase.service.SLiteraryTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/literary-type")
public class SLiteraryTypeController extends AbstractSModelController<SLiteraryTypeService> {

    protected SLiteraryTypeController(SLiteraryTypeService baseService) {
        super(baseService);
    }

}

