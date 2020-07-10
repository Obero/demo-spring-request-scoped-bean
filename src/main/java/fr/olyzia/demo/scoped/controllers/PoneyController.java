package fr.olyzia.demo.scoped.controllers;

import fr.olyzia.demo.scoped.contexts.PoneyContext;
import fr.olyzia.demo.scoped.models.PoneyDto;
import fr.olyzia.demo.scoped.services.PoneyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Provider;

@RestController
@RequestMapping("/poneys")
@AllArgsConstructor
@Slf4j
public class PoneyController {

  private final Provider<PoneyContext> poneyContextProvider;
  private final PoneyService poneyService;

  @GetMapping("/{cute}")
  public PoneyDto getCuteOrNot(@PathVariable boolean cute) {
    if (cute) {
      return this.getCute();
    } else {
      return this.getLame();
    }
  }

  @GetMapping("/cute")
  public PoneyDto getCute() {
    PoneyContext poneyContext = this.poneyContextProvider.get();
    poneyContext.setCute(true);

    log.debug(String.format("Controller context value: %s", poneyContext.toString()));

    return this.poneyService.buildFromContext();
  }

  @GetMapping("/lame")
  public PoneyDto getLame() {
    PoneyContext poneyContext = this.poneyContextProvider.get();
    poneyContext.setCute(false);

    log.debug(String.format("Controller context value: %s", poneyContext.toString()));

    return this.poneyService.buildFromContext();
  }
}
