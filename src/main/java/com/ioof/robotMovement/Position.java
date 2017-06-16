package com.ioof.robotMovement;

/**
 * Created by songwang on 13/06/2017.
 * Robot position
 */
public class Position {
    Integer x;
    Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return this.x.toString() + "," + this.y.toString();
    }
}
