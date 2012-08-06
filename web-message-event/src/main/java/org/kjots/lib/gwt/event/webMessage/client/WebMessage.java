/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEventListener;
import org.kjots.lib.gwt.js.util.client.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web Message.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class WebMessage {
  /**
   * Web Message Entry Point.
   * <p>
   * Created: 5th August 2012.
   */
  public static class EntryPoint implements com.google.gwt.core.client.EntryPoint {
    /**
     * Receive notification that this module has been loaded.
     */
    @Override
    public void onModuleLoad() {
      getLogMessageEventHandler().bind();
    }
    
    /**
     * Retrieve the log message event handler.
     *
     * @return The log message event handler.
     */
    private native MessageEventListener getLogMessageEventHandler() /*-{
      return @org.kjots.lib.gwt.event.webMessage.client.WebMessage::logMessageEvent(Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessageEvent;);
    }-*/;
  }
  
  /** The logger for this class. */
  private static final Logger logger = LoggerFactory.getLogger(WebMessage.class);
  
  /**
   * Log the given message event.
   *
   * @param messageEvent The message event.
   */
  static void logMessageEvent(MessageEvent messageEvent) {
    if (logger.isDebugEnabled()) {
      logger.debug("Message received: data={}, origin={}, lastEventId={}, source={}", new Object[] {
        JSON.stringify(messageEvent.getData()),
        messageEvent.getOrigin(),
        messageEvent.getLastEventId(),
        messageEvent.getSource() != null ? messageEvent.getSource().getUrl() : null,
      });
    }
  }
}
