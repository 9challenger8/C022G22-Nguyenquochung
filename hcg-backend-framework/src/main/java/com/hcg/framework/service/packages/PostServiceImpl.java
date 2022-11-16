package com.hcg.framework.service.packages;

import com.hcg.framework.core.graphql.ResponseContent;
import com.hcg.framework.core.graphql.ResponseContentStatusEnum;
import com.hcg.framework.core.utils.EbeanUtils;
import com.hcg.framework.core.validation.ValidationMessage;
import com.hcg.framework.dto.packages.PackageDto;
import com.hcg.framework.dto.packages.PackageFilter;
import com.hcg.framework.dto.post.PostDto;
import com.hcg.framework.dto.post.PostFilter;
import com.hcg.framework.core.common.Filter;
import com.hcg.framework.core.graphql.ResponseData;
import com.hcg.framework.dto.post.PostInput;
import com.hcg.framework.entity.post.Post;
import com.hcg.framework.entity.post.query.QPost;
import com.hcg.framework.remote.packages.PackageRemoteService;
import com.hcg.framework.validation.PackageValidationMessage;
import io.ebeaninternal.api.SpiEbeanServer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper mapper;

    @Autowired
    private PackageRemoteService packageRemoteService;

    @Override
    public ResponseData<PostDto> postList(PostFilter filter) {
        filter = Filter.setDefaultValue(filter,PostFilter.class);

//        Define query
        QPost query = new QPost().where();


        //Filter query
        this.setFilterForQuery(query, filter);

        //Find result
        ResponseData<Post> pagedList = EbeanUtils.queryEntity(query,filter);
        ResponseData<PostDto> responseData = new ResponseData(pagedList, mapper.mappingEntity(pagedList.getData()));

        //this is only for demo
        for ( PostDto p : responseData.getData()  ) {
            try {
                PackageFilter filter1 = new PackageFilter();
                p.setPackages( packageRemoteService.packageList(filter1).getData() ) ;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }


        return responseData;
//        return null;
    }

    @Override
    public ResponseContent<PostDto> addPost(PostInput input) {
        Post entity = mapper.mappingInput2Entity(input);
        entity.save();
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        status = ResponseContentStatusEnum.SUCCESS;
        ValidationMessage resultMessage = new ValidationMessage(PackageValidationMessage.CREATE_SUCCESS);
        ResponseContent<PostDto> responseContent = new ResponseContent<>(resultMessage, status, mapper.mappingEntity(entity) );
        return responseContent;
    }

    @Override
    public ResponseData<PackageDto> packagesList(PackageFilter filter) {

        try {
            return packageRemoteService.packageList(filter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
       // return null;
    }

    private void setFilterForQuery(QPost query, PostFilter filter) {
        query.title.isNotNull();
    }



  

}
