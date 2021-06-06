package com.teammatch.matchmaking.repository;

import com.teammatch.matchmaking.entity.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<Filter,Long> {

}