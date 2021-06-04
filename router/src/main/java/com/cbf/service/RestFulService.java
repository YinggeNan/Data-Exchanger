package com.cbf.service;

import com.cbf.response.BrokerResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/4
 * @description
 */
@Service
public class RestFulService {
    RestTemplate restTemplate = new RestTemplate();
    public RestFulService(){
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    public void queryByGet(String url, Map<String, String> uriVariables){
        restTemplate.getForEntity(url, BrokerResponse.class, uriVariables);
    }
    public void queryByPost(String url){
//        restTemplate.postForEntity()
    }
}
