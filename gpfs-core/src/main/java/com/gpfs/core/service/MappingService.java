package com.gpfs.core.service;

import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import com.google.common.collect.Lists;
import com.gpfs.core.model.BaseEntity;

/**
 *
 * @author Mark Baldwin B. Martinez on Oct 6, 2016
 *
 */
public abstract class MappingService<E extends BaseEntity, D> {

    @Autowired
    protected Mapper mapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    public MappingService() {
        Class<?>[] genericTypes = GenericTypeResolver.resolveTypeArguments(getClass(), MappingService.class);
        entityClass = (Class<E>) genericTypes[0];
        dtoClass = (Class<D>) genericTypes[1];
    }

    public Optional<D> toDto(Optional<E> entity) {
        return entity.map(e -> Optional.of(toDto(e))).orElse(Optional.empty());
    }

    public D toDto(E entity) {
        return null == entity ? null : mapper.map(entity, dtoClass);
    }

    public E toEntity(D dto) {
        return null == dto ? null : mapper.map(dto, entityClass);
    }

    public List<D> toDto(Iterable<E> entities) {
        List<D> dtos = Lists.newArrayList();
        if (null != entities) {
            for (E entity : entities) {
                dtos.add(toDto(entity));
            }
        }
        return dtos;
    }

    public List<E> toEntity(Iterable<D> dtos) {
        List<E> entities = Lists.newArrayList();
        if (null != dtos) {
            for (D dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}