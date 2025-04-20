package org.example.error;

public enum  Error {

    FILED_IS_NULL(400),
    ID_IS_NULL(400, "Id must not be null"),
    NOT_FOUND(400),
    USER_AGE_IS_LESS_THEN_18(400, "User age should be more then 18"),
    USER_ALREADY_VOTED(400, "User has already voted"),
    REQUEST_DTO_IS_NULL(400, "Dto must not be null")
    ;

    private int code;
    private String message;
    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    Error(int code) {
        this.code = code;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
    public void setCode(int code)
    {
        this.code = code;
    }
}
