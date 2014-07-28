package org.kenneh.scripts.actions;

import org.kenneh.script.Action;
import org.kenneh.script.context.ClientContext;
import org.kenneh.scripts.TestScript;
import org.liquid.automation.osrs.api.util.Condition;
import org.liquid.automation.osrs.api.util.Time;
import org.liquid.automation.osrs.api.wrapper.GroundItem;

/**
 * Created by Kenneth on 7/27/2014.
 */
public class Loot extends Action {

    private final TestScript script;

    public Loot(ClientContext ctx) {
        super(ctx);
        this.script = (TestScript) ctx.script();
    }

    @Override
    public boolean activate() {
        return !script.groundItemQuery().isEmpty();
    }

    @Override
    public void execute() {
        final GroundItem loot = script.groundItemQuery().nearest().poll();
        if(loot != null) {
            if(!loot.isOnScreen()) {
                ctx.camera.turnTo(loot);
                ctx.movement.walk(loot);
            } else {
                if(loot.interact("Take", loot.getName())) {
                    Time.sleep(new Condition() {
                        @Override
                        public boolean active() {
                            return loot == null || !loot.isValid();
                        }
                    }, 200, 5);
                }
            }
        }
    }
}
