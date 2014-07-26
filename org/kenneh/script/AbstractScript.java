package org.kenneh.script;

import org.kenneh.script.context.ClientContext;
import org.liquid.automation.osrs.api.LiquidScript;

import java.util.logging.Logger;

/**
 * Created by Kenneth on 7/24/2014.
 */
public abstract class AbstractScript extends LiquidScript {

    public final Logger log = Logger.getLogger(getClass().getSimpleName());

    public final ClientContext ctx;

    public AbstractScript() {
        this.ctx = new ClientContext(this);
    }

    @Override
    public void onStart() {
        start();
    }

    @Override
    public void onStop() {
        finish();
    }

    public abstract void start();
    public void finish() {};
}
