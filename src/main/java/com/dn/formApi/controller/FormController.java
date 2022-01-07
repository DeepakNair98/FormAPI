package com.dn.formApi.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dn.formApi.service.FormService;

@CrossOrigin
@RestController
@RequestMapping("FormAPI")
public class FormController {
	
	@Autowired
	private FormService formService;
	
	@PostMapping("/insert")
	public String formData(@RequestBody JSONObject json) {
		
		return formService.formData(json);
	}
	
	@PostMapping("/saveData")
	public String saveData(@RequestBody JSONObject json) {
		
		return formService.setFormStatus(json);
	}

}
