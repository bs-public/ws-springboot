package com;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class SseService {

  private final static Logger LOGGER = LoggerFactory.getLogger(SseService.class);

  private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

  public void addEmitter(SseEmitter emitter) {
    emitters.add(emitter);
    emitter.onCompletion(() -> emitters.remove(emitter));
    emitter.onTimeout(() -> emitters.remove(emitter));
  }

  @Scheduled(fixedRate = 1000)
  public void sendEvents() {
    for (SseEmitter emitter : emitters) {
      LOGGER.info("Sending a event: {}", emitter.toString());
      try {
        emitter.send(System.currentTimeMillis());
      } catch (IOException e) {
        emitter.complete();
        emitters.remove(emitter);
      }
    }
  }

}
