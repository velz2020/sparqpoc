package org.sparqpoc.appservice;

import java.util.ArrayList;
import java.util.List;

import org.sparqpoc.appmodel.AnswerMaster;
import org.sparqpoc.appmodel.Document;
import org.sparqpoc.appmodel.LoanApplicantDetails;
import org.sparqpoc.appmodel.LoanMaster;
import org.sparqpoc.appmodel.QuestionMaster;
import org.sparqpoc.apprespository.AnswerMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerMasterService {
	
	@Autowired
	AnswerMasterRepository answerMasterRepository;
	public List<AnswerMaster> saveListOfAnswers(List<AnswerMaster> listofanswers)
	{
		
		List<AnswerMaster> savedInstances = new ArrayList<>();
		for(AnswerMaster answer:listofanswers)
		{
			savedInstances.add(answerMasterRepository.save(answer));
		}
		return savedInstances;
	}
	
	public List<AnswerMaster> getAnswersByApplicantId(LoanApplicantDetails applicantid) {
		System.out.println("PASSED LOANID IN SERVICE :-"+applicantid.getLoanapplicantid());
		return answerMasterRepository.findByApplicantid(applicantid);
		
	}
	
	public List<AnswerMaster> getAnswersByLoanId(LoanMaster loanid) {
		return answerMasterRepository.findByLoanid(loanid);
		
	}

	

}
