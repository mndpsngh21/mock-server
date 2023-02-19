package com.mndpsngh21.mockserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mndpsngh21.mockserver.interfaces.ExternalServiceCalls;
import com.mndpsngh21.mockserver.models.Responses.SampleResponse;

@Service
public class DemoService implements ExternalServiceCalls{

	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${externalURL}")
	String externalInfoURL;
	
	@Override
	public SampleResponse getAccountWithExternalInformation(String refId) {
		String urlWithLink = externalInfoURL+refId;
	    ResponseEntity<SampleResponse> response=  restTemplate.getForEntity(urlWithLink, SampleResponse.class);
	    return response.getBody();
	}
	
	
	
}
