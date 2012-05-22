package cz.nejdr.pexeso.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author mige
 */
public class Stats implements Serializable {

    ArrayList<Player> players;

    public Stats() {
        players = new ArrayList<Player>();
    }

    public void AddWinner(Player player) {
        if (player == null) {
            return;
        }

        for (Iterator<Player> it = players.iterator(); it.hasNext();) {
            Player current = it.next();
            if (current.getName().compareTo(player.getName()) == 0) {
                current.increaseScore();
                Collections.sort(players);
                return;
            }
        }

        Player newWinner = new Player(player.getName());
        newWinner.increaseScore();
        players.add(newWinner);
        Collections.sort(players);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
