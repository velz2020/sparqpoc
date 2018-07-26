package org.sparqpoc.apprespository;

import java.util.List;

import org.sparqpoc.appmodel.AnswerMaster;
import org.sparqpoc.appmodel.LoanApplicantDetails;
import org.sparqpoc.appmodel.LoanMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerMasterRepository extends JpaRepository<AnswerMaster, Long> {
	
	List<AnswerMaster> findByApplicantid(LoanApplicantDetails applicantid);
	List<AnswerMaster> findByLoanid(LoanMaster loanid);
}
