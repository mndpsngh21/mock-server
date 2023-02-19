package com.mndpsngh21.mockserver;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mndpsngh21.mockserver.models.Responses.SampleResponse;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
/**
 * These two lines are import for mock methods
 */
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;      
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
@SpringBootTest
public class SpringBasedMockingTest {

	@Autowired
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;
	private ObjectMapper mapper = new ObjectMapper();

	
	@Autowired
	DemoService demoService;
	
	@Value("${externalURL}")
	String externalInfoURL;

	String query = "mandeep";

	@BeforeEach
	public void init() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void testWithSpringMockServer() throws JsonProcessingException, URISyntaxException {
		SampleResponse sampleResponse = new SampleResponse(query);
        mockServer.expect(ExpectedCount.once(), 
                requestTo(new URI(externalInfoURL+query)))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(mapper.writeValueAsString(sampleResponse))
              );    
        SampleResponse responseFromCall= demoService.getAccountWithExternalInformation(query);		

        assertEquals(responseFromCall.getInfo(), sampleResponse.getInfo());
	}

}
