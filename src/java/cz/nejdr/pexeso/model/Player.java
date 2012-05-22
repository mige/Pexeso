/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.nejdr.pexeso.model;

import java.io.Serializable;

/**
 *
 * @author mige
 */
public class Player implements Serializable{
    
    private String name;
    
    private int score;
    
    public Player(String name)
    {
        this.name = name;
        score = 0;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void increaseScore()
    {
        score++;
    }
    
    @Override
    public String toString()
    {
        return "<tr><td>" + this.name + "</td><td>" + this.score + "</td></tr>";
    }
}
