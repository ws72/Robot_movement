package com.ioof.robotMovement;

import com.ioof.robotMovement.exception.PositionOutOfRangeException;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by songwang on 13/06/2017.
 */
public class Solution {

    final static String PLACE = "PLACE";
    final static String REPORT = "REPORT";
    final static String MOVE = "MOVE";
    final static String LEFT = "LEFT";
    final static String RIGHT = "RIGHT";

    public static void main(String[] args) throws IOException {
        Robot robot =null;
        System.out.println("Please input instructions:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String _instructions = scanner.next();

            System.out.println("_instructions:"+_instructions);

            // Input PLACE
            if(_instructions.equals(PLACE) && robot==null){
                _instructions = scanner.next();
                // validate valid input
                String reg= "^[0-4],[0-4],[NORTH|WEST|EAST|SOUTH]*$";
                if(Pattern.matches(reg, _instructions)){
                    String[] instructionArray = _instructions.split(",");
                    try {
                        robot = Robot.getInstance(Direction.valueOf(instructionArray[2]),new Position(Integer.valueOf(instructionArray[0]),Integer.valueOf(instructionArray[1])));
                    } catch (PositionOutOfRangeException e) {
                        System.out.println("Failed to create robot with worry position of placement:"+e.getMessage());
                    }
                    continue;
                }
            }else if(robot==null){
                System.out.println("Please input a position of initial placement of the toy robot to create a robot.");
                continue;
            }
            // Input MOVE
            if(_instructions.equals(MOVE) && robot!=null){
                robot.move();
            }
            // Input LEFT or RIGHT
            if(_instructions.equals(LEFT) || _instructions.equals(RIGHT)){
                robot.rotate(Rotation.valueOf(_instructions));
            }
            // Input REPORT
            if(_instructions.equals(REPORT) && robot!=null){
                robot.report();
                break;
            }
        }
    }
}
