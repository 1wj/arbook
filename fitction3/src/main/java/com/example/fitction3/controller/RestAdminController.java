package com.example.fitction3.controller;

import com.example.fitction3.domain.Admin;
import com.example.fitction3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/login")
public class RestAdminController {

    @Autowired()
    AdminService adminService;

    @GetMapping("/{id}")
    public Admin queryById(@PathVariable String id){
        System.out.println("正在根据id查单条");
        Admin admin = adminService.selectById(id);
        return admin;
    }

    @PostMapping
    public int addBook(Admin admin){
        System.out.println("正在插入");
        return adminService.save(admin);

    }
    @PutMapping
    public int update(Admin admin){
        System.out.println("正在修改");
        return adminService.updateById(admin);
    }


    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id){
        System.out.println("正在删除");
        return adminService.deleteById(id);
    }
}
