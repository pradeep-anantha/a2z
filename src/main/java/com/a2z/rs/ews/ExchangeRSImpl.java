package com.a2z.rs.ews;

import javax.ws.rs.core.Response;

import com.a2z.core.ews.EWSManager;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.MessageBody;

public class ExchangeRSImpl implements ExchangeRS{
	
	private EWSManager ewsManager;

	public EWSManager getEwsManager() {
		return ewsManager;
	}

	public void setEwsManager(EWSManager ewsManager) {
		this.ewsManager = ewsManager;
	}

	public Response sendTestEmail() {
		ExchangeService exchangeService = ewsManager.getExchangeService();
		try {
			EmailMessage message = new EmailMessage(exchangeService);
			
			message.setSubject("Test EWS API");
			message.setBody(new MessageBody("Test EWS API - Message Body"));
			message.getToRecipients().add(new EmailAddress("apr943@gmail.com"));
			
			message.sendAndSaveCopy();
			System.out.println("Email sent successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
