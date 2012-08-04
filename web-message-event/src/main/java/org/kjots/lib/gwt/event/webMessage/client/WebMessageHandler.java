/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import com.google.gwt.event.shared.EventHandler;

/**
 * Web Message Handler.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public interface WebMessageHandler extends EventHandler {
  /**
   * Receive notification that a web message has been received.
   * 
   * @param webMessageEvent The web message event.
   */
  public void onWebMessage(WebMessageEvent webMessageEvent);
}
