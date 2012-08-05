/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.ui;

import org.kjots.lib.gwt.event.webMessage.client.HasWebMessageHandlers;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageHandler;
import org.kjots.lib.gwt.event.webMessage.client.WebMessage;
import org.kjots.lib.gwt.event.webMessage.client.request.RequestManager;
import org.kjots.lib.gwt.event.webMessage.client.request.ResponseHandler;
import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiConstructor;

/**
 * Named Frame.
 * <p>
 * Drop in replacement for GWT's {@link com.google.gwt.user.client.ui.NamedFrame NamedFrame}
 * with support for web message events.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 * @see com.google.gwt.user.client.ui.NamedFrame
 */
public class NamedFrame extends com.google.gwt.user.client.ui.NamedFrame implements HasWebMessageHandlers {
  /** The request manager. */
  private final RequestManager requestManager = new RequestManager(this);
  
  /**
   * Construct a new Named Frame.
   *
   * @param name The name.
   * @see com.google.gwt.user.client.ui.NamedFrame#NamedFrame(String)
   */
  @UiConstructor
  public NamedFrame(String name) {
    super(name);
    
    WebMessage.bridge(this);
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
    WebMessage.postMessage(this.getContentWindow(), JsAny.create(message), targetOrigin, transfer);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public void postMessage(Number message, String targetOrigin, JavaScriptObject... transfer) {
    WebMessage.postMessage(this.getContentWindow(), JsAny.create(message), targetOrigin, transfer);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public void postMessage(String message, String targetOrigin, JavaScriptObject... transfer) {
    WebMessage.postMessage(this.getContentWindow(), JsAny.create(message), targetOrigin, transfer);
  }
  
  /**
   * Post the given message with the given target origin and transfer.
   *
   * @param message The message.
   * @param targetOrigin The target origin.
   * @param transfer The transfer.
   */
  public void postMessage(JavaScriptObject message, String targetOrigin, JavaScriptObject... transfer) {
    WebMessage.postMessage(this.getContentWindow(), JsAny.create(message), targetOrigin, transfer);
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
    this.requestManager.postRequest(this.getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
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
    this.requestManager.postRequest(this.getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
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
    this.requestManager.postRequest(this.getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
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
    this.requestManager.postRequest(this.getContentWindow(), name, JsAny.create(data), targetOrigin, responseHandler);
  }
  
  /**
   * Retrieve the content window.
   *
   * @return The content window.
   */
  private native JavaScriptObject getContentWindow() /*-{
    return this.@com.google.gwt.user.client.ui.UIObject::getElement()().contentWindow;
  }-*/;
}
