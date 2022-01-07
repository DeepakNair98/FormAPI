package com.dn.formApi.service;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.formApi.model.Form;
import com.dn.formApi.model.Status;
import com.dn.formApi.repository.FormRepository;
import com.dn.formApi.repository.StatusRepository;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@Service(value ="formService")
@Transactional
public class FormServiceImpl implements FormService {

	@Autowired
	private FormRepository formRepository;
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public String setFormStatus(JSONObject json) {
		
		if(!json.equals(null)) {
			Status status = new Status();
			OkHttpClient client = new OkHttpClient();
				
			var url = "http://localhost:8080/FormAPI/insert";
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType,json.toJSONString());
			Request request = new Request.Builder().url(url).post(body).build();
			try {
				Response response = client.newCall(request).execute();
				InputStream inputStream = response.body().byteStream();
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
				String console = bufferReader.readLine();
				status.setEmail(json.get("email").toString());
				status.setStatus(console);
				System.out.println("status value: "+status);
				statusRepository.save(status);
				return "Data saved successfully";
				
			} catch (IOException e) {
				e.printStackTrace();
				return "no response from insert API";
			}
			
		}
	
		return "JSON file is empty";
	}

	@Override
	public String formData(JSONObject json) {
		
		try {
			if(json.isEmpty() || json.equals(null))
				throw new Exception("JSON file is empty");
			Form form = new Form();
			form.setName(json.get("name").toString());
			form.setEmail(json.get("email").toString());
			form.setMobile(json.get("mobile").toString());
			formRepository.save(form);
			System.out.println("form value: "+form);
			return " success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}
}
