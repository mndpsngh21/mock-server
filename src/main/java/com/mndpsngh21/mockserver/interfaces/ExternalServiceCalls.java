package com.mndpsngh21.mockserver.interfaces;

import com.mndpsngh21.mockserver.models.Responses.SampleResponse;

public interface ExternalServiceCalls {


	SampleResponse getAccountWithExternalInformation(String refId);
	

}
