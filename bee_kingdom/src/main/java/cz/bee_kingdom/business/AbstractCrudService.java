package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.CrudRepository;
import cz.bee_kingdom.domain.DomainEntity;

import java.util.Optional;

public abstract class AbstractCrudService <E extends DomainEntity<K>, K> {
    protected final CrudRepository<E, K> repository;

    protected AbstractCrudService( CrudRepository<E, K> repository ) {
        this.repository = repository;
    }

    public E create( E entity ) throws EntityStateException {
        K id = entity.getID();
        System.out.println(entity.toString());

        if( id != null && repository.existsById(id) ) {
            throw new EntityStateException(entity);
        }

        return repository.save(entity);
    }

    public Optional<E> readByID( K id ) {
        return repository.findById(id);
    }

    public Iterable<E> readAll() {
        return repository.findAll();
    }

    public E update(E entity) throws EntityStateException {
        if (repository.existsById(entity.getID()))
            return repository.save(entity);
        else
            throw new EntityStateException(entity);
    }

    public void deleteById(K id) {
        repository.deleteById(id);
    }

}
