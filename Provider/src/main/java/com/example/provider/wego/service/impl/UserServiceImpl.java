package com.example.provider.wego.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provider.wego.domain.User;
import com.example.provider.wego.mapper.UserMapper;
import com.example.provider.wego.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author 67099
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-05-12 11:24:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




