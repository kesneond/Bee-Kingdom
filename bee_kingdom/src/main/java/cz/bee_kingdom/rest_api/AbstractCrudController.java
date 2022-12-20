package cz.bee_kingdom.rest_api;


import cz.bee_kingdom.business.AbstractCrudService;
import cz.bee_kingdom.domain.DomainEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.StreamSupport;

public abstract class AbstractCrudController<E extends DomainEntity<ID>, D, ID> {
    protected AbstractCrudService<E, ID> service;
    protected Function<E, D> toDtoConverter;
    protected Function<D, E> toEntityConverter;

    public AbstractCrudController(AbstractCrudService<E, ID> service, Function<E, D> toDtoConverter, Function<D, E> toEntityConverter) {
        this.service = service;
        this.toDtoConverter = toDtoConverter;
        this.toEntityConverter = toEntityConverter;
    }


    @PostMapping
    public D create(@RequestBody D e) {
        return toDtoConverter.apply(service.create(toEntityConverter.apply(e)));
    }

    @GetMapping
    public Collection<D> readAll() {
        return StreamSupport.stream(service.readAll().spliterator(), false).map(toDtoConverter).toList();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody D e, @PathVariable ID id) {
        service.update(toEntityConverter.apply(e));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.deleteById(id);
    }
}

