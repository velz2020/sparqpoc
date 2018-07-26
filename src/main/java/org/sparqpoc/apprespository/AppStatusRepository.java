package org.sparqpoc.apprespository;

import org.sparqpoc.appmodel.AppStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppStatusRepository extends JpaRepository<AppStatus, Long> {

}
