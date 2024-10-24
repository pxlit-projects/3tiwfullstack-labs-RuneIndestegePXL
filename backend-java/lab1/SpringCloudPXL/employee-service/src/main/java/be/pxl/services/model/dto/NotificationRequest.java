package be.pxl.services.model.dto;

public class NotificationRequest {
    private String message;
    private String sender;

    public NotificationRequest() {
    }

    public NotificationRequest(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}
