package com.test.mariabd;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.nio.ByteBuffer;
import java.util.UUID;

@Value
@Table("entity_with_uuid")
@AllArgsConstructor(onConstructor_ = {@PersistenceCreator})
public class EntityWithUuid {

    @Column("id")
    @Id
    @With
    Long id;

    @With
    @Column("uuid")
    UUID uuid;

}
