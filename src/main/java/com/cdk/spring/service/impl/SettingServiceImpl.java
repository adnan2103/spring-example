package com.cdk.spring.service.impl;

import com.cdk.spring.entity.Setting;
import com.cdk.spring.entity.User;
import com.cdk.spring.repository.SettingRepository;
import com.cdk.spring.repository.UserRepository;
import com.cdk.spring.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by khana on 4/2/15.
 */
@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    SettingRepository settingRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public User save(User user, Map<String, String> settingMap) {
        Setting setting = null;
        List<Setting> settings = new ArrayList<Setting>();

        for(Map.Entry<String, String> entry : settingMap.entrySet()){
            setting = new Setting();
            setting.setUser(user);
            setting.setName(entry.getKey());
            setting.setValue(entry.getValue());
            settings.add(setting);
        }

        return userRepository.save(user);
    }

    @Override
    public List<Setting> findAll(int userId) {
        return (List<Setting>) settingRepository.findAll();
    }
}
