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
package org.kjots.lib.gwt.event.signal.shared;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Signal.
 * <p>
 * Created: 16th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class Signal extends GwtEvent.Type<SignalHandler> {
  /** The name of the signal. */
  private final String name;
  
  /**
   * Construct a new Signal.
   *
   * @param name The name of the signal.
   */
  public Signal(String name) {
    this.name = name;
  }
  
  /**
   * Retrieve the name of the signal.
   *
   * @return The name of the signal.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Raise the signal on the given event hub.
   *
   * @param eventBus The event bus.
   */
  public void raise(EventBus eventBus) {
    SignalEvent.fire(eventBus, this);
  }
  
  /**
   * Raise the signal on the given event hub from the given source.
   *
   * @param eventBus The event bus.
   * @param source The source.
   */
  public void raise(EventBus eventBus, Object source) {
    SignalEvent.fire(eventBus, this, source);
  }
  
  /**
   * Create a string representation of this object.
   *
   * @return The string representation of this object.
   */
  @Override
  public String toString() {
    return this.name;
  }
}
