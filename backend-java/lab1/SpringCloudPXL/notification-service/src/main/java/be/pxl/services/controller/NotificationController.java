package be.pxl.services.controller;

import be.pxl.services.domain.Notification;
import be.pxl.services.repository.NotificationRepository;
import be.pxl.services.services.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService _notificationService;
    public NotificationController(NotificationService notificationService){
        this._notificationService = notificationService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMessage(@RequestBody Notification notification){
        _notificationService.sendMessage(notification);
    }
}
