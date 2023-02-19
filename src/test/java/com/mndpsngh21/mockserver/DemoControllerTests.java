package com.mndpsngh21.mockserver;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mndpsngh21.mockserver.models.Responses.SampleResponse;

import junit.framework.Assert;


@ExtendWith(MockitoExtension.class)
public class DemoControllerTests {
	
	
	
	@Autowired
	public DemoService demoService;
	
	
	String query="mandeep";
	
	@Mock
	RestTemplate restTemplate;
	
	
	@Value("${externalURL}")
	String externalInfoURL;
	
	
	@InjectMocks
	private DemoService mockedService;
	
	
	@Test
	public void testExternalCallsWithMockito() {
		
		SampleResponse sampleResponse= new SampleResponse(query);
		 Mockito
         .when(restTemplate.getForEntity(externalInfoURL+query, SampleResponse.class))
         .thenReturn(new ResponseEntity(sampleResponse, HttpStatus.OK));
         SampleResponse responseFromCall= mockedService.getAccountWithExternalInformation(query);	
         
         assertEquals(responseFromCall.getInfo(), sampleResponse.getInfo());
	}


}
