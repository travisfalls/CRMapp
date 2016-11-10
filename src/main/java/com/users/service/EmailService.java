package com.users.service;

import java.util.Properties;

import javax.mail.Authenticator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	private static final Logger log = LoggerFactory.getLogger(EmailService.class);
	
	private String username ="";
	private String password ="";
	
	private Properties props;
	private Authenticator auth;

}
