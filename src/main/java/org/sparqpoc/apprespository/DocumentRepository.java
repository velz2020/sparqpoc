package org.sparqpoc.apprespository;

import java.util.List;

import org.sparqpoc.appmodel.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	

}
