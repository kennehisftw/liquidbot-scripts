package org.kenneh.script.context;

import org.kenneh.impl.query.*;
import org.kenneh.impl.wrappers.*;
import org.kenneh.script.AbstractScript;

/**
 * Created by Kenneth on 7/24/2014.
 */
public class ClientContext {

    private final AbstractScript script;

    public final Status status;
    public final Movement movement;
    public final Combat combat;
    public final Skills skills;
    public final Camera camera;
    public final NpcQuery npcs;
    public final ObjectQuery objects;
    public final GroundItemQuery groundItems;
    public final PlayerQuery players;
    public final ItemQuery inventory;
    public final Widgets widgets;

    public ClientContext(AbstractScript script) {
        this.script = script;

        this.status = new Status();
        this.movement = new Movement();
        this.skills = new Skills();
        this.camera = new Camera();
        this.npcs = new NpcQuery();
        this.objects = new ObjectQuery();
        this.players = new PlayerQuery();
        this.groundItems = new GroundItemQuery();
        this.inventory = new ItemQuery();
        this.widgets = new Widgets();
        this.combat = new Combat(this);
    }

    public AbstractScript script() {
        return script;
    }

}
