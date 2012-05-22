package cz.nejdr.pexeso.model;

import java.io.Serializable;

/**
 *
 * @author mige
 */
public class Player implements Serializable, Comparable<Player> {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    @Override
    public String toString() {
        return "<tr><td>" + this.name + "</td><td>" + this.score + "</td></tr>";
    }

    /**
     * Compare who has the bigger score
     *
     * @param player - Player you compare with this player.
     * @return -1 = player has a higher score , 1 = player has a lower score, 0
     * = same score
     */
    public int compareTo(Player player) {
        if (this.score > player.score) {
            return -1;
        } else if (this.score < player.score) {
            return 1;
        } else {
            return 0;
        }
    }
}
