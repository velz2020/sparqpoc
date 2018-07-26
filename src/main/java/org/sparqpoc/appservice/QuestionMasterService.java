package org.sparqpoc.appservice;

import java.util.ArrayList;
import java.util.List;

import org.sparqpoc.appmodel.LoanCatagory;
import org.sparqpoc.appmodel.QuestionMaster;
import org.sparqpoc.apprespository.QuestionMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionMasterService {
	
	@Autowired
	QuestionMasterRepository questionMasterRepository;

	public List<QuestionMaster> saveListOfQuestions(List<QuestionMaster> listofquestions)
	{
		
		List<QuestionMaster> savedInstances = new ArrayList<>();
		
		for(QuestionMaster question:listofquestions)
		{
			savedInstances.add(questionMasterRepository.save(question));
		}
		return savedInstances;
	}

	public List<QuestionMaster> getQuestionByLoanCatagory(LoanCatagory questioncatagory) {
		return questionMasterRepository.findByQuestionloancatagory(questioncatagory);
	}
}
