package com.ht.controller.device;


import com.ht.model.DeviceType;
import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;
import com.ht.service.IDeviceTypeService;
import com.ht.service.IWaterTypeService;
import com.ht.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("device/deviceType")
public class DeviceTypeController {

    @Autowired(required = true)
    private IDeviceTypeService deviceTypeService;


    @RequestMapping("/getDeviceTypeList")
    @ResponseBody
    public ModelAndView getDeviceTypeList(HttpServletRequest request,DeviceType deviceType,Pagination page) throws Exception {

        ModelAndView mv=new ModelAndView("/device/typelist");
        page= CommonUtils.constructParams(deviceType,page);
        Pagination deviceTypelist = deviceTypeService.getDeviceTypeList(page);

        mv.addObject("page",deviceTypelist);

        return mv;
    }
    @RequestMapping("/saveDeviceType")
    @ResponseBody
    public Map<String,Object> saveDeviceType(DeviceType deviceType) {
        Map<String,Object> map=new HashMap<>();
        try{
            deviceTypeService.saveDeviceType(deviceType);
            map.put("message","success");
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","failure");
        }
        return  map;
    }

    @RequestMapping("/delteDeviceType")
    @ResponseBody
    public Map<String,Object> delteDeviceType(String ids) {
        Map<String,Object> map=new HashMap<>();
        try{
            deviceTypeService.delteDeviceType(ids);
            map.put("message","success");
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","failure");
        }
        return  map;
    }

    @RequestMapping("/getDeviceType")
    @ResponseBody
    public Map<String,Object> getDeviceType(String id) {
        Map<String,Object> map=new HashMap<>();
        DeviceType deviceType=deviceTypeService.getDeviceType(id);
        map.put("deviceType",deviceType);
        return  map;
    }
    @RequestMapping("/updateDeviceType")
    @ResponseBody
    public Map<String,Object> updateDeviceType(DeviceType deviceType) {
        Map<String,Object> map=new HashMap<>();
        try{
            deviceTypeService.updateDeviceType(deviceType);
            map.put("message","success");
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","failure");
        }
        return  map;
    }


}

