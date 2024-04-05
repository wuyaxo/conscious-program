package org.elac.common;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-04 10:58
 */

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.elac.exception.ServiceException;
import org.elac.exception.UserLoginException;

/**
 * <p>
 *
 * @description: Result
 * </p>
 * @author: David
 * @create: 2022-09-15 03:14
 */
@Slf4j
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4483991136984030939L;
    private int code;
    private String msg;
    private T data;
    private String userMsg;
    private String userMsgFr;
    private boolean success = true;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * success
     */
    public static final int SUCCESS = 0;
    /**
     * Authentication fails. You need to log in
     */
    public static final int UN_LOGIN = 1000;

    /**
     * Dangerous characters exist
     */
    public static final int DANGER_CHAR = 1001;
    /**
     * login failed
     */
    public static final int LOGIN_FAILED = 1003;

    /**
     * Permission verification fails.
     */
    public static final int PERMISSION_FAIL = 1006;

    /**
     * Account verification required
     */
    public static final int NEED_VERIFY = 1007;

    /**
     * Parameter verification fails.
     */
    public static final int PARAM_VALIDATE_FAILED = 2000;

    /**
     * Parameter error
     */
    public static final int PARAM_ERROR = 2001;

    /**
     * no data temporarily
     */
    public static final int NO_DATA = 2002;

    /**
     * Internal error
     */
    public static final int SERVER_ERROR = 5000;

    /**
     * call interface returns null
     */
    public static final int SERVER_RETURN_NULL = 2002;

    /**
     * Error calling WebService
     */
    public static final int WEBSERVER_ERROR = 5001;

    /**
     * Error invoking the service
     */
    public static final int RETURN_ERROR = 2003;

    /**
     * file does not exist
     */
    public static final int DATA_NOT_EXIST = 2004;

    /**
     * The file  uploaded is larger than what your plan supports
     */
    public static final int FILE_TOO_LARGE = 2005;

    public <T> Result() {
        this.code = 0;
        this.userMsg = "success";
    }

    public Result(T data) {
        this.code = 0;
        this.userMsg = "success";
        this.data = data;
    }

    public <T> Result(int code, String userMsg) {
        this.code = code;
        this.userMsg = userMsg;
        this.msg = userMsg;
        if (code != SUCCESS) {
            this.success = false;
        }
    }

    public <T> Result(int code, String msg, String userMsg) {
        this.code = code;
        this.msg = msg;
        this.userMsg = userMsg;
        if (code != SUCCESS) {
            this.success = false;
        }
    }

    public Result(int code, String msg, String userMsg, T data) {
        this.code = code;
        this.msg = msg;
        this.userMsg = userMsg;
        this.data = data;
    }

    public <T> Result(int code, String msg, String userMsg, String msgFr) {
        this.code = code;
        this.msg = msg;
        this.userMsg = userMsg;
        this.userMsgFr = msgFr;
        if (code != SUCCESS) {
            this.success = false;
        }
    }

    public Result(int code, String msg, String userMsg, String msgFr, T data) {
        this.code = code;
        this.msg = msg;
        this.userMsg = userMsg;
        this.userMsgFr = msgFr;
        this.data = data;
    }

    public static <T> Result<T> error() {
        return error("Unknown exception, please contact administrator");
    }

    public static <T> Result<T> error(String userMsg) {
        return error(SERVER_ERROR, userMsg);
    }

    public static <T> Result<T> error(int code, String userMsg) {
        return new Result<T>(code, "error", userMsg);
    }

    public static <T> Result<T> error(String msg, String userMsg) {
        return new Result<T>(SERVER_ERROR, msg, userMsg);
    }

    public static <T> Result<T> error(int code, String msg, String userMsg) {
        return new Result<T>(code, msg, userMsg);
    }

    public static <T> Result<T> success(String userMsg) {
        return new Result<T>(SUCCESS, userMsg);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> success(String userMsg, T data) {
        Result<T> r = new Result<T>(data);
        r.setUserMsg(userMsg);
        return r;
    }

    public static <T> Result<T> noData() {
        return new Result<T>(NO_DATA, "No data was obtained");
    }

    public static <T> Result<T> unLogin() {
        return new Result<T>(UN_LOGIN, "Please log in and try again");
    }

    public static <T> Result<T> paramError(String msg, String userMsg) {
        return new Result<>(PARAM_ERROR, msg, userMsg);
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public String getUserMsg() {
        return this.userMsg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }

    public static <T> Result<T> loginFailed(String msg, String userMsg, T t) {
        return new Result<>(Result.LOGIN_FAILED, msg, userMsg, t);
    }

    public static <T> Result<T> consume(Supplier<T> supplier) {
        return Result.success(supplier.get());
    }

    public static <T, R> Result<R> consume(T t, Function<T, R> function) {
        try {
            R result = function.apply(t);
            return new Result<>(Result.SUCCESS, "success", "ok", result);
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.SERVER_ERROR, "Null pointer exception", "Server Exception", null);
        } catch (UserLoginException e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.UN_LOGIN, e.getMessage(),
                    StringUtils.isBlank(e.getUserMessage()) ? e.getMessage() : e.getUserMessage(), null);
        } catch (ServiceException e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.RETURN_ERROR, e.getMessage(),
                    StringUtils.isBlank(e.getUserMessage()) ? e.getMessage() : e.getUserMessage(), null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.SERVER_ERROR, e.getMessage(), e.getMessage(), null);
        }
    }
}