package mael.simplecodebase.controller;
import mael.simplecodebase.service.AbstractSModelService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public abstract class AbstractSModelController<
        S extends AbstractSModelService<?, ?, ?, ?, ?>> {

    protected final S baseService;

    protected AbstractSModelController(S baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public List<?> findAllInDTO() {
        return this.baseService.findAllInDTO();
    }
}

