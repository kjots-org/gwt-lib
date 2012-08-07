/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEvent;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

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
   * Fire a web message event for the given message event from the given source.
   *
   * @param source The source of the web message event.
   * @param messageEvent The message event.
   */
  public static void fire(HasHandlers source, MessageEvent messageEvent) {
    source.fireEvent(new WebMessageEvent(messageEvent));
  }
  
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
