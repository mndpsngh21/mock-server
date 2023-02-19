package com.mndpsngh21.mockserver;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mndpsngh21.mockserver.models.Responses.SampleResponse;

@RestController
public class DemoController {

	
	@Autowired
	DemoService demoService;
	
	@GetMapping(path = "/getUserInfo/{id}")
	public SampleResponse getUserInfoFromExternalServer(@PathParam("id")String id) {
		return demoService.getAccountWithExternalInformation(id);		
	}
	
}
