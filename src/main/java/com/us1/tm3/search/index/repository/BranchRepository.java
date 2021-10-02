package com.us1.tm3.search.index.repository;

import com.us1.tm3.search.index.controller.dto.BranchDTO;
import com.us1.tm3.search.index.domain.Branch;
import com.us1.tm3.search.index.domain.SearchFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> {

}
