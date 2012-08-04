/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Web Message Util.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class WebMessageUtil {
  /**
   * Post the given message to the given window with the given target origin and transfer.
   *
   * @param window The window.
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public static void postMessage(JavaScriptObject window, JsAny<?> message, String targetOrigin, JavaScriptObject... transfer) {
    JsArray<JavaScriptObject> jsTransfer = JavaScriptObject.createArray().cast();
    
    for (JavaScriptObject jso : transfer) {
      jsTransfer.push(jso);
    }
    
    postMessage(window, message, targetOrigin, jsTransfer);
  }
  
  /**
   * Post the given message to the given window with the given target origin and transfer.
   *
   * @param window The window.
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public static native void postMessage(JavaScriptObject window, JsAny<?> message, String targetOrigin, JsArray<JavaScriptObject> transfer) /*-{
    window.postMessage(message.value, targetOrigin, transfer);
  }-*/;
}
