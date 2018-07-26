package org.sparqpoc.apprespository;

import java.util.List;

import org.sparqpoc.appmodel.LoanApplicantDetails;
import org.sparqpoc.appmodel.LoanMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicantDetailsRepository extends JpaRepository<LoanApplicantDetails, Long> {

	
		 LoanApplicantDetails findByFirstname(String firstname);

		List<LoanApplicantDetails> findByLoanid(LoanMaster loanid);
		LoanApplicantDetails findByLoanapplicantid(long applicantid);
	

}
