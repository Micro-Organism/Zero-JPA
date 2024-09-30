package com.zero.jpa.controller;

import com.zero.jpa.domain.entity.SystemUserEntity;
import com.zero.jpa.jpa.SystemUserJPA;
import com.zero.jpa.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jpa")
public class JpaController {

    SystemUserJPA systemUserJPA;

    @Autowired
    public JpaController(SystemUserJPA systemUserJPA) {
        this.systemUserJPA = systemUserJPA;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public Map<String, Object> showHelloWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        return map;
    }

    @RequestMapping("info")
    public SystemUserEntity getByUserName(String name) {
        return systemUserJPA.getUserEntityByName(name);
    }

    @RequestMapping("query")
    public SystemUserEntity queryByUserName(String name) {
        return systemUserJPA.findUserEntityByName(name);
    }

    @RequestMapping("find")
    public List<SystemUserEntity> listByUserName(String name) {
        return systemUserJPA.findByName(name);
    }

    @RequestMapping("/list")
    public Iterable<SystemUserEntity> list() {
        Iterable<SystemUserEntity> all = systemUserJPA.findAll();
        return all;
    }

    @RequestMapping("/add")
    public SystemUserEntity add(String name) {
        SystemUserEntity systemUserEntity = new SystemUserEntity();
        systemUserEntity.setUsername(name);
        return systemUserJPA.save(systemUserEntity);
    }
    @RequestMapping("/delete")
    public void delete(String name) {
        systemUserJPA.deleteByName(name);
    }

}