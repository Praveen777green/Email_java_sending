import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {
        // Recipient's email
        String to = "govindafinch7@gmail.com";

        // Sender's email
        String from = "praveen.kumar_becse22@avit.ac.in";
        final String username = "praveen.kumar_becse22@avit.ac.in"; // Change accordingly
        final String password = "Pkumar2005@"; // Change accordingly

        // SMTP server details
        String host = "smtp.gmail.com"; // Change for other providers

        // Properties settings
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // Creating a session
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("stock market lover");
            message.setText("Hello, this is a test email sent using Jakarta Mail API.");

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


// to run code================
// javac -cp "lib/*" -d . src/EmailSender.java
// java -cp ".;lib/*" EmailSender