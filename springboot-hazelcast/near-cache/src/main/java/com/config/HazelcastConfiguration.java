package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.NearCacheConfig;
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
    clientConfig.getNetworkConfig().addAddress(clusterAddress);
    clientConfig.setClusterName(clusterName);

    // <Near Cache
    NearCacheConfig nearCacheConfig = new NearCacheConfig();
    nearCacheConfig.setName(Caches.CACHE_NAME);
    nearCacheConfig.setTimeToLiveSeconds(300);
    nearCacheConfig.setMaxIdleSeconds(60);
    
    // If you want to test, if it's working, set it to false and remove cache entry from the cluster
    // Requests will be serve from near cache until the entry is evicted
    nearCacheConfig.setInvalidateOnChange(true);

    EvictionConfig evictionConfig = new EvictionConfig();
    evictionConfig.setSize(1000);
    evictionConfig.setMaxSizePolicy(EvictionConfig.DEFAULT_MAX_SIZE_POLICY);
    evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
    nearCacheConfig.setEvictionConfig(evictionConfig);
    // Near Cache>

    clientConfig.addNearCacheConfig(nearCacheConfig);

    return clientConfig;
  }

  @Bean
  public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
    return HazelcastClient.newHazelcastClient(clientConfig);
  }

}
