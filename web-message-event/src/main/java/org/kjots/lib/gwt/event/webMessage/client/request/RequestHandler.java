/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.request;

import org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageHandler;
import org.kjots.lib.gwt.event.webMessage.client.dom.MessageEvent;
import org.kjots.lib.gwt.js.util.client.JsAny;

/**
 * Request Handler.
 * <p>
 * Created: 7th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public abstract class RequestHandler implements WebMessageHandler {
  /**
   * Create a new response for the given request with the given data.
   *
   * @param request The request.
   * @param data The response data.
   * @return The response.
   */
  private static native Response createResponse(Request request, JsAny<?> data) /*-{
    return { 
      "$response" : request["$request"],
      "data" : data.value
    };
  }-*/;
  
  /**
   * Receive notification that a web message has been received.
   * 
   * @param webMessageEvent The web message event.
   */
  public final void onWebMessage(WebMessageEvent webMessageEvent) {
    MessageEvent messageEvent = webMessageEvent.getMessageEvent();
    
    Request request = Request.asRequest(messageEvent.getData().asObject());
    if (request != null) {
      JsAny<?> data = this.onRequest(request.getName(), request.getData());
      
      messageEvent.getSource().postMessage(JsAny.create(createResponse(request, data)), messageEvent.getOrigin());
    }
  }
  
  /**
   * Receive notification of a request.
   *
   * @param name The name of the request.
   * @param data The request data.
   * @return The response data.
   */
  protected abstract JsAny<?> onRequest(String name, JsAny<?> data);
}
