package mael.simplecodebase.mapper;

import mael.simplecodebase.dto.book.BookCreateDTO;
import mael.simplecodebase.dto.book.BookDTO;
import mael.simplecodebase.dto.book.BookLightDTO;
import mael.simplecodebase.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
                AuthorMapper.class,
                LibraryMapper.class
        }
)
public interface BookMapper {
    // DTO
    Book toEntity(BookDTO source);
    BookDTO toDTO(Book source);
    // LightDTO
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "libraries", ignore = true)
    Book toEntity(BookLightDTO source);
    BookLightDTO toLightDTO(Book source);

    // CreationDTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "settingLiteraryType", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "libraries", ignore = true)
    Book toEntity(BookCreateDTO source);
}
