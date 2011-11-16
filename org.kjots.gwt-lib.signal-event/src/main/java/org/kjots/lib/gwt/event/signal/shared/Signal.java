/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.signal.shared;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;

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
   * Create a string representation of this object.
   *
   * @return The string representation of this object.
   */
  @Override
  public String toString() {
    return this.name;
  }
}
