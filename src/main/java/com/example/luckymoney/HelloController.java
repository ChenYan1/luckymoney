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

    /**
     * 通过对注解传入数组来设置多路径访问
     * @return
     */
    @GetMapping({"/say0","/say1"})
    public String say(){
        return "说明：" + limitConfig.getDescription();
    }

    @GetMapping("/say3")
    public String say1(){
		return "说明：" + limitConfig.getDescription();
    }

    /**
     * 获取参数
     * 形式：localhost:8080/luckymoney/hello/say4/100
     * @param id
     * @return
     */
    @GetMapping("/say4/{id}")
    public String say2(@PathVariable("id") Integer id){
        return "id:" + id;
    }

    /**
     * 获取参数
     * 形式：localhost:8080/luckymoney/hello/say5?id=100
     * 若id在地址中非必传参数，value 指定值，required 是否必传，defaultValue 默认值
     *  @RequestParam(value = "id", required = false, defaultValue = "0")
     * @param id
     * @return
     */
    @GetMapping("/say5")
    public String say3(@RequestParam("id") Integer id){
        return "id:" + id;
    }

    @PostMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id:" + myId;
    }
}