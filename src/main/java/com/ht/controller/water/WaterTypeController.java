package com.ht.controller.water;



import com.ht.model.filters.Pagination;
import com.ht.model.WaterType;
import com.ht.service.IWaterTypeService;
import com.ht.util.CommonUtils;
import com.ht.util.Constants;
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
@RequestMapping("water/waterType")
public class WaterTypeController {

	@Autowired(required = true)
	private IWaterTypeService waterTypeService;


	@RequestMapping("/getWaterTypeList")
	@ResponseBody
	public ModelAndView getWaterTypeList(HttpServletRequest request,WaterType waterType,Pagination page) throws Exception {

		ModelAndView mv=new ModelAndView("/water/typelist");
		page= CommonUtils.constructParams(waterType,page);
		Pagination waterTypelist = waterTypeService.getWaterTypeList(page);

		mv.addObject("page",waterTypelist);

		return mv;
	}
	@RequestMapping("/saveWaterType")
	@ResponseBody
	public Map<String,Object> saveWaterType(WaterType waterType) {
		Map<String,Object> map=new HashMap<>();
		try{
			waterTypeService.saveWaterType(waterType);
			map.put("message","success");
		}catch (Exception e){
			e.printStackTrace();
			map.put("message","failure");
		}
		return  map;
	}

	@RequestMapping("/delteWaterType")
	@ResponseBody
	public Map<String,Object> delteWaterType(String ids) {
		Map<String,Object> map=new HashMap<>();
		try{
			waterTypeService.delteWaterType(ids);
			map.put("message","success");
		}catch (Exception e){
			e.printStackTrace();
			map.put("message","failure");
		}
		return  map;
	}

	@RequestMapping("/getWaterType")
	@ResponseBody
	public Map<String,Object> getWaterType(String id) {
		Map<String,Object> map=new HashMap<>();
		WaterType waterType=waterTypeService.getWaterType(id);
		map.put("waterType",waterType);
		return  map;
	}
	@RequestMapping("/updateWaterType")
	@ResponseBody
	public Map<String,Object> updateWaterType(WaterType waterType) {
		Map<String,Object> map=new HashMap<>();
		try{
			waterTypeService.updateWaterType(waterType);
			map.put("message","success");
		}catch (Exception e){
			e.printStackTrace();
			map.put("message","failure");
		}
		return  map;
	}


}
