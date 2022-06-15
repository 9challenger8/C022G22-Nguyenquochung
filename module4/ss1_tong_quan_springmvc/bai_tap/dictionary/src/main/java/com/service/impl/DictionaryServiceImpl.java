package com.service.impl;

import com.service.IDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService {


    @Override
    public String translate(String str) {
        String str1;
        switch (str){
            case "hello":
                str1="Xin chao";
                break;
            case "dog":
                str1="Cho";
                break;
            case "fish":
                str1="Ca";
                break;
            case "goodbye":
                str1="tam biet";
                break;
            case "good":
                str1="tot";
                break;
            default:
                str1="Error";
                break;

        }
        return  str1;
    }
}
