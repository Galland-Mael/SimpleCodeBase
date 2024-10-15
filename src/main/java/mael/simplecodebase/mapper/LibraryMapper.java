package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.BookDTO;
import mael.simplecodebase.dto.BookLightDTO;
import mael.simplecodebase.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface BookMapper {
    // DTO
    Book toEntity(BookDTO source);
    BookDTO toDTO(Book source);
    // LightDTO
    Book toEntity(BookLightDTO source);
    BookLightDTO toLightDTO(Book source);
}
