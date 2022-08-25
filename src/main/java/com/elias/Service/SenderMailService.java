package com.elias.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SenderMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar(String novoemail, String conteudo, String titulo) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(novoemail);
        email.setSubject(titulo);
        email.setText(conteudo);
        mailSender.send(email);
    }


}
