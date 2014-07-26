package org.kenneh.impl.wrappers;

import org.liquid.automation.osrs.api.util.Locatable;

/**
 * Created by Kenneth on 7/24/2014.
 */
public class Camera {

    public int x() {
        return org.liquid.automation.osrs.api.methods.data.movement.Camera.getX();
    }

    public int y() {
        return org.liquid.automation.osrs.api.methods.data.movement.Camera.getY();
    }

    public int angle() {
        return org.liquid.automation.osrs.api.methods.data.movement.Camera.getAngle();
    }

    public int yaw() {
        return org.liquid.automation.osrs.api.methods.data.movement.Camera.getYaw();
    }

    public boolean angle(int degrees) {
        return org.liquid.automation.osrs.api.methods.data.movement.Camera.setAngle(degrees);
    }

    public void turnTo(Locatable loc) {
        org.liquid.automation.osrs.api.methods.data.movement.Camera.turnTo(loc);
    }

}
