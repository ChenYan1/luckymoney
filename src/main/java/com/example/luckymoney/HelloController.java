package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chen
 * @date 2019/4/10 3:27
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final LimitConfig limitConfig;

    @Autowired
    public HelloController(LimitConfig limitConfig) {
        this.limitConfig = limitConfig;
    }

    @GetMapping("/say1")
    public String say(){
		return "说明：" + limitConfig.getDescription();
    }

    @PostMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id:" + myId;
    }
}