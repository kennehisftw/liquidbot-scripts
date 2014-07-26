package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.methods.interactive.GroundItems;
import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.wrapper.GroundItem;

import java.util.Arrays;

/**
 * Created by Kenneth on 7/25/2014.
 */
public class GroundItemQuery extends LocatableQuery<GroundItemQuery, GroundItem> {
    
    @Override
    protected GroundItem[] elements() {
        return GroundItems.getAll();
    }

    public GroundItemQuery name(String... names) {
        return filter(new Filter<GroundItem>() {
            @Override
            public boolean accept(GroundItem object) {
                return Arrays.asList(names).contains(object.getName());
            }
        });
    }

    public GroundItemQuery id(int... ids) {
        return filter(new Filter<GroundItem>() {
            @Override
            public boolean accept(GroundItem object) {
                return Arrays.asList(ids).contains(object.getId());
            }
        });
    }
}
