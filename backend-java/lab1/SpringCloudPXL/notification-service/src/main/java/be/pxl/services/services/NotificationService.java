package be.pxl.services.services;

import be.pxl.services.domain.Notification;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotificationService implements INotifivationService{
    private static final Logger logger = Logger.getLogger(NotificationService.class.getName());

    public void sendMessage(Notification notification) {
        logger.info("Sending notification from: " + notification.getSender() + " with message: " + notification.getMessage());

    }
}
