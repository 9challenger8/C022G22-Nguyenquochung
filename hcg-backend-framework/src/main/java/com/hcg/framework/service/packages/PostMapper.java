package com.hcg.framework.service.packages;


import com.hcg.framework.dto.post.PostDto;
import com.hcg.framework.dto.post.PostInput;
import com.hcg.framework.entity.post.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper
{
        /**
         * Entity to DTO
         * @param input
         * @return
         */
        @Mappings({

        })
        List<PostDto> mappingEntity(List<Post> input);

        @Mappings({
                @Mapping(target = "id", source = "id"),
                @Mapping(target = "title", source = "title"),
                @Mapping(target = "category", source = "category"),
//                @Mapping(target = "date", source = "date"),
        })
        PostDto mappingEntity(Post entity);

        @Mappings({
                @Mapping(target = "id", ignore = true),
                @Mapping(target = "title", source = "input.title" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
                @Mapping(target = "category", source = "input.category" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
        })
        Post mappingInput2Entity(PostInput input);
}
