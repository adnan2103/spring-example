package com.cdk.spring;

import com.cdk.spring.config.DataSourceConfig;
import com.cdk.spring.entity.Setting;
import com.cdk.spring.entity.User;
import com.cdk.spring.repository.SettingRepository;
import com.cdk.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
@Import(DataSourceConfig.class)
public class SpringSessionApplication implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;



    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }

    public void run(String... args) {

        User user = null;
        user = new User("Zaman");
        Setting setting = null;
        Collection<Setting> settings = new ArrayList<Setting>();
        setting = new Setting("Show Log","Yes");
        settings.add(setting);

        setting = new Setting("Show Notice","Yes");
        settings.add(setting);

        user.setSettings(settings);
        userRepository.save(user);



    }
}
