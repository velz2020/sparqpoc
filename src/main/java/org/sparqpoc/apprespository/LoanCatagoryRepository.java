package org.sparqpoc.apprespository;

import org.sparqpoc.appmodel.LoanCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanCatagoryRepository extends JpaRepository<LoanCatagory, Long> {

}
