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
 * Window.
 * <p>
 * Created: 6th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class Window extends JavaScriptObject {
  /** The logger for this class. */
  private static final Logger logger = LoggerFactory.getLogger("org.kjots.lib.gwt.event.webMessage.client.dom.Window");
  
  /**
   * Retrieve the global window object.
   *
   * @return The global window object.
   */
  public static native Window get() /*-{
    return window;
  }-*/;
  
  /**
   * Retrieve the GWT <code>$wnd</code> object.
   *
   * @return The GWT <code>$wnd</code> object.
   */
  public static native Window getWnd() /*-{
    return $wnd;
  }-*/;

  /**
   * Log the posting of the given message.
   * 
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  static void logPostMessage(Window window, JsAny<?> message, String targetOrigin, JsArray<JavaScriptObject> transfer) {
    if (logger.isDebugEnabled()) {
      logger.debug("Posting message: window={}, message={}, targetOrigin={}, transfer={}", new Object[] {
        window.getUrl(),
        JSON.stringify(message),
        targetOrigin,
        transfer
      });
    }
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public final void postMessage(JsAny<?> message, String targetOrigin, JavaScriptObject... transfer) {
    JsArray<JavaScriptObject> jsTransfer = JavaScriptObject.createArray().cast();
    
    for (JavaScriptObject jso : transfer) {
      jsTransfer.push(jso);
    }
    
    this.postMessage(message, targetOrigin, jsTransfer);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public final native void postMessage(JsAny<?> message, String targetOrigin, JsArray<JavaScriptObject> transfer) /*-{
    @org.kjots.lib.gwt.event.webMessage.client.dom.Window::logPostMessage(Lorg/kjots/lib/gwt/event/webMessage/client/dom/Window;Lorg/kjots/lib/gwt/js/util/client/JsAny;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(this, message, targetOrigin, transfer);
    
    this.postMessage(message.value, targetOrigin, transfer);
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
   * Retrieve the URL of the window object.
   *
   * @return The URL.
   */
  public final native String getUrl() /*-{
    return this.location.href;
  }-*/;
  
  /**
   * Construct a new Window.
   */
  protected Window() {
  }
}
