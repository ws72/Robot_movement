package com.ioof.robotMovement.test.java;

import com.ioof.robotMovement.Direction;
import com.ioof.robotMovement.Position;
import com.ioof.robotMovement.Robot;
import com.ioof.robotMovement.Rotation;
import com.ioof.robotMovement.exception.PositionOutOfRangeException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by songwang on 15/06/2017.
 * Robot unit test
 */
public class TestRobot {

    final static String LEFT = "LEFT";
    final static String RIGHT = "RIGHT";

    final static String EAST = "EAST";
    final static String SOUTH = "SOUTH";
    final static String WEST = "WEST";
    final static String NORTH = "NORTH";

    Robot robot;

    /**
     * constructor
     */
    public TestRobot(){
        try {
            robot = Robot.getInstance(Direction.valueOf(EAST),new Position(0,0));
        } catch (PositionOutOfRangeException e) {
            e.printStackTrace();
        }
    }

    /**
     * test position
     */
    @Test
    public void testPositionOutOfRangeByNagetiveX(){
        try {
            robot.setPos(new Position(-1,0));
        } catch (PositionOutOfRangeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testPositionOutOfRangeByNagetiveY(){
        try {
            robot.setPos(new Position(0,-1));
        } catch (PositionOutOfRangeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testPositionOutOfRangeByNagetiveXY(){
        try {
            robot.setPos(new Position(-1,-1));
        } catch (PositionOutOfRangeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testPositionOutOfRangeByX(){
        try {
            robot.setPos(new Position(5,0));
        } catch (PositionOutOfRangeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testPositionOutOfRangeByY(){
        try {
            robot.setPos(new Position(0,5));
        } catch (PositionOutOfRangeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testPositionOutOfRangeByXY(){
        try {
            robot.setPos(new Position(5,5));
        } catch (PositionOutOfRangeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPositionInRange(){
        try {
            robot.setPos(new Position(0,0));
        } catch (PositionOutOfRangeException e) {
            assertTrue(false);
        }
    }

    /**
     * test left rotation
     */
    @Test
    public void testRotateLeftWithEast() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(EAST));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(LEFT));
        assertEquals(Direction.NORTH.toString(),robot.getCurrentDirection().toString());
    }
    @Test
    public void testRotateLeftWithSouth() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(SOUTH));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(LEFT));
        assertEquals(Direction.EAST.toString(),robot.getCurrentDirection().toString());
    }
    @Test
    public void testRotateLeftWithWest() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(WEST));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(LEFT));
        assertEquals(Direction.SOUTH.toString(),robot.getCurrentDirection().toString());
    }
    @Test
    public void testRotateLeftWithNorth() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(NORTH));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(LEFT));
        assertEquals(Direction.WEST.toString(),robot.getCurrentDirection().toString());
    }
    /**
     * test right rotation
     */
    @Test
    public void testRotateRightWithEast() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(EAST));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(RIGHT));
        assertEquals(Direction.SOUTH.toString(),robot.getCurrentDirection().toString());
    }
    @Test
    public void testRotateRightWithSouth() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(SOUTH));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(RIGHT));
        assertEquals(Direction.WEST.toString(),robot.getCurrentDirection().toString());
    }
    @Test
    public void testRotateRightWithWest() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(WEST));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(RIGHT));
        assertEquals(Direction.NORTH.toString(),robot.getCurrentDirection().toString());
    }
    @Test
    public void testRotateRightWithNorth() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(NORTH));
        robot.setPos(new Position(0,0));
        robot.rotate(Rotation.valueOf(RIGHT));
        assertEquals(Direction.EAST.toString(),robot.getCurrentDirection().toString());
    }

    /**
     * test move
     */
    @Test
    public void testMoveWithEast() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(EAST));
        robot.setPos(new Position(0,0));
        robot.move();
        assertEquals("1,0",robot.getPos().toString());

    }
    @Test
    public void testMoveWithSouth() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(SOUTH));
        robot.setPos(new Position(0,1));
        robot.move();
        assertEquals("0,0",robot.getPos().toString());
    }

    @Test
    public void testMoveWithWest() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(WEST));
        robot.setPos(new Position(1,0));
        robot.move();
        assertEquals("0,0",robot.getPos().toString());
    }

    @Test
    public void testMoveWithNorth() throws PositionOutOfRangeException {
        robot.setCurrentDirection(Direction.valueOf(NORTH));
        robot.setPos(new Position(0,0));
        robot.move();
        assertEquals("0,1",robot.getPos().toString());
    }
}
