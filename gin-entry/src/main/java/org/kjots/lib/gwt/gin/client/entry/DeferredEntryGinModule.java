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

import javax.inject.Provider;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.inject.Provides;

/**
 * Deferred Entry Gin Module.
 * <p>
 * Created: 25th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public abstract class DeferredEntryGinModule extends EntryGinModule {
  /**
   * Provide the entry point.
   *
   * @param deferredEntryPointProvider The deferred entry point provider.
   * @return The entry point.
   */
  @Provides
  @SuppressWarnings({ "rawtypes", "unchecked" })
  protected final EntryPoint provideEntryPoint(final Provider<DeferredEntryPoint> deferredEntryPointProvider) {
    return new EntryPoint() {
      @Override
      public void onModuleLoad(final EntryGinjector ginjector) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
          @Override
          public void execute() {
            deferredEntryPointProvider.get().onModuleLoad(ginjector);
          }
        });
      }
    };
  }
}
