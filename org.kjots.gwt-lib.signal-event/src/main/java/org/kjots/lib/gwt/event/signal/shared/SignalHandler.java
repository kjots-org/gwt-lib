/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.signal.shared;

import com.google.gwt.event.shared.EventHandler;

/**
 * Signal.
 * <p>
 * Created: 16th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public interface SignalHandler extends EventHandler {
  /**
   * Receive notification that a signal has been raised.
   *
   * @param signal The signal.
   */
  public void onSignal(Signal signal);
}
