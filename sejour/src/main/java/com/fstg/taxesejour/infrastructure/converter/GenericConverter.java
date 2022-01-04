package com.fstg.taxesejour.infrastructure.converter;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter<E, P> {
    //E Entity
    // P POJO
    E toEntity(P pojo);

    P toPojo(E entity);

    default List<P> createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::toPojo)
                .collect(Collectors.toList());
    }

    default List<E> createFromPojo(final Collection<P> pojos) {
        return pojos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
