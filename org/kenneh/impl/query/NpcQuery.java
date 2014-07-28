package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.methods.interactive.NPCs;
import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.wrapper.NPC;

import java.util.Arrays;


/**
 * Created by Kenneth on 7/24/2014.
 */
public class NpcQuery extends LocatableQuery<NpcQuery, NPC> {

    @Override
    protected NPC[] elements() {
        return NPCs.getAll();
    }

    public NpcQuery name(String... names) {
        return filter(new Filter<NPC>() {
            @Override
            public boolean accept(NPC npc) {
                return npc != null && Arrays.asList(names).contains(npc.getName());
            }
        });
    }

    public NpcQuery id(int... ids) {
        return filter(new Filter<NPC>() {
            @Override
            public boolean accept(NPC npc) {
                return npc != null && Arrays.asList(ids).contains(npc.getId());
            }
        });
    }

}
