package de.draegerit.wms;

import de.draegerit.wms.mailer.MailService;
import de.draegerit.wms.mailer.MailServiceImpl;

public class ServiceFactory {

	private static MailService mailService;

	public static MailService getMailService() {
		if (mailService == null) {
			mailService = new MailServiceImpl();
		}
		return mailService;
	}

}
