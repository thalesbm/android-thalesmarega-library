package bm.it.mobile.entity;

import java.util.ArrayList;
import java.util.List;

public class ResponseTask<T> {

    public enum TaskStatus {
        SUCCESS(1),
        FAILURE(2);

        TaskStatus(int value) {
            this.value = value;
        }

        private int value;
        public int getValue() {
            return value;
        }
    }

    private T object;

    private List<T> list;

    private int status;

    private Exception exception;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
}
