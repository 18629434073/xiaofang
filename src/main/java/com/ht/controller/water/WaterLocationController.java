//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ht.controller.water;

import com.ht.model.User;
import com.ht.model.Water;
import com.ht.model.filters.Pagination;
import com.ht.service.IUserService;
import com.ht.service.WaterLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/waterLocation"})
public class WaterLocationController {
    @Autowired(required = true)
    private WaterLocationService waterLocationService;

    @RequestMapping({"/getWaterList"})
    @ResponseBody
    public ModelAndView getWaterList(HttpServletRequest request, Water water, Pagination page) {
        ModelAndView mav = new ModelAndView("water/list");

        try {
            List<Water> waterList=waterLocationService.getWaterList(water,page);
            mav.addObject("waterList", waterList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping({"/filter"})
    @ResponseBody
    public ModelAndView filter(HttpServletRequest request, Water water) {
         return getWaterList(request,water,new Pagination());
    }

    @RequestMapping({"/save"})
    @ResponseBody
    public Map<String, Object> saveWaterlocation(Water water) {
        HashMap map = new HashMap();

        try {
            waterLocationService.saveWaterlocation(water);
            map.put("message","success");
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }

        return map;
    }



    @RequestMapping({"/getWater"})
    @ResponseBody
    public Map<String, Object> getWater(String id) {
        HashMap map = new HashMap();
        try {
           Water water=waterLocationService.getWater(id);
            map.put("water","water");
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }

        return map;
    }

    @RequestMapping({"/edit"})
    @ResponseBody
    public Map<String, Object> edit(Water water) {
        HashMap map = new HashMap();

        try {
            waterLocationService.updateWaterlocation(water);
            map.put("message","success");
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }

        return map;
    }

    @RequestMapping({"/delete"})
    @ResponseBody
    public Map<String, Object> delete(String  ids) {
        HashMap map = new HashMap();

        try {
            waterLocationService.deleteWaterlocation(ids);
            map.put("message","success");
        } catch (Exception e) {
            map.put("error", e.getMessage());
        }

        return map;
    }
}
