package ru.spring.ex3sem3home.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistartionService {

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;
}
