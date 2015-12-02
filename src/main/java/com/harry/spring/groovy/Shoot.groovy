package com.harry.spring.groovy

import com.harry.spring.base.BaseGroovy
import com.harry.spring.service.ShootService
import org.springframework.beans.factory.annotation.Autowired

/**
 *
 * @author chenyehui
 */
class Shoot extends BaseGroovy {
    @Autowired
    private ShootService shootService;

    @Override
    void say() {
        shootService.hello()
        println("==========")
    }
}
