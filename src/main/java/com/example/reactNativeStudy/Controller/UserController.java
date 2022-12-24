package com.example.reactNativeStudy.Controller;

import com.example.reactNativeStudy.Dao.UserDao;
import com.example.reactNativeStudy.Entity.User;
import com.example.reactNativeStudy.Util;
import com.example.reactNativeStudy.Vo.BaseUserVo;
import com.example.reactNativeStudy.Vo.UserResponseDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user",produces = "application/json; charset=utf-8")
public class UserController {
    @Autowired
    private UserDao userDao;
    public String getResponseJson (Object data,String message,Boolean success) {
        BaseResponse response = new BaseResponse(message,data,success);
        return new Gson().toJson(response);
    }
    @PostMapping("/test")
    public void test() {
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }
    @PostMapping("/login")
    public ResponseEntity login (@RequestBody BaseUserVo body) {
        User expUser = new User();
        expUser.setPwd(body.getPwd());
        expUser.setAccount(body.getAccount());
        Example exp = Example.of(expUser);
        Optional<User> testUser = userDao.findOne(exp);
        if (testUser.equals(Optional.empty())) {
            return  ResponseEntity.status(200).body(getResponseJson("","用户名或密码不正确",false));
        }
        UserResponseDto dto = new UserResponseDto();
        dto = Util.setDtoValFromEntity(testUser.get(),dto);
        return  ResponseEntity.status(200).body(getResponseJson(dto,"",true));
    }
    @PostMapping("/checkAccount")
    public ResponseEntity checkAccount(@RequestBody BaseUserVo body) {
        Example exp = Example.of(new User(body.getAccount()));
        Optional<User> testUser = userDao.findOne(exp);
        if (!testUser.equals(Optional.empty())) {
            return  ResponseEntity.status(200).body(getResponseJson("","用户名已被占用",false));
        }
        UserResponseDto dto = new UserResponseDto();
        dto = Util.setDtoValFromEntity(testUser,dto);
        return  ResponseEntity.status(200).body(getResponseJson(dto,"",true));
    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody BaseUserVo body) {
        User user = new User("yangqs","19941120");
        userDao.save(user);
        return  ResponseEntity.status(200).body(getResponseJson("","",true));
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody BaseUserVo body) {
        User user = new User("yangqs","19941120");
        userDao.save(user);
        return  ResponseEntity.status(200).body(getResponseJson("","",true));
    }

}
