package com.ht.controller.vehicle;


import com.ht.model.VehicleType;
import com.ht.model.WaterType;
import com.ht.model.filters.Pagination;
import com.ht.service.IVehicleTypeService;
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
@RequestMapping("vehicle/vehicleType")
public class VehicleTypeController {

	@Autowired(required = true)
	private IVehicleTypeService vehicleTypeService;


	@RequestMapping("/getVehicleTypeList")
	@ResponseBody
	public ModelAndView getVehicleTypeList(HttpServletRequest request,VehicleType vehicleType,Pagination page) throws Exception {

		ModelAndView mv=new ModelAndView("/vehicle/typelist");
		page= CommonUtils.constructParams(vehicleType,page);
		Pagination vehicleTypelist = vehicleTypeService.getVehicleTypeList(page);

		mv.addObject("page",vehicleTypelist);

		return mv;
	}
	@RequestMapping("/saveVehicleType")
	@ResponseBody
	public Map<String,Object> saveVehicleType(VehicleType vehicleType) {
		Map<String,Object> map=new HashMap<>();
		try{
			vehicleTypeService.saveVehicleType(vehicleType);
			map.put("message","success");
		}catch (Exception e){
			e.printStackTrace();
			map.put("message","failure");
		}
		return  map;
	}

	@RequestMapping("/delteVehicleType")
	@ResponseBody
	public Map<String,Object> delteVehicleType(String ids) {
		Map<String,Object> map=new HashMap<>();
		try{
			vehicleTypeService.delteVehicleType(ids);
			map.put("message","success");
		}catch (Exception e){
			e.printStackTrace();
			map.put("message","failure");
		}
		return  map;
	}

	@RequestMapping("/getVehicleType")
	@ResponseBody
	public Map<String,Object> getVehicleType(String id) {
		Map<String,Object> map=new HashMap<>();
		VehicleType vehicleType=vehicleTypeService.getVehicleType(id);
		map.put("waterType",vehicleType);
		return  map;
	}
	@RequestMapping("/updateVehicleType")
	@ResponseBody
	public Map<String,Object> updateVehicleType(VehicleType vehicleType) {
		Map<String,Object> map=new HashMap<>();
		try{
			vehicleTypeService.updateVehicleType(vehicleType);
			map.put("message","success");
		}catch (Exception e){
			e.printStackTrace();
			map.put("message","failure");
		}
		return  map;
	}


}
