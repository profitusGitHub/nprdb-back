package com.profitus.nprdbservice.repository;

import com.profitus.nprdbservice.model.MessageId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MessageIdRepository extends CrudRepository<MessageId, Long> {
    Optional<MessageId> findFirstBy();
}
