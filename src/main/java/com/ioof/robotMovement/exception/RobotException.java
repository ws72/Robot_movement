package com.ioof.robotMovement.exception;

/**
 * Created by songwang on 16/6/17.
 */
public class RobotException extends Exception {
    public RobotException() {
    }

    public RobotException(String message) {
        super(message);
    }

    public RobotException(Throwable cause) {
        super(cause);
    }

    public RobotException(String message, Throwable cause) {
        super(message, cause);
    }
}
