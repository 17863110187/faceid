package com.face.project.faceid.faceid.controller;

import com.face.project.faceid.faceid.common.ResponceMap;
import com.face.project.faceid.faceid.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping(value = "login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(required = true)Long id, @RequestParam(required = true)String psw){
        if (id==null){
            return ResponceMap.responceError("账号不能为空");
        }
        if (psw==null||"".equals(psw.trim())){
            return  ResponceMap.responceError("密码不能为空");
        }
        switch (systemUserService.loginCheck(id, psw)){
            case -1:
                return  ResponceMap.responceError("该账号不存在");
            case 0:
                return  ResponceMap.responceError("密码错误");
            case 1:
                return  ResponceMap.responceSuccess("登陆成功");
        }
        return ResponceMap.responceSuccess("登陆成功");
    }
}
