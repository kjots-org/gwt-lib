/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.ui;

import org.kjots.lib.gwt.event.webMessage.client.HasWebMessageHandlers;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageHandler;
import org.kjots.lib.gwt.event.webMessage.client.dom.IFrameElement;
import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEventHandler;
import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEventListener;
import org.kjots.lib.gwt.event.webMessage.client.request.RequestManager;
import org.kjots.lib.gwt.event.webMessage.client.request.ResponseHandler;
import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Frame.
 * <p>
 * Drop in replacement for GWT's {@link com.google.gwt.user.client.ui.Frame Frame}
 * with support for web message events.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 * @see com.google.gwt.user.client.ui.Frame
 */
public class Frame extends com.google.gwt.user.client.ui.Frame implements HasWebMessageHandlers {
  /** The request manager. */
  private final RequestManager requestManager = new RequestManager(this);
  
  /** The message event listener. */
  private final MessageEventListener messageEventListener;
  
  /**
   * @see com.google.gwt.user.client.ui.Frame#wrap(Element)
   */
  public static Frame wrap(Element element) {
    // Assert that the element is attached.
    assert Document.get().getBody().isOrHasChild(element);

    Frame frame = new Frame(element);

    // Mark it attached and remember it for cleanup.
    frame.onAttach();
    RootPanel.detachOnWindowClose(frame);

    return frame;
  }
  
  /**
   * Construct a new Frame.
   * 
   * @see com.google.gwt.user.client.ui.Frame#Frame()
   */
  public Frame() {
    super();
    
    this.messageEventListener = this.createMessageEventListener();
  }

  /**
   * Construct a new Frame.
   *
   * @param url The URL.
   * @see com.google.gwt.user.client.ui.Frame#Frame(String)
   */
  public Frame(String url) {
    super(url);
    
    this.messageEventListener = this.createMessageEventListener();
  }
  
  /**
   * Add the given web message handler.
   *
   * @param webMessageHandler The web message handler.
   * @return The handler registration.
   */
  @Override
  public HandlerRegistration addWebMessageHandler(WebMessageHandler webMessageHandler) {
    return addHandler(webMessageHandler, WebMessageEvent.TYPE);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public void postMessage(Boolean message, String targetOrigin, JavaScriptObject... transfer) {
    this.getIFrameElement().getContentWindow().postMessage(JsAny.create(message), targetOrigin, transfer);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public void postMessage(Number message, String targetOrigin, JavaScriptObject... transfer) {
    this.getIFrameElement().getContentWindow().postMessage(JsAny.create(message), targetOrigin, transfer);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public void postMessage(String message, String targetOrigin, JavaScriptObject... transfer) {
    this.getIFrameElement().getContentWindow().postMessage(JsAny.create(message), targetOrigin, transfer);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public void postMessage(JavaScriptObject message, String targetOrigin, JavaScriptObject... transfer) {
    this.getIFrameElement().getContentWindow().postMessage(JsAny.create(message), targetOrigin, transfer);
  }
  
  /**
   * Post a request with the given name and data and target origin.
   *
   * @param name The name of the request.
   * @param data The request data.
   * @param targetOrigin The target origin.
   * @param responseHandler The response handler.
   */
  public void postRequest(String name, Boolean data, String targetOrigin, ResponseHandler responseHandler) {
    this.requestManager.postRequest(this.getIFrameElement().getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
  }
  
  /**
   * Post a request with the given name and data and target origin.
   *
   * @param name The name of the request.
   * @param data The request data.
   * @param targetOrigin The target origin.
   * @param responseHandler The response handler.
   */
  public void postRequest(String name, Number data, String targetOrigin, ResponseHandler responseHandler) {
    this.requestManager.postRequest(this.getIFrameElement().getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
  }
  
  /**
   * Post a request with the given name and data and target origin.
   *
   * @param name The name of the request.
   * @param data The request data.
   * @param targetOrigin The target origin.
   * @param responseHandler The response handler.
   */
  public void postRequest(String name, String data, String targetOrigin, ResponseHandler responseHandler) {
    this.requestManager.postRequest(this.getIFrameElement().getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
  }
  
  /**
   * Post a request with the given name and data and target origin.
   *
   * @param name The name of the request.
   * @param data The request data.
   * @param targetOrigin The target origin.
   * @param responseHandler The response handler.
   */
  public void postRequest(String name, JavaScriptObject data, String targetOrigin, ResponseHandler responseHandler) {
    this.requestManager.postRequest(this.getIFrameElement().getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
  }
  
  /**
   * Construct a new Frame.
   *
   * @param element The element.
   * @see com.google.gwt.user.client.ui.Frame#Frame(Element)
   */
  protected Frame(Element element) {
    super(element);
    
    this.messageEventListener = this.createMessageEventListener();
  }
  
  /**
   * Receive notification that the widget has been attached to the DOM.
   */
  @Override
  protected void onLoad() {
    this.messageEventListener.bind();
  }

  /**
   * Receive notification that the widget is about to be detached from the DOM.
   */
  @Override
  protected void onUnload() {
    this.messageEventListener.unbind();
  }

  /**
   * Create the message event listener.
   *
   * @return The message event listener.
   */
  private MessageEventListener createMessageEventListener() {
    return MessageEventListener.create(getIFrameElement(), new MessageEventHandler() {
      @Override
      public void onMessageEvent(MessageEvent messageEvent) {
        WebMessageEvent.fire(Frame.this, messageEvent);
      }
    });
  }
  
  /**
   * Retrieve the iframe element.
   *
   * @return the iframe element.
   */
  private IFrameElement getIFrameElement() {
    return getElement().cast();
  }
}
