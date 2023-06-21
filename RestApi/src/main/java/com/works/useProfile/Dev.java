package com.works.useProfile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Profile("dev")
public class Dev implements IConfig {

    @Override
    public Map<String, Object> config() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("count", 50);
        hm.put("api_key", "dev_asdasdkajsdalsjdklas");
        return hm;
    }

}
