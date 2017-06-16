package com.ioof.robotMovement;

/**
 * Created by songwang on 13/06/2017.
 */
public enum Direction {
     NORTH("NORTH"), WEST("WEST"), EAST("EAST"), SOUTH("SOUTH");

    private String text;

    Direction(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
