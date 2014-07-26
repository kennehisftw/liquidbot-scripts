package org.kenneh.script;

/**
 * Created by Kenneth on 7/24/2014.
 */
public abstract class PollingScript extends AbstractScript {

    @Override
    public int operate() {
        return poll();
    }

    public abstract int poll();

}
