/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.request;

import java.util.HashMap;
import java.util.Map;

import org.kjots.lib.gwt.event.webMessage.client.HasWebMessageHandlers;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageHandler;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageUtil;
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
  private class RegisteredResponseHandler {
    /** The request. */
    public final Request request;
    
    /** The response handler. */
    public final ResponseHandler responseHandler;
    
    /**
     * Construct a new Registered Response Handler.
     *
     * @param request The request.
     * @param responseHandler The response handler.
     */
    public RegisteredResponseHandler(Request request, ResponseHandler responseHandler) {
      this.request = request;
      this.responseHandler = responseHandler;
    }

    /**
     * Handle the given response.
     *
     * @param response The response.
     */
    public void onResponse(Response response) {
      this.responseHandler.onResponse(this.request, response);
    }
  }
  
  /** The next request ID. */
  private static int nextRequestId = 1;
  
  /** The registered response handlers. */
  private final Map<String, RegisteredResponseHandler> registeredResponseHandlers = new HashMap<String, RegisteredResponseHandler>();
  
  /**
   * Retrieve the next request ID.
   *
   * @return The next request ID.
   */
  public static String getNextRequestId() {
    try {
      return Long.toString(System.currentTimeMillis()) + "-" + Integer.toString(nextRequestId);
    }
    finally {
      nextRequestId++;
    }
  }
  
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
          RegisteredResponseHandler registeredResponseHandler = registeredResponseHandlers.remove(response.getRequestId());
          if (registeredResponseHandler != null) {
            registeredResponseHandler.onResponse(response);
          }
        }
      }
    });
  }
  
  /**
   * Post the given request to the given window with the given target origin.
   *
   * @param window The window.
   * @param request The request.
   * @param targetOrigin The target origin.
   * @param responseHandler The response handler.
   */
  public void postRequest(JavaScriptObject window, JsAny<?> request, String targetOrigin, final ResponseHandler responseHandler) {
    RegisteredResponseHandler registeredResponseHandler = new RegisteredResponseHandler(Request.create(request), responseHandler);
    
    registeredResponseHandlers.put(registeredResponseHandler.request.getRequestId(), registeredResponseHandler);
    
    WebMessageUtil.postMessage(window, JsAny.create(registeredResponseHandler.request), targetOrigin);
  }
}
