/* 
 * Copyright © 2011 Karl J. Ots <kjots@kjots.org>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kjots.lib.gwt.gin.client.entry;

import org.kjots.lib.gwt.gin.client.GinEntryGwtTestBase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.inject.Provides;

/**
 * Entry Gin Module Test.
 * <p>
 * Created: 25th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class EntryGinModuleTest extends GinEntryGwtTestBase {
  /**
   * Test Entry Ginjector.
   */
  @GinModules(TestEntryGinModule.class)
  public interface TestEntryGinjector extends EntryGinjector {
  }
  
  /**
   * Test Entry Ginjector Factory.
   */
  public static class TestEntryGinjectorFactory implements EntryGinjectorFactory {
    /**
     * Create the entry ginjector.
     *
     * @return The entry ginjector.
     */
    @Override
    public EntryGinjector createEntryGinjector() {
      return GWT.create(TestEntryGinjector.class);
    }
  }
  
  /**
   * Test Entry Gin Module.
   */
  public static class TestEntryGinModule extends EntryGinModule {
    /**
     * Configure the module.
     */
    @Override
    protected void configure() {
    }
    
    /**
     * Provide the entry point.
     *
     * @return The entry point.
     */
    @Provides
    @SuppressWarnings("rawtypes")
    protected EntryPoint provideEntryPoint() {
      return EntryGinModuleTest.testEntryPoint;
    }
  }
  
  /**
   * Test Entry Point.
   */
  public static class TestEntryPoint extends EntryPoint<TestEntryGinjector> {
    /** The onModuleLoad() invoked flag. */
    private boolean onModuleLoadInvoked = false;
    
    /**
     * Receive notification that the module has been loaded.
     */
    @Override
    public void onModuleLoad() {
      onModuleLoadInvoked = true;
    }
  }
  
  /** The test entry point. */
  private static TestEntryPoint testEntryPoint;
  
  /**
   * Test the Bootstrap Entry Point.
   */
  public void testBootstrapEntryPoint() {
    new EntryGinModule.BootstrapEntryPoint().onModuleLoad();
    
    assertNotNull(testEntryPoint.ginjector);
    assertTrue(testEntryPoint.ginjector instanceof TestEntryGinjector);
    assertTrue(testEntryPoint.onModuleLoadInvoked);
  }
  
  /**
   * Setup the GWT test case.
   */
  @Override
  protected void gwtSetUp() {
    testEntryPoint = new TestEntryPoint();
  }

  /**
   * Tear down the GWT test case.
   */
  @Override
  protected void gwtTearDown() {
    testEntryPoint = null;
  }
}
