/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEvent;
import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.event.shared.GwtEvent;

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
  
  /** The message event. */
  private final MessageEvent messageEvent;

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
