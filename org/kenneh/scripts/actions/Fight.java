package org.kenneh.scripts.actions;

import org.kenneh.script.Action;
import org.kenneh.script.context.ClientContext;
import org.kenneh.scripts.TestScript;
import org.liquid.automation.osrs.api.util.Condition;
import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.util.Time;
import org.liquid.automation.osrs.api.wrapper.NPC;

/**
 * Created by Kenneth on 7/25/2014.
 */
public class Fight extends Action {

    public Fight(ClientContext ctx) {
        super(ctx);
    }

    private NPC target;

    @Override
    public boolean activate() {
        return ctx.combat.inCombat() && ctx.combat.healthPercent() >= 25 && (target = getTarget()) != null;
    }

    @Override
    public void execute() {
        if(!target.isOnScreen()) {
            ctx.camera.turnTo(target);
            ctx.movement.walk(target);
        } else {
            if(target.interact("Attack", target.getName())) {
                Time.sleep(new Condition() {
                    @Override
                    public boolean active() {
                        return ctx.combat.inCombat();
                    }
                }, 200, 5);
            }
        }
    }

    public NPC getTarget() {
        return !ctx.npcs.refresh().filter(interacting).isEmpty()
                ? ctx.npcs.nearest().poll() : ctx.npcs.refresh().name("Chicken").within(15).filter(filter).nearest().poll();
    }

    public Filter<NPC> interacting = new Filter<NPC>() {
        @Override
        public boolean accept(NPC npc) {
            return npc.getInteracting() != null && npc.getInteracting().equals(ctx.players.local());
        }
    };

    public Filter<NPC> filter = new Filter<NPC>() {
        @Override
        public boolean accept(NPC npc) {
            return npc.getInteracting() != null && !npc.isInCombat() && npc.getAnimation() == -1;
        }
    };
}
