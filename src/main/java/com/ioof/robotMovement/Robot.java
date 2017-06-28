package com.ioof.robotMovement;

import com.ioof.robotMovement.exception.PositionOutOfRangeException;

/**
 * Created by songwang on 13/06/2017.
 * Robot class
 */
public class Robot {
    /**
     * constructor
     */
    private Robot(){}

    /**
     * constructor
     * @param currentDirection
     * @param pos
     */
    private Robot(Direction currentDirection, Position pos){
        this.currentDirection = currentDirection;
        this.pos = pos;
    }

    /**
     * current direction getter
     * @return Direction
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /**
     * current direction setter
     */
    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    /**
     * current direction
     */
    private Direction currentDirection;

    /**
     * current position
     */
    private Position pos;

    /**
     * current position getter
     * @return Position
     */
    public Position getPos() {
        return pos;
    }

    /**
     * current position setter
     * @param pos
     * @throws PositionOutOfRangeException
     */
    public void setPos(Position pos) throws PositionOutOfRangeException {
        if(verifyPosition(pos)) {
            this.pos = pos;
        }else{
            throw new PositionOutOfRangeException("Position of placement of the toy robot out of range.");
        }
    }

    /**
     * singleton Robot object
     */
    private static Robot robot;

    /**
     * verify current position is valid
     * @param pos
     * @return
     */
    private static boolean verifyPosition(Position pos){
        return pos.getX()>=0 && pos.getY()>=0 && pos.getX()<=4 && pos.getY()<=4;
    }

    /**
     * getting or create singleton Robot object
     * @param currentDirection
     * @param pos
     * @return Robot
     * @throws PositionOutOfRangeException
     */
    public static Robot getInstance(Direction currentDirection, Position pos) throws PositionOutOfRangeException {
        if(robot == null){
            if(verifyPosition(pos)){
                robot = new Robot(currentDirection,pos);
            }else{
                throw new PositionOutOfRangeException("Position of placement of the toy robot out of range.");
            }
        }
        return robot;
    }

    /**
     * robot rotate
     * @param rotation
     */
    public void rotate(Rotation rotation){
        switch (currentDirection){
            case EAST:
                if(rotation.equals(Rotation.LEFT)){
                    currentDirection = Direction.NORTH;
                }else{
                    currentDirection = Direction.SOUTH;
                }
                break;
            case WEST:
                if(rotation.equals(Rotation.LEFT)){
                    currentDirection = Direction.SOUTH;
                }else{
                    currentDirection = Direction.NORTH;
                }
                break;
            case NORTH:
                if(rotation.equals(Rotation.LEFT)){
                    currentDirection = Direction.WEST;
                }else{
                    currentDirection = Direction.EAST;
                }
                break;
            default://SOUTH:
                if(rotation.equals(Rotation.LEFT)){
                    currentDirection = Direction.EAST;
                }else{
                    currentDirection = Direction.WEST;
                }
                break;
        }
    }

    /**
     * robot move
     */
    public void move(){
        switch (currentDirection){
            case EAST:
                if(pos.x < 5) pos.x++;
                break;
            case WEST:
                if(pos.x > 0) pos.x--;
                break;
            case NORTH:
                if(pos.y < 5) pos.y++;
                break;
            default://SOUTH:
                if(pos.y > 0) pos.y--;
                break;
        }
    }

    /**
     * robot report
     */
    public void report(){
        System.out.printf("Output: %d,%d,%s%n",pos.x,pos.y,currentDirection.toString());
    }
}
