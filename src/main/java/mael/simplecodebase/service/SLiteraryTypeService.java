package mael.simplecodebase.service;

import mael.simplecodebase.enumeration.SLiteraryTypeEnum;
import mael.simplecodebase.dto.SLiteraryTypeDTO;
import mael.simplecodebase.exception.ErrorMessageEnum;
import mael.simplecodebase.mapper.SLiteraryTypeMapper;
import mael.simplecodebase.model.SLiteraryType;
import mael.simplecodebase.repository.SLiteraryTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class SLiteraryTypeService extends AbstractSModelService<
        SLiteraryType,
        SLiteraryTypeDTO,
        SLiteraryTypeEnum,
        SLiteraryTypeRepository,
        SLiteraryTypeMapper> {

    public SLiteraryTypeService(
            SLiteraryTypeMapper baseMapper,
            SLiteraryTypeRepository repository
    ) {
        super(repository, baseMapper);
    }

    @Override
    public ErrorMessageEnum notFoundMessage() {
        return ErrorMessageEnum.S_LITERAL_TYPE_NOT_FOUND;
    }


    public SLiteraryTypeDTO findByEnumInDTO(SLiteraryTypeEnum sLiteraryTypeEnum) {
        return this.baseMapper.toDTO(this.findByEnum(sLiteraryTypeEnum));
    }
}
