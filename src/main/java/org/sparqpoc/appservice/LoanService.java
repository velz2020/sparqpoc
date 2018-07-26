package org.sparqpoc.appservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.sparqpoc.appmodel.LoanApplicantDetails;
import org.sparqpoc.appmodel.LoanMaster;
import org.sparqpoc.apprespository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoanService {
	
	@Autowired
	LoanRepository loanRepository;
	@Autowired
	LoanApplicantDetailsService loanapplicantDetailsService;
	
	private  LoanMaster currentLoan;
	private long currentId;
	
	
	
	
	public List<LoanMaster> saveNewLoanDetails1(List<LoanMaster> loans)
	{
		
		List<LoanMaster> savedInstances =  new ArrayList<>(); 
		List<LoanApplicantDetails> savedChildInstances = new ArrayList<>(); 
		LoanApplicantDetails applicantDetails;
		
		for(LoanMaster loan:loans)
		{
			System.out.println("***LOAN 1 MASTER FOR LOOP CALLED*******");
			currentLoan = loanRepository.save(loan);
			//currentId = currentLoan.getId();
			System .out.println("***LOAN MASTER ID-"+currentLoan.getId());
			List<LoanApplicantDetails> loanapplicantDetailsToSave = new ArrayList<>();
			loanapplicantDetailsToSave = loan.getListOfApplicants();
			System .out.println("***No of Child -"+ loanapplicantDetailsToSave.size());
			for(LoanApplicantDetails loanapplicantDetails:loanapplicantDetailsToSave)
			{
				System .out.println("***LOAN MASTER ID INSIDE FOR LOOP -"+currentLoan.getId());
				System .out.println("***LOAN CHILD FOR LOOP CALLED*******");
				loanapplicantDetails.setLoanid(currentLoan);
				applicantDetails = loanapplicantDetailsService.saveNewLoanApplicants(loanapplicantDetails);
				System.out.println("***LOAN APPLICANT ID-"+applicantDetails.getLoanapplicantid());
				savedChildInstances.add(applicantDetails);
				
			}
			
			//currentLoan.
			currentLoan.setListOfApplicants(savedChildInstances);
			savedInstances.add(currentLoan);
			//currentLoan = null;
		}
		
		return savedInstances;
		
	}
	
	
	public List<LoanMaster> saveNewLoanDetails2(List<LoanMaster> loans)
	{
		
		List<LoanMaster> savedInstances =  new ArrayList<>(); 
		List<LoanApplicantDetails> savedChildInstances = new ArrayList<>(); 
		LoanApplicantDetails applicantDetails;
		
		for(LoanMaster loan:loans)
		{
			System.out.println("***LOAN MASTER FOR LOOP CALLED*******");
			currentLoan = loanRepository.save(loan);
			currentId = currentLoan.getId();
			System .out.println("***LOAN MASTER ID-"+currentLoan.getId());
			List<LoanApplicantDetails> loanapplicantDetailsToSave = new ArrayList<>();
			loanapplicantDetailsToSave = currentLoan.getListOfApplicants();
			for(LoanApplicantDetails loanapplicantDetails:loanapplicantDetailsToSave)
			{
				System .out.println("***LOAN CHILD FOR LOOP CALLED*******");
				//loanapplicantDetails.setFkloanid((int) currentId);
				applicantDetails = loanapplicantDetailsService.saveNewLoanApplicants(loanapplicantDetails);
				System.out.println("***LOAN APPLICANT ID-"+applicantDetails.getLoanapplicantid());
				savedChildInstances.add(applicantDetails);
				
			}
			
			//currentLoan.
			currentLoan.setListOfApplicants(savedChildInstances);
			savedInstances.add(currentLoan);
			//currentLoan = null;
		}
		
		return savedInstances;
		
	}
	
	public List<LoanMaster> retriveAllLoans()
	{
		try
		{
		return loanRepository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}


	public LoanMaster retriveAllLoanByLoanId(long loanid) {
		
		return loanRepository.findById(loanid);
	}
	
	
	
	

}
