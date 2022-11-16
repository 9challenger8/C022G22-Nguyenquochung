package com.hcg.framework.service.packages;

import com.hcg.framework.core.graphql.ResponseContent;
import com.hcg.framework.dto.packages.PackageDto;
import com.hcg.framework.dto.packages.PackageFilter;
import com.hcg.framework.dto.post.PostDto;
import com.hcg.framework.dto.post.PostFilter;
import com.hcg.framework.core.graphql.ResponseData;
import com.hcg.framework.dto.post.PostInput;

public interface PostService {
    ResponseData<PostDto> postList(PostFilter filter) ;

    ResponseContent<PostDto> addPost(PostInput filter) ;
    ResponseData<PackageDto> packagesList(PackageFilter filter) ;
}

