/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Message Event Listener.
 * <p>
 * Created: 6th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class MessageEventListener extends JavaScriptObject {
  /**
   * Create a new message event listener.
   *
   * @param handler The message event handler.
   * @return The message event listener.
   */
  public static native MessageEventListener create(MessageEventHandler handler) /*-{
    return function(messageEvent) {
      handler.@org.kjots.lib.gwt.event.webMessage.client.dom.MessageEventHandler::onMessageEvent(Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessageEvent;)(messageEvent);
    };
  }-*/;
  
  /**
   * Create a new message event listener for the given iframe.
   *
   * @param iframe The iframe element.
   * @param handler The message event handler.
   * @return The message event listener.
   */
  public static native MessageEventListener create(IFrameElement iframe, MessageEventHandler handler) /*-{
    return function(messageEvent) {
      if (messageEvent.source === iframe.contentWindow) {
        handler.@org.kjots.lib.gwt.event.webMessage.client.dom.MessageEventHandler::onMessageEvent(Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessageEvent;)(messageEvent);
      }
    };
  }-*/;
  
  /**
   * Construct a new Message Event Listener.
   */
  protected MessageEventListener() {
  }
}
