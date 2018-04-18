// Code generated by dagger-compiler.  Do not edit.
package main.java.coffee;

import dagger.internal.BindingsGroup;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * A manager of modules and provides adapters allowing for proper linking and
 * instance provision of types served by {@code @dagger.Provides} methods.
 */
public final class DripCoffeeModule$$ModuleAdapter extends ModuleAdapter<DripCoffeeModule> {
  private static final String[] INJECTS = { "members/main.java.coffee.CoffeeApp", };

  private static final Class<?>[] STATIC_INJECTIONS = { };

  private static final Class<?>[] INCLUDES = { PumpModule.class, };

  public DripCoffeeModule$$ModuleAdapter() {
    super(DripCoffeeModule.class, INJECTS, STATIC_INJECTIONS, false /*overrides*/, INCLUDES, true /*complete*/, false /*library*/);
  }

  @Override
  public DripCoffeeModule newModule() {
    return new DripCoffeeModule();
  }

  /**
   * Used internally obtain dependency information, such as for cyclical
   * graph detection.
   */
  @Override
  public void getBindings(BindingsGroup bindings, DripCoffeeModule module) {
    bindings.contributeProvidesBinding("main.java.coffee.Heater", new ProvideHeaterProvidesAdapter(module));
  }

  /**
   * A {@code Binding<Heater>} implementation which satisfies
   * Dagger's infrastructure requirements including:
   *
   * Being a {@code Provider<Heater>} and handling creation and
   * preparation of object instances.
   */
  public static final class ProvideHeaterProvidesAdapter extends ProvidesBinding<Heater> {
    private final DripCoffeeModule module;

    public ProvideHeaterProvidesAdapter(DripCoffeeModule module) {
      super("main.java.coffee.Heater", IS_SINGLETON, "main.java.coffee.DripCoffeeModule", "provideHeater");
      this.module = module;
      setLibrary(false);
    }

    /**
     * Returns the fully provisioned instance satisfying the contract for
     * {@code Provider<Heater>}.
     */
    @Override
    public Heater get() {
      return module.provideHeater();
    }
  }
}