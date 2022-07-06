package com.test.mariabd;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface EntityWithUuidRepository extends CrudRepository<EntityWithUuid, Long> {

    String ALL_COLUMNS = "id," + "uuid";

    @Query("SELECT " + ALL_COLUMNS + " FROM entity_with_uuid WHERE id = :id")
    EntityWithUuid findById(long id);

}
