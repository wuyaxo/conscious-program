package org.elac.exception;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-04 11:00
 */
public class ServiceException extends RuntimeException {

    private String userMessage;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, String userMessage) {
        super(message);
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}