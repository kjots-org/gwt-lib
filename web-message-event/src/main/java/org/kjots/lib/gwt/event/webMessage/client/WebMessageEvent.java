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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Frame;

/**
 * Web Message Event.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class WebMessageEvent extends GwtEvent<WebMessageHandler> {
  /** The type of the event. */
  public static final Type<WebMessageHandler> TYPE = new Type<WebMessageHandler>() {
    @Override
    public String toString() {
      return "WebMessageEvent";
    }
  };
  
  /** The logger for this class. */
  private static final Logger logger = LoggerFactory.getLogger(WebMessageEvent.class);
  {
    LoggerFactory.getLogger(WebMessageEvent.class);
  }
  
  /** The message event. */
  private final MessageEvent messageEvent;
  
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
          @org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent::logMessageEvent(Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessageEvent;)(messageEvent);
          
          if (messageEvent.source === element.contentWindow) {
            @org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent::fire(Lcom/google/gwt/event/shared/HasHandlers;Lorg/kjots/lib/gwt/event/webMessage/client/dom/MessageEvent;)(source, messageEvent);
          }
        };
      }-*/;
    });
  }
  
  /**
   * Fire a web message event for the given message event from the given source.
   *
   * @param source The source of the web message event.
   * @param messageEvent The message event.
   */
  static void fire(HasHandlers source, MessageEvent messageEvent) {
    source.fireEvent(new WebMessageEvent(messageEvent));
  }
  
  /**
   * Add the given message event listener.
   *
   * @param messageEventListener The given message event listener.
   */
  private static native void addMessageEventListener(JavaScriptObject messageEventListener) /*-{
    $wnd.addEventListener("message", messageEventListener, false);
  }-*/;
  
  /**
   * Remove the given message event listener.
   *
   * @param messageEventListener The given message event listener.
   */
  private static native void removeMessageEventListener(JavaScriptObject messageEventListener) /*-{
    $wnd.removeEventListener("message", messageEventListener, false);
  }-*/;

  /**
   * Log the given message event.
   *
   * @param messageEvent The message event.
   */
  private static void logMessageEvent(MessageEvent messageEvent) {
    if (logger.isDebugEnabled()) {
      logger.debug("Message event received: data={}, origin={}, lastEventId={}, source={}", new Object[] {
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
  
  /**
   * Retrieve the type of the event.
   *
   * @return The type of the event.
   */
  @Override
  public Type<WebMessageHandler> getAssociatedType() {
    return TYPE;
  }

  /**
   * Dispatch the event for the given handler.
   *
   * @param handler The handler.
   */
  @Override
  protected void dispatch(WebMessageHandler handler) {
    handler.onWebMessage(this);
  }
  
  /**
   * Retrieve the message event.
   *
   * @return The message event.
   */
  public MessageEvent getMessageEvent() {
    return this.messageEvent;
  }

  /**
   * Retrieve the message.
   *
   * @return The message.
   */
  public final JsAny<?> getMessage() {
    return this.messageEvent.getData();
  }

  /**
   * Create a string representation of this object.
   *
   * @return The string representation of this object.
   */
  @Override
  public String toString() {
    return "WebMessageEvent: message=" + this.messageEvent.getData().valueString();
  }

  /**
   * Construct a new Web Message Event.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   * 
   * @param messageEvent The message event.
   */
  private WebMessageEvent(MessageEvent messageEvent) {
    this.messageEvent = messageEvent;
  }
}
