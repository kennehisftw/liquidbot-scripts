package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.util.Locatable;

import java.util.*;

/**
 * Created by Kenneth on 7/24/2014.
 */
public abstract class AbstractQuery<Q extends AbstractQuery, E> implements Iterable<E>{

    private final List<E> list = new LinkedList<>();

    protected abstract E[] elements();

    public Q getThis() {
        return (Q) this;
    }

    public Q refresh() {
        list.clear();
        Collections.addAll(list, elements());
        return (Q) this;
    }

    public E poll() {
        return isEmpty() ? null : list.get(0);
    }

    public Q shuffle() {
        Collections.shuffle(list);
        return (Q) this;
    }

    public Q filter(Filter<E> filter) {
        final List<E> clone = new LinkedList<>(list);
        for(E e : clone) {
            if(e != null && !filter.accept(e)) {
                list.remove(e);
            }
        }
        return (Q) this;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Q sort(Comparator<E> comparator) {
        Collections.sort(list, comparator);
        return (Q) this;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
