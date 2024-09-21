package be.pxl.services.controller;

import be.pxl.services.repository.NotificationRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationRepository _notificationRepository;

    public NotificationController(NotificationRepository notificationRepository){
        this._notificationRepository = notificationRepository;
    }
}
