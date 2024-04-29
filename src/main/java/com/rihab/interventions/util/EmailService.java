package com.rihab.interventions.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EmailService implements EmailSender{
 private final JavaMailSender mailSender;
 
 @Override
 public void sendEmail(String toEmail, String body) {
     try {
         MimeMessage mimeMessage = mailSender.createMimeMessage();
         MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
         helper.setText(body, true);
         helper.setTo(toEmail);
         helper.setSubject("Informations d'inscription");
         helper.setFrom("zouaouirihab03@gmail.com"); // Mettez votre adresse e-mail ici
         mailSender.send(mimeMessage);
     } catch (MessagingException e) {
         throw new IllegalStateException("Échec de l'envoi de l'e-mail");
     }
}
 /*
 public void sendNewTicketEmail(String recipient, String ticketTitle) {
     SimpleMailMessage message = new SimpleMailMessage();
     message.setTo(recipient);
     message.setSubject("Nouveau ticket a été créé");
     message.setText("Un nouveau ticket a été créé avec le titre : " + ticketTitle);
     mailSender.send(message);
 }
 */
 public void sendNewTicketEmail(String toEmail, String clientName, String ticketDesignation) {
	    try {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
	        String body = "Un nouveau ticket a été créé par  : <b>  " + clientName + " </b> avec le titre : <b>  " + ticketDesignation + " </b> ";
	        helper.setText(body, true); // Indique que le texte est du HTML
	        helper.setTo(toEmail);
	        helper.setSubject("Vous avez été affecté à un nouveau ticket"); // Titre spécifique pour les nouveaux tickets
	        mailSender.send(mimeMessage);
	    } catch (MessagingException e) {
	        throw new IllegalStateException("Échec de l'envoi de l'e-mail");
	    }
	}

 
}