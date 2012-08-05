/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEvent;
import org.kjots.lib.gwt.js.util.client.JSON;
import org.kjots.lib.gwt.js.util.client.JsAny;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Frame;

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
     * Retrieve the log message event handler.
     *
     * @return The log message event handler.
     */
    private static native JavaScriptObject getLogMessageEventHandler() /*-{
      return @org.kjots.lib.gwt.event.webMessage.client.WebMessage::logMessageEvent(Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessageEvent;);
    }-*/;
    
    /**
     * Receive notification that this module has been loaded.
     */
    @Override
    public void onModuleLoad() {
      addMessageEventListener(getLogMessageEventHandler());
    }
  }
  
  /** The logger for this class. */
  private static final Logger logger = LoggerFactory.getLogger(WebMessage.class);
  
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
    @org.kjots.lib.gwt.event.webMessage.client.WebMessage::logPostMessage(Lcom/google/gwt/core/client/JavaScriptObject;Lorg/kjots/lib/gwt/js/util/client/JsAny;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(window, message, targetOrigin, transfer);
    
    window.postMessage(message.value, targetOrigin, transfer);
  }-*/;

  /**
   * Add the given message event listener.
   *
   * @param messageEventListener The given message event listener.
   */
  public static native void addMessageEventListener(JavaScriptObject messageEventListener) /*-{
    window.addEventListener("message", messageEventListener, false);
    if ($wnd !== window) {
      $wnd.addEventListener("message", messageEventListener, false);
    }
  }-*/;
  
  /**
   * Remove the given message event listener.
   *
   * @param messageEventListener The given message event listener.
   */
  public static native void removeMessageEventListener(JavaScriptObject messageEventListener) /*-{
    window.removeEventListener("message", messageEventListener, false);
    if ($wnd !== window) {
      $wnd.removeEventListener("message", messageEventListener, false);
    }
  }-*/;
  
  /**
   * Bridge the given frame.
   *
   * @param widget The frame.
   */
  public static void bridge(final Frame frame) {
    frame.addAttachHandler(new AttachEvent.Handler() {
      private JavaScriptObject messageEventListener;
      
      @Override
      public void onAttachOrDetach(AttachEvent attachEvent) {
        if (attachEvent.isAttached()) {
          this.messageEventListener = createMessageEventHandler(frame, frame.getElement());
          
          addMessageEventListener(this.messageEventListener);
        }
        else {
          removeMessageEventListener(this.messageEventListener);
          
          this.messageEventListener = null;
        }
      }
      
      private native JavaScriptObject createMessageEventHandler(HasHandlers source, Element element) /*-{
        return function(messageEvent) {
          if (messageEvent.source === element.contentWindow) {
            @org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent::fire(Lcom/google/gwt/event/shared/HasHandlers;Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessageEvent;)(source, messageEvent);
          }
        };
      }-*/;
    });
  }
  
  /**
   * Log the posting of the given message.
   * 
   * @param window The window.
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  static void logPostMessage(JavaScriptObject window, JsAny<?> message, String targetOrigin, JsArray<JavaScriptObject> transfer) {
    if (logger.isDebugEnabled()) {
      logger.debug("Posting message: window={}, message={}, targetOrigin={}, transfer={}", new Object[] {
        getWindowUrl(window),
        JSON.stringify(message),
        targetOrigin,
        transfer
      });
    }
  }
  
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
        getWindowUrl(messageEvent.getSource())
      });
    }
  }
  
  /**
   * Retrieve the URL of the given window object.
   *
   * @param window The window object.
   * @return The URL.
   */
  private static native String getWindowUrl(JavaScriptObject window) /*-{
    return window.location.href;
  }-*/;
}
