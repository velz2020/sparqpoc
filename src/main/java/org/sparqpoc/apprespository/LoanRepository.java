package org.sparqpoc.apprespository;

import org.sparqpoc.appmodel.LoanMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanMaster, Long> {
	
	LoanMaster findById(long loanid);

	
}
