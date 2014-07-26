package org.kenneh.script;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kenneth on 7/24/2014.
 */
public abstract class ActionScript extends AbstractScript implements Comparator<Action> {

    private final List<Action> actionList = new LinkedList<>();

    private Action get() {
        for(Action action : actionList) {
            if(action != null && action.activate()) {
                return action;
            }
        }
        return null;
    }

    public void add(Action... actions) {
        Collections.addAll(actionList, actions);
        Collections.sort(actionList, this);
    }

    @Override
    public int operate() {
        final Action action = get();
        if(action != null) {
            action.execute();
        }
        return 200;
    }

    @Override
    public int compare(Action a, Action b) {
        return b.priority() - a.priority();
    }

}
