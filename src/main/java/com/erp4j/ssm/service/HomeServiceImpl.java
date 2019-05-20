package com.erp4j.ssm.service;

import com.erp4j.ssm.mapper.SysUserMapper;
import com.erp4j.ssm.pojo.SysUser;
import com.erp4j.ssm.pojo.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public boolean ajaxLogin(SysUser sysUser) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(sysUser.getUsername());
        criteria.andPasswordEqualTo(sysUser.getPassword());

        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        if(sysUsers.size() != 0){
            return true;
        }else {
            return false;
        }
    }
}
