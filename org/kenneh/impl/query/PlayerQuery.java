package org.kenneh.impl.query;

import org.liquid.automation.osrs.api.methods.interactive.Players;
import org.liquid.automation.osrs.api.util.Filter;
import org.liquid.automation.osrs.api.wrapper.Player;

import java.util.Arrays;

/**
 * Created by Kenneth on 7/25/2014.
 */
public class PlayerQuery extends LocatableQuery<PlayerQuery, Player> {
    @Override
    protected Player[] elements() {
        return Players.getAll();
    }
    
    public Player local() {
        return Players.getLocal();
    }

    public PlayerQuery name(final String... names) {
        return filter(new Filter<Player>() {
            @Override
            public boolean accept(Player object) {
                return Arrays.asList(names).contains(object.getName());
            }
        });
    }

}