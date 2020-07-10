package fr.olyzia.demo.scoped.contexts;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class PoneyContext {
  public boolean cute;
}
