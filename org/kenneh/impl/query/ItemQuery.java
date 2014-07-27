package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.methods.data.Inventory;
import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.wrapper.Item;

import java.util.Arrays;

/**
 * Created by Kenneth on 7/26/2014.
 */
public class ItemQuery extends AbstractQuery<ItemQuery, Item> {

    @Override
    protected Item[] elements() {
        return Inventory.getAllItems();
    }

    public ItemQuery name(String... names) {
        return filter(new Filter<Item>() {
            @Override
            public boolean accept(Item object) {
                return Arrays.asList(names).contains(object.getName());
            }
        });
    }

    public ItemQuery id(int... ids) {
        return filter(new Filter<Item>() {
            @Override
            public boolean accept(Item object) {
                return Arrays.asList(ids).contains(object.getId());
            }
        });
    }
}
