package com.a2z.rs.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

public class ElasticServiceManager {
	
	private ESConfiguration configuration;
	
	private Client client;
	
	public Client getClient() {
		return client;
	}

	@PostConstruct
	public void init() throws UnknownHostException {
		ESConfiguration configuration = new ESConfiguration();
		configuration.setClusterName("c_a2z_es550");
		configuration.setHostName("localhost");
		configuration.setTcpPort(9300);
		configuration.setUserName("elastic");
		configuration.setPassword("changeme");

		this.configuration = configuration;
		this.client = createClient(this.configuration);
	}
	
	@SuppressWarnings({ "resource", "unchecked" })
	public Client createClient(ESConfiguration configuration) throws UnknownHostException{		
		String hostName = configuration.getHostName();
		String[] hosts = hostName.split(",");
		InetSocketTransportAddress[] ISTAddresses = new InetSocketTransportAddress[hosts.length];		
		for (int i = 0; i < hosts.length; i++) {
			ISTAddresses[i] = new InetSocketTransportAddress(InetAddress.getByName(hosts[i]), configuration.getTcpPort());
		}		
		Settings settings = Settings.builder()
				.put("client.transport.ping_timeout", "300s")
				.put("client.transport.nodes_sampler_interval","5s")
				.put("client.transport.sniff", true)
				.put("cluster.name", configuration.getClusterName())
				.put("xpack.security.user", configuration.getUserName()+":"+configuration.getPassword())
				.build();
		
		TransportClient clients = new PreBuiltXPackTransportClient(settings).addTransportAddresses(ISTAddresses);		
		return clients;
	}

}
