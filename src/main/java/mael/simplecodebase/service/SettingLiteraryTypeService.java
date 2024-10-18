package mael.simplecodebase.service;

import mael.simplecodebase.dto.SettingLiteraryTypeDTO;
import mael.simplecodebase.enumeration.SettingLiteraryTypeEnum;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.mapper.SettingLiteraryTypeMapper;
import mael.simplecodebase.model.SettingLiteraryType;
import mael.simplecodebase.repository.SettingLiteraryTypeRepository;
import org.springframework.stereotype.Service;

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


    public SettingLiteraryTypeDTO findByEnumInDTO(SettingLiteraryTypeEnum settingLiteraryTypeEnum) {
        return this.baseMapper.toDTO(this.findByEnum(settingLiteraryTypeEnum));
    }
}
