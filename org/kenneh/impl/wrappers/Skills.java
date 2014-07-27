package org.kenneh.impl.wrappers;

/**
 * Created by Kenneth on 7/26/2014.
 */
public class Skills {

    public int realLevel(org.liquid.automation.osrs.api.methods.data.Skills.Skill skill) {
        return org.liquid.automation.osrs.api.methods.data.Skills.getRealLevel(skill);
    }

    public int currentLevel(org.liquid.automation.osrs.api.methods.data.Skills.Skill skill) {
        return org.liquid.automation.osrs.api.methods.data.Skills.getCurrentLevel(skill);
    }

    public int experience(org.liquid.automation.osrs.api.methods.data.Skills.Skill skill) {
        return org.liquid.automation.osrs.api.methods.data.Skills.getExperience(skill);
    }

}
