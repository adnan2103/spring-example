package com.cdk.spring.service;

import com.cdk.spring.entity.Setting;
import com.cdk.spring.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by khana on 4/2/15.
 */
public interface SettingService {

    public User save(User user, Map<String, String> settingMap);

    public List<Setting> findAll(int userId);
}
