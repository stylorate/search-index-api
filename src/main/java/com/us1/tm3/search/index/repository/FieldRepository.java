package com.us1.tm3.search.index.repository;

import com.us1.tm3.search.index.domain.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FieldRepository extends JpaRepository<Field, UUID> {
}
