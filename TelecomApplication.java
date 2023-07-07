package com.telecom.telecom;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class TelecomApplication {
	private static final Logger logger = LoggerFactory.getLogger(TelecomApplication.class);
	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(TelecomApplication.class, args);
		
		  //code to log sensitive information in logging file in hexadecimal format instead of plain text.
		  String message = "This is a sensitive message.";
	        
	        // Compute the SHA-256 hash of the message
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] digest = md.digest(message.getBytes());
	        //System.out.println("Message in Bytes: "+digest);
	        String digestHex = bytesToHex(digest);
	        
	        // Log the digest instead of the message
	        logger.info("Message digest: " + digestHex);
	        System.out.println("Message digest: "+digestHex);  
	}
	private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
