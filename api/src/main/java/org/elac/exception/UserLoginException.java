package org.elac.exception;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-04 11:01
 */
public class UserLoginException extends ServiceException {

    private Integer errorTime;
    private Boolean needImageVerify;

    public UserLoginException(String message) {
        super(message);
    }

    public UserLoginException(String message, String userMessage) {
        super(message, userMessage);
    }

    public Integer getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Integer errorTime) {
        this.errorTime = errorTime;
    }

    public Boolean getNeedImageVerify() {
        return needImageVerify;
    }

    public void setNeedImageVerify(Boolean needImageVerify) {
        this.needImageVerify = needImageVerify;
    }

}