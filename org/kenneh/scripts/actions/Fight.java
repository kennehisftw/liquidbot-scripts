package org.kenneh.scripts.actions;

import org.kenneh.script.Action;
import org.kenneh.script.context.ClientContext;
import org.kenneh.scripts.TestScript;
import org.liquid.automation.osrs.api.util.Condition;
import org.liquid.automation.osrs.api.util.Time;
import org.liquid.automation.osrs.api.wrapper.NPC;

/**
 * Created by Kenneth on 7/25/2014.
 */
public class Fight extends Action {

    private final TestScript script;

    public Fight(ClientContext ctx) {
        super(ctx);
        script = (TestScript) ctx.script();
    }

    @Override
    public boolean activate() {
        return script.healthPercent() >= 25 && (ctx.players.local().getInteracting() == null || !ctx.players.local().isInCombat()) && !ctx.npcs.refresh().name("Goblin").within(10).isEmpty();
    }

    @Override
    public void execute() {
        final NPC goblin = ctx.npcs.nearest().poll();
        if(goblin != null) {
            if(!goblin.isOnScreen()) {
                log.info("Turning camera towards NPC");
                ctx.camera.turnTo(goblin);
            } else {
                log.info("Attacking NPC");
                if(goblin.interact("Attack", goblin.getName())) {
                    Time.sleep(new Condition() {
                        @Override
                        public boolean active() {
                            return ctx.players.local().getInteracting() != null;
                        }
                    }, 20, 50);
                }
            }
        }
    }
}
