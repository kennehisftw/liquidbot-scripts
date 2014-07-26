package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.util.Locatable;

import java.util.Comparator;

/**
 * Created by Kenneth on 7/25/2014.
 */
public abstract class LocatableQuery<Q extends LocatableQuery, E extends Locatable> extends AbstractQuery<Q, E> {

    public Q nearest() {
        return sort(DISTANCE_SORT);
    }

    public Q within(int radius) {
        return filter(new Filter<E>() {
            @Override
            public boolean accept(E e) {
                return e.distanceTo() <= radius;
            }
        });
    }

    private final Comparator<E> DISTANCE_SORT = new Comparator<E>() {
        @Override
        public int compare(Locatable o1, Locatable o2) {
            return o2.distanceTo() - o1.distanceTo();
        }
    };
}
