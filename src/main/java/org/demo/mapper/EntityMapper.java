package org.demo.mapper;

public interface EntityMapper<E, M> {

    M entityToModel(E entity);

    E modelToEntity(M model);
}

