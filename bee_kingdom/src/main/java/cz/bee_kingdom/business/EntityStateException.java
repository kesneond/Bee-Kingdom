package cz.bee_kingdom.business;

public class EntityStateException extends RuntimeException {
    public EntityStateException() {}

    public <E> EntityStateException( E entity ) {
        super( "Illegal state of entity " + entity );
    }
}
