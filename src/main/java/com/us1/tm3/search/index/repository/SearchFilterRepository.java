package com.us1.tm3.search.index.repository;

import com.us1.tm3.search.index.domain.SearchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SearchFilterRepository extends JpaRepository<SearchFilter, UUID> {
    Optional<SearchFilter> findByUserIdAndNameAndBranchIdAndCarrierId(String userId, String name, String branch, String carrier);

    Optional<SearchFilter> findByIdAndUserId(UUID id, String userId);

    Page<SearchFilter> findByUserId(String userId, Pageable pageable);
}
