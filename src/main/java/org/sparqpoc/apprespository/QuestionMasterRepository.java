package org.sparqpoc.apprespository;

import java.util.List;

import org.sparqpoc.appmodel.LoanCatagory;
import org.sparqpoc.appmodel.QuestionMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionMasterRepository extends JpaRepository<QuestionMaster, Long> {
	
	List<QuestionMaster> findByQuestionloancatagory(LoanCatagory id); 

}
