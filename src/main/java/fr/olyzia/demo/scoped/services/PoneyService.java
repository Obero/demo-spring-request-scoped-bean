package fr.olyzia.demo.scoped.services;

import fr.olyzia.demo.scoped.contexts.PoneyContext;
import fr.olyzia.demo.scoped.models.CuteLevelDto;
import fr.olyzia.demo.scoped.models.PoneyDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.inject.Provider;

@Service
@AllArgsConstructor
@Slf4j
public class PoneyService {
  private final Provider<PoneyContext> poneyContextProvider;

  public PoneyDto buildFromContext() {
    PoneyContext poneyContext = this.poneyContextProvider.get();

    log.debug(String.format("Service context value: %s", poneyContext.toString()));

    if (poneyContext.isCute()) {
      return this.buildCuteOne();
    } else {
      return this.buildLameOne();
    }
  }

  private PoneyDto buildCuteOne() {
    CuteLevelDto cuteLevelDto = CuteLevelDto.builder().toutGris(true).toutPetit(true).build();

    return PoneyDto.builder().name("*** John Bobby Ewing ***").cuteLevelDto(cuteLevelDto).build();
  }

  private PoneyDto buildLameOne() {
    CuteLevelDto cuteLevelDto = CuteLevelDto.builder().build();

    return PoneyDto.builder().name("JeAn KeViN").cuteLevelDto(cuteLevelDto).build();
  }
}
