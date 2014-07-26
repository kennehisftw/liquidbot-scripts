package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.methods.interactive.GameEntities;
import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.wrapper.GameObject;

import java.util.Arrays;

/**
 * Created by Kenneth on 7/25/2014.
 */
public class ObjectQuery extends LocatableQuery<ObjectQuery, GameObject> {
    @Override
    protected GameObject[] elements() {
        return GameEntities.getAll();
    }

    public ObjectQuery name(String... names) {
        return filter(new Filter<GameObject>() {
            @Override
            public boolean accept(GameObject object) {
                return Arrays.asList(names).contains(object.getName());
            }
        });
    }

    public ObjectQuery id(int... ids) {
        return filter(new Filter<GameObject>() {
            @Override
            public boolean accept(GameObject object) {
                return Arrays.asList(ids).contains(object.getId());
            }
        });
    }
}
