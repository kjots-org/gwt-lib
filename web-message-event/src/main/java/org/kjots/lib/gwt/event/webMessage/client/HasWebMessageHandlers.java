/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Has Web Message Handlers.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public interface HasWebMessageHandlers extends HasHandlers {
  /**
   * Add the given web message handler.
   *
   * @param webMessageHandler The web message handler.
   * @return The handler registration.
   */
  public HandlerRegistration addWebMessageHandler(WebMessageHandler webMessageHandler);
}
