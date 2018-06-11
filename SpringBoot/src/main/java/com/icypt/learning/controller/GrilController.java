package com.icypt.learning.controller;

import com.icypt.learning.aspect.LogAspect;
import com.icypt.learning.entity.Gril;
import com.icypt.learning.service.GrilService;
import com.icypt.learning.utils.ResultVoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/17 20:48
 * version：1.0
 * description：
 */
@RestController
public class GrilController {

    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private GrilService grilService;

    /**
     * 查询所有的女孩
     * @return
     */
    @GetMapping("/findAllGrils")
    public Object findAllGrils() {
        return ResultVoUtil.success(grilService.findAllGrils());
    }

    /**
     * 根据id查询女孩
     * @param id
     * @return
     */
    @PostMapping("/findGrilById/{id}")
    public Object findGrilById(@PathVariable("id")Integer id) {
        return ResultVoUtil.success(grilService.findGrilById(id));
    }

    /**
     * 保存女孩
     * @param gril
     */
    @GetMapping("/insertGril")
    public Object insertGril(@Valid Gril gril, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            LOGGER.info("message={}", bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return ResultVoUtil.success(grilService.insertGril(gril));
    }

    /**
     * 更新女孩
     * @param name
     * @param age
     * @param cupSize
     * @return
     */
    @PostMapping("/updateGril/{id}")
    public Object updateGril(@RequestParam("name") String name,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize,
                           @PathVariable("id") Integer id) {
        Gril gril = new Gril();
        gril.setId(id);
        gril.setName(name);
        gril.setAge(age);
        gril.setCupSize(cupSize);
        return ResultVoUtil.success(grilService.updateGril(gril));
    }

    /**
     * 删除女孩
     * @param id
     */
    @GetMapping("/deleteGrilById/{id}")
    public Object deleteGrilById(@PathVariable("id")Integer id) {
        grilService.deleteGrilById(id);
        return ResultVoUtil.success();
    }


    /**
     * spring boot 事务提交
     */
    @PostMapping("/insertGrilTwo")
    public Object insertGrilTwo() {
        grilService.insertGrilTwo();
        return ResultVoUtil.success();
    }
    @GetMapping("/getAge/{id}")
    public Object getAge(@PathVariable("id") Integer id){
        return grilService.getAge(id);
    }

}
