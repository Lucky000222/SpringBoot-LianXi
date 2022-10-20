package com.security.account.accountImpl;

import com.security.account.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class accountImpl implements Account {
    @Override
    public HashMap<String, String> Account() {
        HashMap<String, String> userOrPassword = new HashMap<>();
        userOrPassword.put("18042170242", "123456789");
        userOrPassword.put("17698234973", "17698234973");
        userOrPassword.put("18757467913", "mg2390757066");
        userOrPassword.put("17538212825", "111111xy");
        userOrPassword.put("15806629717", "123456789");
        userOrPassword.put("15014555099", "12345678");
        userOrPassword.put("18270516436", "xiong20000229");
        userOrPassword.put("13192390218", "13192390218");
        return userOrPassword;
    }
}
