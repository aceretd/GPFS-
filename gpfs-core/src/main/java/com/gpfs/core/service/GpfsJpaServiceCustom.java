package com.gpfs.core.service;

import com.google.common.collect.ImmutableMap;
import com.gpfs.core.dto.BaseInfo;
import com.gpfs.core.model.BaseEntity;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 *
 * @author Mark Baldwin B. Martinez on Oct 6, 2016
 *
 */
@NoRepositoryBean
public interface GpfsJpaServiceCustom<E extends BaseEntity, D extends BaseInfo> {

    D findOneInfo(Long id);

    D findOneInfo(Predicate p);

    D deleteInfo(Long id);

    D saveInfo(D dto);

    List<D> saveInfo(Iterable<D> dtos);

    E saveInfoAndGetEntity(D dto);

    List<E> saveInfoAndGetEntity(Iterable<D> dtos);

    Page<D> pageInfo(Pageable page);

    Page<D> rqlSearch(String term, ImmutableMap<String, Path<?>> fieldMapping, Pageable page);

    Page<E> rqlSearchForEntities(String term, ImmutableMap<String, Path<?>> fieldMapping, Pageable page);

    List<D> rqlSearch(String term, ImmutableMap<String, Path<?>> fieldMapping, OrderSpecifier<?>... sort);

    List<D> findAllInfo();

    List<D> findAllInfo(Predicate predicate);

    List<D> findAllInfo(Predicate predicate, Sort sort);

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.of();
    }

}

