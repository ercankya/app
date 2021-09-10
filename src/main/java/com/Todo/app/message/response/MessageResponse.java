package com.Todo.app.message.response;

public class MessageResponse {
        String message;

    public MessageResponse(String s) {
        this.message=s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
