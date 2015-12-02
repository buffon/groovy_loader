package com.harry.spring.service;

import org.springframework.stereotype.Component;

/**
 * @author chenyehui
 */
@Component
public class ShootServiceImpl implements ShootService {
    @Override
    public void hello() {
        System.out.println("hello==>");
    }
}
