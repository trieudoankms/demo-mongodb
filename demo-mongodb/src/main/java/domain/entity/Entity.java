package domain.entity;

import domain.ID;

/**
 * Created by trieu on 20/05/2015.
 */
public abstract class Entity {
    @ID("_id")
    protected String id;

    final public String getId() {
        return id;
    }

    final public void setId(String id) {
        this.id = id;
    }
}
