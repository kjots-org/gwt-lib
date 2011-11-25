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

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;

/**
 * Entry Gin Module.
 * <p>
 * Created: 25th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public abstract class EntryGinModule extends AbstractGinModule {
  /**
   * Bootstrap Entry Point.
   */
  public static class BootstrapEntryPoint implements com.google.gwt.core.client.EntryPoint {
    /**
     * Receive notification that the module has been loaded.
     */
    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public final void onModuleLoad() {
      EntryGinjectorFactory entryGinjectorFactory = GWT.create(EntryGinjectorFactory.class);
      EntryGinjector entryGinjector = entryGinjectorFactory.createEntryGinjector();
      EntryPoint entryPoint = entryGinjector.getEntryPoint();
      
      entryPoint.ginjector = entryGinjector;
      
      entryPoint.onModuleLoad();
    }
  }
}
