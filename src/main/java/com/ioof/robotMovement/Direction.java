package com.ioof.robotMovement;

/**
 * Created by songwang on 13/06/2017.
 * Direction class
 */
public enum Direction {
    /**
     * Direction enum class
     */
    NORTH("NORTH"), WEST("WEST"), EAST("EAST"), SOUTH("SOUTH");

    /**
     * text of class
     */
    private String text;

    /**
     * constructor
     * @param text
     */
    Direction(String text) {
        this.text = text;
    }

    /**
     * getting direction as string
     * @return
     */
    @Override
    public String toString(){
        return this.text;
    }
}
