/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.request;

import java.util.HashMap;
import java.util.Map;

import org.kjots.lib.gwt.event.webMessage.client.HasWebMessageHandlers;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageHandler;
import org.kjots.lib.gwt.event.webMessage.client.WebMessage;
import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Request Manager.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class RequestManager {
  /**
   * Registered Response Handler.
   */
  private interface RegisteredResponseHandler {
    /**
     * Handle the given response.
     *
     * @param response The response.
     */
    public void onResponse(Response response);
  }
  
  /** The next request ID. */
  private static int nextRequestId = 1;
  
  /** The response handlers. */
  private final Map<String, RegisteredResponseHandler> responseHandlers = new HashMap<String, RegisteredResponseHandler>();
  
  /**
   * Retrieve the next request ID.
   *
   * @return The next request ID.
   */
  private static String getNextRequestId() {
    try {
      return Long.toString(System.currentTimeMillis()) + "-" + Integer.toString(nextRequestId);
    }
    finally {
      nextRequestId++;
    }
  }
  
  /**
   * Create a new request with the given name and data.
   *
   * @param name The name of the request.
   * @param data The request data.
   * @return The request.
   */
  private static native Request createRequest(String name, JsAny<?> data) /*-{
    return { 
      "$request" : @org.kjots.lib.gwt.event.webMessage.client.request.RequestManager::getNextRequestId()(),
      "name" : name,
      "data" : data.value
    };
  }-*/;
  
  /**
   * Retrieve the request ID from the given request.
   *
   * @param response The request.
   * @return The request ID.
   */
  private static native String getRequestId(Request request)  /*-{
    return request["$request"];
  }-*/;
  
  /**
   * Retrieve the request ID from the given response.
   *
   * @param response The response.
   * @return The request ID.
   */
  private static native String getRequestId(Response response)  /*-{
    return response["$response"];
  }-*/;
  
  /**
   * Construct a new Request Manager.
   *
   * @param window The source.
   */
  public RequestManager(HasWebMessageHandlers source) {
    source.addWebMessageHandler(new WebMessageHandler() {
      @Override
      public void onWebMessage(WebMessageEvent webMessageEvent) {
        Response response = Response.asResponse(webMessageEvent.getMessage().asObject());
        if (response != null) {
          RequestManager.this.onResponse(response);
        }
      }
    });
  }
  
  /**
   * Post a request with the given name and data to the given window with the
   * given target origin.
   *
   * @param window The window.
   * @param name The name of the request.
   * @param data The request data.
   * @param targetOrigin The target origin.
   * @param responseHandler The response handler.
   */
  public void postRequest(JavaScriptObject window, String name, JsAny<?> data, String targetOrigin, final ResponseHandler responseHandler) {
    final Request request = createRequest(name, data);
    
    responseHandlers.put(getRequestId(request), new RegisteredResponseHandler() {
      @Override
      public void onResponse(Response response) {
        responseHandler.onResponse(request, response);
      }
    });
    
    WebMessage.postMessage(window, JsAny.create(request), targetOrigin);
  }
  
  /**
   * Receive notification of a response.
   *
   * @param response The response.
   */
  private void onResponse(Response response) {
    RegisteredResponseHandler responseHandler = this.responseHandlers.remove(getRequestId(response));
    if (responseHandler != null) {
      responseHandler.onResponse(response);
    }
  }
}
