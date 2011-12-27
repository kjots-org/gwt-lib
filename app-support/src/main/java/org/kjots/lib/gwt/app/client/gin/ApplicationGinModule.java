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
package org.kjots.lib.gwt.app.client.gin;

import javax.inject.Singleton;

import org.kjots.lib.gwt.app.client.activity.ApplicationActivityManager;
import org.kjots.lib.gwt.app.client.entry.ApplicationEntryPoint;
import org.kjots.lib.gwt.app.client.place.DefaultPlace;
import org.kjots.lib.gwt.gin.client.entry.DeferredEntryGinModule;
import org.kjots.lib.gwt.gin.client.entry.DeferredEntryPoint;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Application Gin Module.
 * <p>
 * Created: 27th December 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public abstract class ApplicationGinModule extends DeferredEntryGinModule {
  /** The place history mapper class. */
  private final Class<? extends PlaceHistoryMapper> placeHistoryMapperClass;
  
  /** The activity mapper class. */
  private final Class<? extends ActivityMapper> activityMapperClass;
  
  /** The default place class. */
  private final Class<? extends Place> defaultPlaceClass;
  
  /**
   * Provide the place controller.
   *
   * @param eventBus The event bus.
   * @return The place controller.
   */
  @Provides
  @Singleton
  public PlaceController providePlaceController(EventBus eventBus) {
    return new PlaceController(eventBus);
  }
  
  /**
   * Provide the place history handler.
   *
   * @param placeHistoryMapper The place history mapper.
   * @param eventBus The event bus.
   * @param placeController The place controller.
   * @param defaultPlace The default place.
   * @return The place history handler.
   */
  @Provides
  @Singleton
  public PlaceHistoryHandler providePlaceHistoryHandler(PlaceHistoryMapper placeHistoryMapper, EventBus eventBus, PlaceController placeController, @DefaultPlace Place defaultPlace) {
    PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(placeHistoryMapper);
    
    placeHistoryHandler.register(placeController, eventBus, defaultPlace);
    
    return placeHistoryHandler;
  }
  
  /**
   * Construct a new Application Gin Module.
   *
   * @param placeHistoryMapperClass The place history mapper class.
   * @param activityMapperClass The activity mapper class.
   * @param defaultPlaceClass The default place class.
   */
  public ApplicationGinModule(Class<? extends PlaceHistoryMapper> placeHistoryMapperClass, Class<? extends ActivityMapper> activityMapperClass, Class<? extends Place> defaultPlaceClass) {
    this.placeHistoryMapperClass = placeHistoryMapperClass;
    this.activityMapperClass = activityMapperClass;
    this.defaultPlaceClass = defaultPlaceClass;
  }

  /**
   * Configure the module.
   */
  @Override
  protected void configure() {
    bind(DeferredEntryPoint.class).to(ApplicationEntryPoint.class);
    bind(ActivityManager.class).to(ApplicationActivityManager.class).asEagerSingleton();
    bind(ActivityMapper.class).to(this.activityMapperClass).in(Singleton.class);
    bind(PlaceHistoryMapper.class).to(this.placeHistoryMapperClass).in(Singleton.class);
    bind(Place.class).annotatedWith(DefaultPlace.class).to(this.defaultPlaceClass);
  }
}
