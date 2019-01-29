/*package utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendTextEmail {
public static void main(String[] args) throws EmailException{
	
System.out.println("start");
	Email email = new SimpleEmail();
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("madhawesh.rai@gmail.com", "maddy20081990"));
	// depricated
	//email.setSSLOnConnect(true);
	email.setSSL(true);
	//email.setSSL(true);
	email.setFrom("madhawesh.rai@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("madhawesh70@gmail.com");
	email.send();
	System.out.println("Mail Sent");
}

	
}
*/