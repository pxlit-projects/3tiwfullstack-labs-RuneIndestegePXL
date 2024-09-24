package be.pxl.services.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String to;
    private String from;
    private String subject;
    private String message;


}
