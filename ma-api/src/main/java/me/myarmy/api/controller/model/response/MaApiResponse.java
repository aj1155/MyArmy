package me.myarmy.api.controller.model.response;

/**
 * Created by Manki Kim on 2017-02-23.
 */
public class MaApiResponse<T> {
    //Common
    public static final Integer OK = 200;

    public static final Integer INVALID_USERPASSWORD = 1002;
    public static final Integer INVALID_COOKIE = 1003;
    public static final Integer DUPLICATE_PATH = 1004;

    public static final Integer EXCEPTION = 3001;
    public static final Integer NOT_FOUND = 3002;
    public static final Integer INVALID_STATUS = 3003;

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private Integer code;
    private T result;

    public MaApiResponse() {
        this.code = OK;
    }

    public MaApiResponse(Integer code) {
        this.code = code;
    }

    public MaApiResponse(T result) {
        this.code = OK;
        this.result = result;
    }

    public MaApiResponse(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public T getResult() {
        return result;
    }
}
