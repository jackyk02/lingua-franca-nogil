/*
 * generated by Xtext 2.28.0
 */

package org.lflang.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.lflang.LFRuntimeModule;
import org.lflang.LFStandaloneSetup;

/**
 * Note: this is a copy of a file generated by XText. The main modification is to make this a {@link
 * Singleton}. This is because XText initialization relies on global static fields, and concurrent
 * test class initialization may not work properly. This modified version also does not implement
 * {@link org.eclipse.xtext.testing.IRegistryConfigurator}, which would have cleaned up the registry
 * in a non-deterministic way. The global XText state is thus shared by all concurrent tests and
 * initialized exactly once.
 */
@Singleton
public class LFInjectorProvider implements IInjectorProvider {

  protected volatile Injector injector;

  @Override
  public Injector getInjector() {
    if (injector == null) {
      synchronized (this) {
        if (injector == null) {
          GlobalRegistries.initializeDefaults();
          this.injector = internalCreateInjector();
        }
      }
    }
    return injector;
  }

  protected Injector internalCreateInjector() {
    return new LFStandaloneSetup() {
      @Override
      public Injector createInjector() {
        return Guice.createInjector(createRuntimeModule());
      }
    }.createInjectorAndDoEMFRegistration();
  }

  protected LFRuntimeModule createRuntimeModule() {
    // make it work also with Maven/Tycho and OSGI
    // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=493672
    return new LFRuntimeModule() {
      @Override
      public ClassLoader bindClassLoaderToInstance() {
        return LFInjectorProvider.class.getClassLoader();
      }
    };
  }
}
