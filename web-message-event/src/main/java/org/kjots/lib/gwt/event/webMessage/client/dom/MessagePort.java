/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

import org.kjots.lib.gwt.js.util.client.JSON;
import org.kjots.lib.gwt.js.util.client.JsAny;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * MessagePort.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class MessagePort extends JavaScriptObject {
  /** The logger for this class. */
  private static final Logger logger = LoggerFactory.getLogger("org.kjots.lib.gwt.event.webMessage.client.dom.MessagePort");
  
  /**
   * Log the posting of the given message.
   * 
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  static void logPostMessage(MessagePort messagePort, JsAny<?> message, JsArray<JavaScriptObject> transfer) {
    if (logger.isDebugEnabled()) {
      logger.debug("Posting message: messagePort={}, message={}, transfer={}", new Object[] {
        messagePort,
        JSON.stringify(message),
        transfer
      });
    }
  }
  
  /**
   * Post the given message with the given transfer.
   *
   * @param message The message.
   * @param transfer The transfer.
   */
  public final void postMessage(JsAny<?> message, JavaScriptObject... transfer) {
    JsArray<JavaScriptObject> jsTransfer = JavaScriptObject.createArray().cast();
    
    for (JavaScriptObject jso : transfer) {
      jsTransfer.push(jso);
    }
    
    this.postMessage(message, jsTransfer);
  };
  
  /**
   * Post the given message with the given transfer.
   *
   * @param message The message.
   * @param transfer The transfer.
   */
  public final native void postMessage(JsAny<?> message, JsArray<JavaScriptObject> transfer) /*-{
    @org.kjots.lib.gwt.event.webMessage.client.dom.MessagePort::logPostMessage(Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessagePort;Lorg/kjots/lib/gwt/js/util/client/JsAny;Lcom/google/gwt/core/client/JsArray;)(this, message, targetOrigin, transfer);
    
    this.postMessage(message.value, transfer);
  }-*/;
  
  /**
   * Start the message port.
   */
  public final native void start() /*-{
    this.start();
  }-*/;
  
  /**
   * Close the message port.
   */
  public final native void close() /*-{
    this.close();
  }-*/;
  
  /**
   * Retrieve the message event handler.
   *
   * @return The message event handler.
   * @see #setOnmessage(JavaScriptObject)
   */
  public final native JavaScriptObject getOnmessage() /*-{
    return this.onmessage;
  }-*/;
  
  /**
   * Set the message event handler.
   *
   * @param onmessage message event handler.
   * @see #getOnmessage()
   */
  public final native void setOnmessage(JavaScriptObject onmessage) /*-{
    this.onmessage = onmessage;
  }-*/;
  
  /**
   * Add the given message event listener.
   *
   * @param listener The message event listener.
   */
  public final native void addMessageEventListener(MessageEventListener listener) /*-{
    this.addEventListener("message", listener, false);
  }-*/;
  
  /**
   * Remove the given message event listener.
   *
   * @param listener The message event listener.
   */
  public final native void removeMessageEventListener(MessageEventListener listener) /*-{
    this.removeEventListener("message", listener, false);
  }-*/;
  
  /**
   * Construct a new Message Port.
   */
  protected MessagePort() {
  }
}
