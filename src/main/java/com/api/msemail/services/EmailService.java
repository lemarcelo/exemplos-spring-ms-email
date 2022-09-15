package com.api.msemail.services;

import com.api.msemail.models.EmailModel;
import com.api.msemail.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    public void emailSendEmail(EmailModel emailModel) {

    }
}
