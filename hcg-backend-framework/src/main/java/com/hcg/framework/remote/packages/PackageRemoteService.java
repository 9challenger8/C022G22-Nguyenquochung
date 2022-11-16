package com.hcg.framework.remote.packages;


import com.fasterxml.jackson.core.type.TypeReference;
import com.hcg.framework.dto.packages.PackageFilter;
import com.hcg.framework.dto.packages.PackageDto;
import com.hcg.framework.core.httpClientRemote.ClientRemoteEnum;
import com.hcg.framework.core.httpClientRemote.HttpClientRemoteService;
import com.hcg.framework.core.utils.ReadFileUtils;
import com.hcg.framework.core.graphql.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

//TODO a sample - don't use it
@Component
public class PackageRemoteService
{
    final Logger logger = LoggerFactory.getLogger(PackageRemoteService.class);

    @Value("classpath*:/remote/packages/*")
    private Resource[] queryFiles;

    @Autowired
    private  ReadFileUtils readFileUtils;

    private Map<String, String> queryGraphMap;

    @Autowired
    private HttpClientRemoteService httpClientRemoteService;



    @PostConstruct
    private void firstInitialize(){
        try {
//            readFileUtils = new ReadFileUtils();
            queryGraphMap = readFileUtils.readFiles( this.queryFiles );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseData<PackageDto> packageList(PackageFilter filter) throws IOException, URISyntaxException {
        //Set Request Content
        String query = PackageModuleQueryEnum.packageList.value();

        //Variables
        Map<String, Object> variables = new HashMap<>();
        variables.put("filter" , filter);

        //Execute post request
        return httpClientRemoteService.entity(query, new TypeReference<ResponseData<PackageDto>>(){},
                ClientRemoteEnum.PackageModule,this.queryGraphMap,variables);
    }

}
