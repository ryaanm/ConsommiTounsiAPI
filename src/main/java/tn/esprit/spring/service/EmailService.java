package tn.esprit.spring.service;

public interface EmailService {
	
	public void sendSimpleMessage(
		      String to, String subject, String text);

}