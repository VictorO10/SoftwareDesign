// Code generated by dagger-compiler.  Do not edit.
package main.java.coffee;

import dagger.Lazy;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.Set;

/**
 * A {@code Binding<main.java.coffee.CoffeeMaker>} implementation which satisfies
 * Dagger's infrastructure requirements including:
 *
 * Owning the dependency links between {@code main.java.coffee.CoffeeMaker} and its
 * dependencies.
 *
 * Being a {@code Provider<main.java.coffee.CoffeeMaker>} and handling creation and
 * preparation of object instances.
 *
 * Being a {@code MembersInjector<main.java.coffee.CoffeeMaker>} and handling injection
 * of annotated fields.
 */
public final class CoffeeMaker$$InjectAdapter extends Binding<CoffeeMaker> {
  private Binding<Lazy<Heater>> heater;

  private Binding<Pump> pump;

  public CoffeeMaker$$InjectAdapter() {
    super("main.java.coffee.CoffeeMaker", "members/main.java.coffee.CoffeeMaker", NOT_SINGLETON, CoffeeMaker.class);
  }

  /**
   * Used internally to link bindings/providers together at run time
   * according to their dependency graph.
   */
  @Override
  @SuppressWarnings("unchecked")
  public void attach(Linker linker) {
    heater = (Binding<Lazy<Heater>>) linker.requestBinding("dagger.Lazy<main.java.coffee.Heater>", CoffeeMaker.class, getClass().getClassLoader());
    pump = (Binding<Pump>) linker.requestBinding("main.java.coffee.Pump", CoffeeMaker.class, getClass().getClassLoader());
  }

  /**
   * Used internally obtain dependency information, such as for cyclical
   * graph detection.
   */
  @Override
  public void getDependencies(Set<Binding<?>> getBindings, Set<Binding<?>> injectMembersBindings) {
    injectMembersBindings.add(heater);
    injectMembersBindings.add(pump);
  }

  /**
   * Returns the fully provisioned instance satisfying the contract for
   * {@code Provider<CoffeeMaker>}.
   */
  @Override
  public CoffeeMaker get() {
    CoffeeMaker result = new CoffeeMaker();
    injectMembers(result);
    return result;
  }

  /**
   * Injects any {@code @Inject} annotated fields in the given instance,
   * satisfying the contract for {@code Provider<CoffeeMaker>}.
   */
  @Override
  public void injectMembers(CoffeeMaker object) {
    object.heater = heater.get();
    object.pump = pump.get();
  }
}
