package com.gpfs.core.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.gpfs.core.model.BaseEntity;

@NoRepositoryBean
public interface GpfsJpaService<E extends BaseEntity>
    extends JpaRepository<E, Long>, QueryDslPredicateExecutor<E> {

}
