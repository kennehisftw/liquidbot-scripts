package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.util.Locatable;
import org.liquid.automation.osrs.api.wrapper.Area;

import java.util.Comparator;

/**
 * Created by Kenneth on 7/25/2014.
 */
public abstract class LocatableQuery<Q extends LocatableQuery, E extends Locatable> extends AbstractQuery<Q, E> {

    public Q nearest() {
        return sort(DISTANCE_SORT);
    }

    public Q within(final int radius) {
        return filter(new Filter<E>() {
            @Override
            public boolean accept(E e) {
                return e.distanceTo() <= radius;
            }
        });
    }

    public Q within(final Area area) {
        return filter(new Filter<E>() {
            @Override
            public boolean accept(E e) {
                return area.contains(e);
            }
        });
    }

    private final Comparator<E> DISTANCE_SORT = new Comparator<E>() {
        @Override
        public int compare(Locatable o1, Locatable o2) {
            return o1.distanceTo() - o2.distanceTo();
        }
    };
}
