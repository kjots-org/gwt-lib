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
package org.kjots.lib.gwt.app.client.entry;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.kjots.lib.gwt.app.client.signal.ApplicationSignals;
import org.kjots.lib.gwt.gin.client.entry.DeferredEntryPoint;
import org.kjots.lib.gwt.gin.client.entry.EntryGinjector;

import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Application Entry Point.
 * <p>
 * Created: 27th December 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@Singleton
public class ApplicationEntryPoint implements DeferredEntryPoint<EntryGinjector> {
  /** The event bus. */
  private final EventBus eventBus;
  
  /** The place history handler. */
  private final PlaceHistoryHandler placeHistoryHandler;
  
  /**
   * Construct a new Application Entry Point.
   *
   * @param placeHistoryHandler The place history handler.
   */
  @Inject
  public ApplicationEntryPoint(EventBus eventBus, PlaceHistoryHandler placeHistoryHandler) {
    this.eventBus = eventBus;
    this.placeHistoryHandler = placeHistoryHandler;
  }

  /**
   * Receive notification that the module has been loaded.
   *
   * @param ginjector The ginjector.
   */
  @Override
  public void onModuleLoad(EntryGinjector ginjector) {
    ApplicationSignals.Loaded.raise(this.eventBus);
    
    this.placeHistoryHandler.handleCurrentHistory();
    
    ApplicationSignals.Started.raise(this.eventBus);
  }
}
