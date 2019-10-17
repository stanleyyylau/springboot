package com.imooc.springboot.transaction.service;

import com.imooc.springboot.transaction.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void batchInsert() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("xiaoming"+i);
            user.setEmail("sfsdf"+i);
            userService.insert(user);
        }
        log.info("run methon a");
    }
}