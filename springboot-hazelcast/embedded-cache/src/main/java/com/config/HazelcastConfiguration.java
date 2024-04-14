package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class HazelcastConfiguration {

  private static final String INSTANCE_NAME = "hazelcast-instance";

  @Bean
  public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
    return Hazelcast.newHazelcastInstance(hazelCastConfig);
  }

  @Bean
  public Config hazelCastConfig() {
    Config hazelCastConfig = new Config();
    hazelCastConfig.setInstanceName(INSTANCE_NAME);

    MapConfig mapConfig = new MapConfig(Caches.DEFAULT_CACHE_NAME);
    mapConfig.setTimeToLiveSeconds(360);
    mapConfig.setMaxIdleSeconds(20);
    hazelCastConfig.addMapConfig(mapConfig);

    return hazelCastConfig;
  }

}
