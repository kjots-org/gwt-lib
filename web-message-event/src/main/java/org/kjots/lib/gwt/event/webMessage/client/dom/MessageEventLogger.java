/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

import org.kjots.lib.gwt.js.util.client.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.core.client.EntryPoint;

/**
 * Message Event Logger.
 * <p>
 * Created: 6th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class MessageEventLogger implements MessageEventHandler, EntryPoint {
  /** The logger for this class. */
  private static final Logger logger = LoggerFactory.getLogger(MessageEventLogger.class);
  
  /**
   * Receive notification of a message event.
   *
   * @param messageEvent The message event.
   */
  public void onMessageEvent(MessageEvent messageEvent) {
    if (logger.isDebugEnabled()) {
      logger.debug("Message received: data={}, origin={}, lastEventId={}, source={}", new Object[] {
        JSON.stringify(messageEvent.getData()),
        messageEvent.getOrigin(),
        messageEvent.getLastEventId(),
        messageEvent.getSource() != null ? messageEvent.getSource().getUrl() : null,
      });
    }
  }
  
  /**
   * Receive notification that this module has been loaded.
   */
  @Override
  public void onModuleLoad() {
    MessageEventListener messageEventListener = MessageEventListener.create(this);
    
    Window.get().addMessageEventListener(messageEventListener);
    if (!Window.getWnd().equals(Window.get())) {
      Window.getWnd().addMessageEventListener(messageEventListener);
    }
  }
}
