package com.ioof.robotMovement;

/**
 * Created by songwang on 13/06/2017.
 * Robot position class
 */
public class Position {
    /**
     * position x
     */
    Integer x;

    /**
     * position y
     */
    Integer y;

    /**
     * x getter
     * @return int
     */
    public Integer getX() {
        return x;
    }

    /**
     * x setter
     * @param x
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * y getter
     * @return int
     */
    public Integer getY() {
        return y;
    }

    /**
     * y setter
     * @param y
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * constructor
     * @param x
     * @param y
     */
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * print out position as string
     * @return
     */
    @Override
    public String toString(){
        return this.x.toString() + "," + this.y.toString();
    }
}
