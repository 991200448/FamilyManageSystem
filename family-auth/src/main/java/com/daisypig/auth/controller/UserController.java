package com.daisypig.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daisypig.auth.service.UserService;
import com.daisypig.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    // 新增用户
    @PostMapping("/users")
    public boolean addUser(@RequestBody User user) {
        return userService.save(user);
    }

    // 根据 ID 删除用户（逻辑删除）
    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.removeById(id);
    }

    // 根据 ID 更新用户信息
    @PutMapping("/users/{id}")
    public boolean updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateById(user);
    }

    // 根据 ID 查询用户
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    // 分页查询用户列表
    @GetMapping("/users")
    public IPage<User> getUserList(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) Integer age) {
        Page<User> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (name != null) {
            wrapper.like(User::getName, name);
        }
        if (age != null) {
            wrapper.eq(User::getAge, age);
        }
        return userService.page(page, wrapper);
    }
}
