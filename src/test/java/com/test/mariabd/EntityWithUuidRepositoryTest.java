package com.test.mariabd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EntityWithUuidRepositoryTest {

    @Autowired protected JdbcAggregateTemplate jdbcAggregateTemplate;

    @Autowired
    private EntityWithUuidRepository repository;

    private final UUID uuid1 = randomUUID();
    private final UUID uuid2 = randomUUID();

    private EntityWithUuid entity1;
    private EntityWithUuid entity2;

    @BeforeEach
    void insertIntoDb() {
        entity1 = jdbcAggregateTemplate.insert(new EntityWithUuid(null, uuid1));
        entity2 = jdbcAggregateTemplate.insert(new EntityWithUuid(null, uuid2));
    }

    @Test
    void should_findById() {
        // WHEN: findByUserId
        Optional<EntityWithUuid> result = repository.findById(entity1.getId());

        // THEN: Repository has returned expected V3UserUuid
        assertThat(result).isNotEmpty();
        assertThat(result).contains(entity1);
    }

}
