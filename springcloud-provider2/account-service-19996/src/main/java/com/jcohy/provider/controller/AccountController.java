package com.jcohy.provider.controller;

import com.jcohy.provider.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2017/12/25
 */
@RestController
@RefreshScope
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Value("${user.name}")
    private String name;

    @RequestMapping("/debit")
    public Boolean debit(String userId, BigDecimal money) {
        accountService.debit(userId, money);
        System.out.println("get user from nacos config :"+name);
        return true;
    }
}
