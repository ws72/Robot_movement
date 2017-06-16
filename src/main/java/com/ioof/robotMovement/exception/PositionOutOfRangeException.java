package com.ioof.robotMovement.exception;

/**
 * Created by songwang on 16/6/17.
 */
public class PositionOutOfRangeException extends RobotException{

    public PositionOutOfRangeException() {
    }

    public PositionOutOfRangeException(String message) {
        super(message);
    }

    public PositionOutOfRangeException(Throwable cause) {
        super(cause);
    }

    public PositionOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
