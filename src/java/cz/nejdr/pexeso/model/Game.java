package cz.nejdr.pexeso.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author mige
 */
public class Game implements Serializable {

    private int size;
    private ArrayList<Card> cardsList;
    private int move; // Move game (0,1,2)
    private int nowPlayingPlayer; // idx player
    private ArrayList<Player> players;
    private Card lastCard;
    private boolean foundPair;
    private ArrayList<Card> hideCards;
    private int countdown;

    public Game(int size) {
        this.size = size;

        // prepare cards
        int cntCard = size / 2;
        cardsList = new ArrayList<Card>();
        for (int i = 1; i <= cntCard; i++) {
            cardsList.add(new Card(i));
            cardsList.add(new Card(i)); // 2 same cards to pair
        }
        Collections.shuffle(cardsList);
        Collections.shuffle(cardsList);

        nowPlayingPlayer = 0;
        players = new ArrayList<Player>();
        lastCard = null;
        hideCards = new ArrayList<Card>();
        foundPair = false;
        countdown = size;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getNowPlayingPlayer() {
        if (players.isEmpty()) {
            return null;
        }

        return players.get(nowPlayingPlayer);
    }

    public ArrayList<Card> getCardsList() {
        return cardsList;
    }

    public int getWidth() {
        return (int) Math.sqrt(size);
    }

    public boolean turnTheCard(int position) {
        Card card = cardsList.get(position);

        if (card.isFacing()) {
            return false;
        }

        card.setFacing(true);
        if (move == 0) {
            hideFacingCards();
        }
        move++;
        if (move == 2) {
            move = 0;

            if (lastCard.getIdCard() != card.getIdCard()) {
                nowPlayingPlayer++;
                if (nowPlayingPlayer >= players.size()) {
                    nowPlayingPlayer = 0;
                }
                foundPair = false;
                hideCards.add(card);
                hideCards.add(lastCard);
            } else {
                foundPair = true;
                getNowPlayingPlayer().increaseScore();
                card.setRemoved(true);
                lastCard.setRemoved(true);
                countdown -= 2;
            }
        }

        lastCard = card;

        return true;
    }

    public void hideFacingCards() {
        if (hideCards.size() != 2) {
            return;
        }

        hideCards.get(0).setFacing(false);
        hideCards.get(1).setFacing(false);
        hideCards.clear();
    }

    public boolean isFoundPair() {
        return foundPair;
    }

    public boolean isGameFinished() {
        if (countdown == 0) {
            return true;
        }
        return false;
    }

    public boolean isSecondCardFacing() {
        if (hideCards.size() == 2) {
            return true;
        }
        return false;
    }

    /**
     * Player or multiple players with the highest score
     *
     * @return ArrayList with players
     */
    public ArrayList<Player> getWinner() {
        if (!isGameFinished()) {
            return null;
        }

        Collections.sort(players);

        ArrayList<Player> winners = new ArrayList<Player>();
        Player winner = players.get(0);
        int highestScore = winner.getScore();

        for (Iterator<Player> it = players.iterator(); it.hasNext();) {
            Player player = it.next();
            if (player.getScore() == highestScore) {
                winners.add(player);
            }
        }

        return winners;
    }
}
