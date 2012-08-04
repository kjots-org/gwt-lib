/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

import org.kjots.lib.gwt.js.util.client.JsAny;

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
  /**
   * Post the given message.
   *
   * @param message The message.
   */
  public final native void postMessage(JsAny<?> message) /*-{
    this.postMessage(message.value);
  }-*/;
  
  /**
   * Post the given message with the given transfer.
   *
   * @param message The message.
   * @param transfer The transfer.
   */
  public final native void postMessage(JsAny<?> message, JsArray<JavaScriptObject> transfer) /*-{
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
   * Construct a new Message Port.
   */
  protected MessagePort() {
  }
}
