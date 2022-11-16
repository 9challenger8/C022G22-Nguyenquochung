package com.hcg.framework.controller;

import com.hcg.framework.core.graphql.ResponseContent;
import com.hcg.framework.dto.packages.PackageDto;
import com.hcg.framework.dto.packages.PackageFilter;
import com.hcg.framework.dto.post.PostDto;
import com.hcg.framework.dto.post.PostFilter;
import com.hcg.framework.dto.post.PostInput;
import com.hcg.framework.service.packages.PostService;
import com.hcg.framework.core.common.BaseController;
import com.hcg.framework.core.graphql.ResponseData;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller()

public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @QueryMapping
    public ResponseData<PostDto> recentPosts(DataFetchingEnvironment env) {
        PostFilter filter = mapEnv2Filter(env, PostFilter.class);
        return postService.postList(filter);
    }

    @QueryMapping
    public ResponseData<PackageDto> packagesList(DataFetchingEnvironment env) {
        PackageFilter filter = mapEnv2Filter(env, PackageFilter.class);
        return postService.packagesList(filter);
    }

    @MutationMapping
    public ResponseContent<PostDto> createPost(DataFetchingEnvironment env){
        PostInput postInput = mapEnv2Input(env, PostInput.class);
        return postService.addPost(postInput);
    }

}