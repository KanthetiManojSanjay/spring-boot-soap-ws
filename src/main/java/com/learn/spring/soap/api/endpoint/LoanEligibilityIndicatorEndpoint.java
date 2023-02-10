package com.learn.spring.soap.api.endpoint;

import com.learn.spring.soap.api.loaneligibility.Acknowledgement;
import com.learn.spring.soap.api.loaneligibility.CustomerRequest;
import com.learn.spring.soap.api.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author kansanja on 10/02/23.
 */
@Endpoint
public class LoanEligibilityIndicatorEndpoint {
    private static final String NAMESPACE = "http://www.learn.com/spring/soap/api/loanEligibility";

    @Autowired
    private LoanEligibilityService loanEligibilityService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest customerRequest) {
        return loanEligibilityService.checkCustomerEligibility(customerRequest);

    }
}
