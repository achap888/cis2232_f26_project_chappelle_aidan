package ca.hccis.race.repositories;

import ca.hccis.race.jpa.entity.CodeValue;
import ca.hccis.race.jpa.entity.CodeValueId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeValueRepository extends CrudRepository<CodeValue, CodeValueId> {
}