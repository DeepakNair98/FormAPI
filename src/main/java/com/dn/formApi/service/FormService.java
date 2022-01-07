package com.dn.formApi.service;



import org.json.simple.JSONObject;

public interface FormService {
	
	public String formData(JSONObject json);
	public String setFormStatus(JSONObject json);

}
