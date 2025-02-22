## Uso de Templates para Pruebas de Carga

En la sección de templates, se pueden utilizar archivos CSV para realizar pruebas de carga y evaluar el rendimiento del servicio de la entidad LIBROS.

## Configuración de SMTP en Spring Boot

Para habilitar el envío de correos electrónicos en tu aplicación Spring Boot, configura el servicio SMTP en tu archivo `application.properties` o `application.yml`.

### Configuración en `application.properties`
```properties
# Configuración de SMTP
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=tu_correo@gmail.com
spring.mail.password=tu_contraseña_de_aplicación
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
### Importante
- **Usar una contraseña de aplicación**: Google ya no permite el uso de contraseñas de cuentas personales. Debes generar una [contraseña de aplicación](https://myaccount.google.com/apppasswords).
- **Habilitar acceso a aplicaciones menos seguras**: Asegúrate de que tu cuenta permite el acceso a aplicaciones de terceros.
- **Verificar la configuración de seguridad**: En algunos casos, Gmail puede bloquear el acceso. Revisa la configuración en [Google Security](https://myaccount.google.com/security).

### Dependencia de Spring Boot
Si aún no has agregado la dependencia en tu `pom.xml`, inclúyela:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```
