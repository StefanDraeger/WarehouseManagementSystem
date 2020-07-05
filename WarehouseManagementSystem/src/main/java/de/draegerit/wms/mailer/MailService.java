package de.draegerit.wms.mailer;

import java.io.File;
import java.io.IOException;

public interface MailService  {

	void sendMail(String empfaenger, String betreff, String nachricht, File... anhaenge) throws IOException;
}
