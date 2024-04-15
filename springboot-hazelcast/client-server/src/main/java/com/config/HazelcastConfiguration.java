package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class HazelcastConfiguration {

  @Value("${hazelcast.client.address}")
  private String clusterAddress;

  @Value("${hazelcast.client.cluster-name}")
  private String clusterName;

  @Bean
  public ClientConfig hazelcastClientConfig() {
    ClientConfig clientConfig = new ClientConfig();
    String[] addresses = clusterAddress.split(",");
    for (String address : addresses) {
      clientConfig.getNetworkConfig().addAddress(address.trim());
    }
    clientConfig.setClusterName(clusterName);
    return clientConfig;
  }

  @Bean
  public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
    return HazelcastClient.newHazelcastClient(clientConfig);
  }

}
