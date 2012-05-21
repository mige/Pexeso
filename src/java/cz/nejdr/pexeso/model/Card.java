package cz.nejdr.pexeso.model;

import java.io.Serializable;

/**
 *
 * @author mige
 */
public class Card implements Serializable {

    private int id;
    private boolean isFacing;
    private boolean isRemoved;

    /**
     * Constructor.
     *
     * @param id Card Id
     */
    public Card(int id) {
        this.id = id;
        isFacing = false;
        isRemoved = false;
    }

    /**
     *
     * @return Card Id
     */
    public int getIdCard() {
        return id;
    }

    public boolean isFacing() {
        return isFacing;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setFacing(boolean state) {
        isFacing = state;
    }

    public void setRemoved(boolean state) {
        isRemoved = state;
    }
}
