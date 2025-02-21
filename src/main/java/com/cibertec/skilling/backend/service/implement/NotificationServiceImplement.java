package com.cibertec.skilling.backend.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImplement {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Envía un correo electrónico simple a un destinatario especificado.
     *
     * Este método crea y envía un correo electrónico utilizando {@link SimpleMailMessage}.
     * Requiere un servidor de correo configurado en la aplicación.
     *
     * @param to Dirección de correo electrónico del destinatario.
     * @param subject Asunto del correo.
     * @param body Contenido del mensaje en formato de texto plano.
     */
    public void enviarEmail(String to, String subject, String body) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(to);
        mensaje.setSubject(subject);
        mensaje.setText(body);
        mailSender.send(mensaje);
    }
}
