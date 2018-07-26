package org.sparqpoc.appservice;

import java.util.List;

import org.sparqpoc.appmodel.LoanApplicantDetails;
import org.sparqpoc.appmodel.LoanMaster;
import org.sparqpoc.apprespository.LoanApplicantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicantDetailsService {

	@Autowired
	LoanApplicantDetailsRepository applicantDetailsRepository;
	
	public LoanApplicantDetails getApplicantDetailsByFirstname(String firstname) {
		
		return applicantDetailsRepository.findByFirstname(firstname);
		
	}
	
	
	public LoanApplicantDetails saveNewLoanApplicants(LoanApplicantDetails applicantDetails)
	{
		return applicantDetailsRepository.save(applicantDetails);
	
	}
	
	public List<LoanApplicantDetails> retriveAllApplicantDetails(LoanMaster loanid)
	{
		return applicantDetailsRepository.findByLoanid(loanid);
	}
	
	public List<LoanApplicantDetails> retriveAllApplicantDetails()
	{
		return applicantDetailsRepository.findAll();
	}


	public LoanApplicantDetails getApplicantDetilsByApplicantId(long applicantid) {
		
		return applicantDetailsRepository.findByLoanapplicantid(applicantid);
	}

}
