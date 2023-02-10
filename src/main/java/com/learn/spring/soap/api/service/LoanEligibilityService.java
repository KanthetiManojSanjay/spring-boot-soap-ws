package com.learn.spring.soap.api.service;

import com.learn.spring.soap.api.loaneligibility.Acknowledgement;
import com.learn.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kansanja on 10/02/23.
 */
@Service
public class LoanEligibilityService {

    public Acknowledgement checkCustomerEligibility(CustomerRequest customerRequest) {
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
        if (!(customerRequest.getAge() > 30 && customerRequest.getAge() <= 60)) {
            mismatchCriteriaList.add("Person age should be between 30 to 60");
        }
        if (!(customerRequest.getYearlyIncome() > 200000)) {
            mismatchCriteriaList.add("Minimum income should be greater than 200000");
        }
        if (!(customerRequest.getCibilScore() > 500)) {
            mismatchCriteriaList.add("Low CIBIL score Please try after 6 months");
        }

        if (mismatchCriteriaList.size() > 0) {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            acknowledgement.setIsEligible(true);
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.getCriteriaMismatch().clear();
        }

        return acknowledgement;
    }
}
