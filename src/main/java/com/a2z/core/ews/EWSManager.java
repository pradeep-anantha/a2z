package com.a2z.core.ews;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ConnectingIdType;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.misc.ImpersonatedUserId;

public class EWSManager {
	
	private ExchangeService exchangeService;
	
	private EWSConfiguration configuration;
	
	public ExchangeService getExchangeService() {
		return exchangeService;
	}
	
	public ExchangeService getImpersonatedExchangeService(String userId) throws URISyntaxException {
		
		ImpersonatedUserId impersonatedUserId = new ImpersonatedUserId(ConnectingIdType.SmtpAddress, userId);
		ExchangeService impersonatedExchangeService = getExchangeService(configuration);
		impersonatedExchangeService.setImpersonatedUserId(impersonatedUserId);
		
		return impersonatedExchangeService;
	}

	@PostConstruct
	private void init() throws URISyntaxException {
		
		EWSConfiguration configuration = new EWSConfiguration();
		configuration.setEWSUrl("https://www.outlook.com/EWS/Exchange.asmx");
		configuration.setUserName("XXXXXXXXXXXXXXXXXX@outlook.com");
		configuration.setPassword("XXXXXXXXXXXXXXXXXXXX");
		this.configuration = configuration;
		
		this.exchangeService = getExchangeService(this.configuration);
	}
	
	public ExchangeService getExchangeService(EWSConfiguration config) throws URISyntaxException{
		ExchangeService service = new ExchangeService();
		ExchangeCredentials credentials = null;
		
		if(StringUtils.isNotBlank(config.getDomain())){
			credentials = new WebCredentials(config.getUserName(), config.getPassword(), config.getDomain());
		}else{
			credentials = new WebCredentials(config.getUserName(), config.getPassword());
		}
		
		service.setCredentials(credentials);
		service.setUrl(new URI(config.getEWSUrl()));
		
		return service;
	}

}
