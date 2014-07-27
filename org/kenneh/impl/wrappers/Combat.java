package org.kenneh.impl.wrappers;

import org.kenneh.script.context.ClientAccessor;
import org.kenneh.script.context.ClientContext;

/**
 * Created by Kenneth on 7/26/2014.
 */
public class Combat extends ClientAccessor {

    public Combat(ClientContext ctx) {
        super(ctx);
    }

    public boolean inCombat() {
        return (ctx.players.local().getInteracting() != null || ctx.players.local().isInCombat());
    }

    public int healthPercent() {
        return (Integer.parseInt(ctx.widgets.get(548, 77).getText()) * 100) / ctx.skills.realLevel(org.liquid.automation.osrs.api.methods.data.Skills.Skill.CONSTITUTION);
    }

}
