package org.kenneh.scripts;

import org.kenneh.script.ActionScript;
import org.kenneh.scripts.actions.Fight;
import org.liquid.automation.osrs.api.Manifest;
import org.liquid.automation.osrs.api.SkillCategory;
import org.liquid.automation.osrs.api.listeners.PaintListener;
import org.liquid.automation.osrs.api.methods.data.Skills;
import org.liquid.automation.osrs.api.methods.interactive.Widgets;

import java.awt.*;

/**
 * Created by Kenneth on 7/24/2014.
 */
@Manifest(
        scriptName = "TestScript",
        description =  "Tests stuff",
        author = "Kenneh",
        category = SkillCategory.MISC
)
public class TestScript extends ActionScript implements PaintListener {

    @Override
    public void start() {
        log.info("Script starting!");
        add(new Fight(ctx));
    }

    public int healthPercent() {
        return (Integer.parseInt(Widgets.get(548).getChild(77).getText()) * 100) / Skills.getRealLevel(Skills.Skill.CONSTITUTION);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString("Camera angle: "+ ctx.camera.angle(), 5, 100);
        graphics.drawString("Health percent: "+ healthPercent(), 5, 115);
    }
}
