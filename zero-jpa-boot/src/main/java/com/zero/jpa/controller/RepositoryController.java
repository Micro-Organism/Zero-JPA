package com.zero.jpa.controller;

import com.zero.jpa.domain.entity.SystemUserEntity;
import com.zero.jpa.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/repository")
public class RepositoryController {

    SystemUserRepository systemUserRepository;

    @Autowired
    public RepositoryController(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> showHelloWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        return map;
    }

    @RequestMapping("/list")
    public Iterable<SystemUserEntity> list() {
        Iterable<SystemUserEntity> all = systemUserRepository.findAll();
        return all;
    }

    @RequestMapping("/add")
    public SystemUserEntity add(String name) {
        SystemUserEntity systemUserEntity = new SystemUserEntity();
        systemUserEntity.setUsername(name);
        return systemUserRepository.save(systemUserEntity);
    }

}