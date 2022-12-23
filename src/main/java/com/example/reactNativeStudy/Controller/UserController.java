package com.example.reactNativeStudy.Controller;

import com.example.reactNativeStudy.Dao.UserDao;
import com.example.reactNativeStudy.Entity.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

class BaseUserVo {
    public String account;
    public String pwd;

    public BaseUserVo() {
    }

    public BaseUserVo(String name, String pwd) {
        this.account = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "CreateUserVo{" +
                "name='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}


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
//        expUser.setPwd(body.pwd);
        expUser.setAccount(body.account);
        Example exp = Example.of(expUser);
        Optional<User> testUser = userDao.findOne(exp);
        if (testUser.equals(Optional.empty())) {
            return  ResponseEntity.status(200).body(getResponseJson("","用户名或密码不正确",false));
        }
        return  ResponseEntity.status(200).body(getResponseJson(testUser,"",true));
    }
    @PostMapping("/checkAccount")
    public ResponseEntity checkAccount(@RequestBody BaseUserVo body) {
        Example exp = Example.of(new User(body.account));
        Optional<User> testUser = userDao.findOne(exp);
        if (!testUser.equals(Optional.empty())) {
            return  ResponseEntity.status(200).body(getResponseJson("","用户名已被占用",false));
        }
        return  ResponseEntity.status(200).body(getResponseJson("","",true));
    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody BaseUserVo body) {
        User user = new User("yangqs","19941120");
        userDao.save(user);
        return  ResponseEntity.status(200).body(getResponseJson("","",true));
    }
}
