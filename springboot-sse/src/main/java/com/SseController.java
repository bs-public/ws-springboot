package com;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseController {

  private final SseService sseService;

  public SseController(SseService sseService) {
    this.sseService = sseService;
  }

  @GetMapping(path = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribe() {
    SseEmitter emitter = new SseEmitter();
    sseService.addEmitter(emitter);
    return emitter;
  }

}
