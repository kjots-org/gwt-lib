/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.signal.shared;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Signal.
 * <p>
 * Created: 16th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class SignalEvent extends GwtEvent<SignalHandler> {
  /** The signal. */
  private final Signal signal;
  
  /**
   * Fire a signal event for the given signal from the given source.
   *
   * @param source The source of the signal event.
   * @param signal The signal.
   */
  public static void fire(HasHandlers source, Signal signal) {
    source.fireEvent(new SignalEvent(signal));
  }
  
  /**
   * Retrieve the type of the event.
   *
   * @return The type of the event.
   */
  @Override
  public Type<SignalHandler> getAssociatedType() {
    return this.signal;
  }

  /**
   * Retrieve the signal
   *
   * @return The signal
   */
  public Signal getSignal() {
    return this.signal;
  }
  
  /**
   * Create a string representation of this object.
   *
   * @return The string representation of this object.
   */
  @Override
  public String toString() {
    return "SignalEvent: signal=" + this.signal;
  }

  /**
   * Dispatch the event for the given handler.
   *
   * @param handler The handler.
   */
  @Override
  protected void dispatch(SignalHandler handler) {
    handler.onSignal(this.signal);
  }

  /**
   * Construct a new Signal Event.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   *
   * @param signal The signal.
   */
  private SignalEvent(Signal signal) {
    this.signal = signal;
  }
}
