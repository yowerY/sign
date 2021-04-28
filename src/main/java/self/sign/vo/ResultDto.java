package self.sign.vo;

import java.io.Serializable;


public class ResultDto<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String code = "200";
    protected String message = "OK";
    protected String url;
    protected T data;

    public ResultDto() {
    }

    public ResultDto(T data) {
        this.data = data;
    }
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
