package redis.template.exception;

public class RedisException extends RuntimeException{
    private static final long serialVersionUID = 9150947297211556907L;

    public RedisException() {
        super();
    }

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedisException(String message) {
        super(message);
    }

    public RedisException(Throwable cause) {
        super(cause);
    }

}
