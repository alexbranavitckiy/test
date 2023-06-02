package org.example.error;


import lombok.Getter;

@Getter
public class NotFoundError extends Exception {

    private final String message;

    public NotFoundError(String message) {
        super(message);
        this.message = message;
    }


}
