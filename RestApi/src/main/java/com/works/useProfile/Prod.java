package com.works.useProfile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Profile("prod")
public class Prod implements IConfig {

    @Override
    public Map<String, Object> config() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("count", 30);
        hm.put("api_key", "prod_asdasdkajsdalsjdklas");
        return hm;
    }

}
