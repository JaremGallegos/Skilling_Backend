package com.cibertec.skilling.backend.controller.helper;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cibertec.skilling.backend.utils.AppConfig;

@Component
public class PasswordEncoderMapper {

    @Autowired
    private final AppConfig appConfig;

    public PasswordEncoderMapper(AppConfig appConfig){
        this.appConfig = appConfig;
    } 

    @Named("encodePassword")
    public String encodePassword(String password) {
        return appConfig.passwordEncoder().encode(password);
    }
}
