package org.kenneh.script;

import org.kenneh.script.context.ClientAccessor;
import org.kenneh.script.context.ClientContext;

import java.util.logging.Logger;

/**
 * Created by Kenneth on 7/24/2014.
 */
public abstract class Action extends ClientAccessor {

    public final Logger log = Logger.getLogger(getClass().getSimpleName());

    public Action(ClientContext ctx) {
        super(ctx);
    }

    public abstract boolean activate();
    public abstract void execute();

    public int priority() {
        return 0;
    }

}
