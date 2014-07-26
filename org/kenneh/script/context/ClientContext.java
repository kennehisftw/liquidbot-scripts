package org.kenneh.script.context;

import org.kenneh.impl.query.GroundItemQuery;
import org.kenneh.impl.query.NpcQuery;
import org.kenneh.impl.query.ObjectQuery;
import org.kenneh.impl.query.PlayerQuery;
import org.kenneh.impl.wrappers.Camera;
import org.kenneh.script.AbstractScript;

/**
 * Created by Kenneth on 7/24/2014.
 */
public class ClientContext {

    private final AbstractScript script;

    public final Camera camera;
    public final NpcQuery npcs;
    public final ObjectQuery objects;
    public final GroundItemQuery groundItems;
    public final PlayerQuery players;

    public ClientContext(AbstractScript script) {
        this.script = script;

        this.camera = new Camera();
        this.npcs = new NpcQuery();
        this.objects = new ObjectQuery();
        this.players = new PlayerQuery();
        this.groundItems = new GroundItemQuery();
    }

    public AbstractScript script() {
        return script;
    }

}
