/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

/**
 * Message Event Handler.
 * <p>
 * Created: 6th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public interface MessageEventHandler {
  /**
   * Receive notification of a message event.
   *
   * @param messageEvent The message event.
   */
  public void onMessageEvent(MessageEvent messageEvent);
}
