package bm.it.mobile.entity;

import java.util.ArrayList;
import java.util.List;

public class ResponseTask<T> {

    public enum Status {
        SUCCESS,
        FAILURE;
    }

    private T object;

    private List<T> list;

    private String status;

    private Exception exception;

    private int httpCode;

    private String httpMessage;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public List<T> getList() {
        return list;
    }

    public ArrayList<T> getArrayList() {
        return new ArrayList<T>(list);
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(String httpMessage) {
        this.httpMessage = httpMessage;
    }
}
