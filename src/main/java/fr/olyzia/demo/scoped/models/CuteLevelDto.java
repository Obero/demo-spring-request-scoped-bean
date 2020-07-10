package fr.olyzia.demo.scoped.models;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder(toBuilder = true)
public class CuteLevelDto {
  boolean toutGris;
  boolean toutPetit;
}
