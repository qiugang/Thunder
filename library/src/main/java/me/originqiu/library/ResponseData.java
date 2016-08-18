package me.originqiu.library;

/**
 * Created by OriginQiu on 16/8/18.
 */
public class ResponseData {
    private int code;

    private String body;

    private String message;

    public ResponseData(Builder builder) {
        this.code = builder.code;
        this.body = builder.body;
        this.message = builder.message;
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Returns true if the code is in [200..300), which means the request
     * was successfully received, understood, and accepted.
     */
    public boolean isSuccessful() {
        return code >= 200 && code < 300;
    }

    public static class Builder {
        public int code;

        public String body;

        public String message;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public ResponseData build() {
            if (code < 0)
                throw new IllegalStateException("code < 0: " + code);
            return new ResponseData(this);
        }
    }
}
