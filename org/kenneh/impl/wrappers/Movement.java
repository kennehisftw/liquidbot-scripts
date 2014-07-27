package org.kenneh.impl.wrappers;

import org.liquid.automation.osrs.api.methods.data.movement.Walking;
import org.liquid.automation.osrs.api.util.Locatable;
import org.liquid.automation.osrs.api.wrapper.Path;
import org.liquid.automation.osrs.api.wrapper.Tile;

/**
 * Created by Kenneth on 7/26/2014.
 */
public class Movement {

    public boolean running() {
        return Walking.isRunning();
    }

    public boolean usingOrbs() {
        return Walking.isUseingOrbs();
    }

    public void walk(Locatable locatable) {
        Walking.walkTo(locatable);
    }

    public Tile closestOnMap(Tile tile) {
        return Walking.getClosestTileOnMap(tile);
    }

    public Path findPath(Locatable locatable) {
        return Walking.findPath(locatable.getLocation());
    }

    public Path findPath(Locatable to, Locatable from) {
        return Walking.findPath(to.getLocation(), from.getLocation());
    }

    public boolean setRun(boolean running) {
        return Walking.setQuickRun(running);
    }
}
