package mael.simplecodebase.service;

import mael.simplecodebase.dto.SettingLiteraryTypeDTO;
import mael.simplecodebase.config.CacheName;
import mael.simplecodebase.enumeration.SettingLiteraryTypeEnum;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.mapper.SettingLiteraryTypeMapper;
import mael.simplecodebase.model.SettingLiteraryType;
import mael.simplecodebase.repository.SettingLiteraryTypeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingLiteraryTypeService extends AbstractSettingModelService<
        SettingLiteraryType,
        SettingLiteraryTypeDTO,
        SettingLiteraryTypeEnum,
        SettingLiteraryTypeRepository,
        SettingLiteraryTypeMapper> {

    public SettingLiteraryTypeService(
            SettingLiteraryTypeMapper baseMapper,
            SettingLiteraryTypeRepository repository
    ) {
        super(repository, baseMapper);
    }

    @Override
    public ErrorMessageEnum notFoundMessage() {
        return ErrorMessageEnum.S_LITERAL_TYPE_NOT_FOUND;
    }

    @Cacheable(value = CacheName.SETTING_LITERARY_TYPE_DTO)
    public List<SettingLiteraryTypeDTO> findAllInDTO() {
        return baseY.toListDTO(findAll());
    }

    public List<SettingLiteraryType> findAll() {
        return new ArrayList<>(baseR.findAll());
    }
}
