package com.cdk.spring.web;

import com.cdk.spring.entity.Setting;
import com.cdk.spring.entity.User;
import com.cdk.spring.repository.SettingRepository;
import com.cdk.spring.repository.UserRepository;
import com.cdk.spring.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by khana on 4/2/15.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    SettingService settingService;

    @Autowired
    UserRepository userRepository;


    @RequestMapping(
            value = "/{id}/settings",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public Collection<Setting> getSetting(@PathVariable("id") final int userId){
        return userRepository.findOne((new Long(userId))).getSettings();
    }

    @RequestMapping(
            value = "/{id}/settings",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    @ResponseBody
    public ResponseEntity postSetting(@RequestBody final Map<String, String> settingMap,
                                         @PathVariable("id") final int userId){
        User user = userRepository.findOne(new Long(userId));
        settingService.save(user, settingMap);
        return new ResponseEntity<>("{\"message\" : \" settings created successfully\"}", HttpStatus.CREATED);


    }

}
