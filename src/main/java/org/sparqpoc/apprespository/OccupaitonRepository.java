package org.sparqpoc.apprespository;

import org.sparqpoc.appmodel.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupaitonRepository extends JpaRepository<Occupation, Long> {

}
