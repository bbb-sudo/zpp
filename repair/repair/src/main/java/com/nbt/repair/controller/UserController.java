package com.nbt.repair.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbt.repair.exception.BussinessException;
import com.nbt.repair.response.R;
import com.nbt.repair.entity.User;
import com.nbt.repair.response.ResponseCode;
import com.nbt.repair.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "用户信息管理")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Resource
    private UserService userService;

    @Operation(summary = "新增用户")
    @PostMapping("/user/add")
    @CrossOrigin
    public R add(@RequestBody User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        long count = userService.count(wrapper);
        if (count > 0) {
            throw new BussinessException(ResponseCode.USERNAME_EXISTS);
        }
        userService.save(user);
        return R.success();
    }

    @Operation(summary = "用户信息列表（带条件分页查询）")
    @PostMapping("/user/list")
    @CrossOrigin
    public R<PageInfo<User>> list(
            @RequestBody User user,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        // 1. 构建查询条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(user.getUsername() != null, User::getUsername, user.getUsername());
        wrapper.like(user.getRealName() != null, User::getRealName, user.getRealName());
        wrapper.eq(user.getRole() != null, User::getRole, user.getRole());

        // 2. 开启分页
        PageHelper.startPage(pageNum, pageSize);

        // 3. 执行查询
        List<User> list = userService.list(wrapper);

        // 4. 包装分页结果
        PageInfo<User> pageInfo = new PageInfo<>(list);

        // 5. 返回结果
        return R.data(pageInfo);
    }

    @Operation(summary = "修改用户信息")
    @PostMapping("/user/update")
    @CrossOrigin
    public R update(@RequestBody User user) {
        userService.updateById(user);
        return R.success();
    }

    @Operation(summary = "删除用户")
    @PostMapping("/user/delete")
    @CrossOrigin
    public R del(@RequestParam Long id) {
        userService.removeById(id);
        return R.success();
    }
}