//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ht.controller.system;

import com.ht.model.User;
import com.ht.service.IUserService;
import com.ht.util.AesEncrypter;
import com.ht.util.DateUtil;
import com.ht.util.MD5;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/system/user"})
public class UserController {
    @Autowired(required = true)
    private IUserService userService;

    @RequestMapping({"/get"})
    @ResponseBody
    public Map<String, Object> getUser(String userId) {
        HashMap map = new HashMap();

        try {
            User user=userService.getUser(userId);
            map.put("user",user);
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }

        return map;
    }

    @RequestMapping({"/save"})
    @ResponseBody
    public Map<String, Object> saveUser(User user) {
        HashMap map = new HashMap();

        try {
            userService.saveUser(user);
            map.put("message","success");
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }

        return map;
    }

}
