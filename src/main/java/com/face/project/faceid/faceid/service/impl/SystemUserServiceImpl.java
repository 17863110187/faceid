package com.face.project.faceid.faceid.service.impl;

import com.face.project.faceid.faceid.dao.SystemUserDao;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserDao systemUserDao;

    @Override
    public int loginCheck(Long id, String psw) {
        SystemUser user = systemUserDao.selectUserById(id);
        if(user==null){
            return -1;
        }
        if(user.getPassword().equals(psw)){
            return 1;
        }else {
            return 0;
        }
    }
}
