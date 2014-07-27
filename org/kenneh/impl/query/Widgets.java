package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.wrapper.WidgetChild;

/**
 * Created by Kenneth on 7/26/2014.
 */
public class Widgets {

    public WidgetChild get(int parent, int child) {
        return org.liquid.automation.osrs.api.methods.interactive.Widgets.get(parent, child);
    }

}
