/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.request;

import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Response.
 * <p>
 * Created: 4th August 2012
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class Response extends JavaScriptObject {
  /**
   * Create a new response for the given request with the given data.
   *
   * @param request The request.
   * @param data The response data.
   * @return The response.
   */
  public static native Request create(Request request, JsAny<?> data) /*-{
    return { 
      "$response" : request["$request"],
      "data" : data.value
    };
  }-*/;
  
  /**
   * Determine if the given object is a response.
   *
   * @param object The object.
   * @return <code>true</code> if the object is a response.
   */
  public static native boolean isResponse(JavaScriptObject object) /*-{
    return object && object.hasOwnProperty("$response");
  }-*/;
  
  /**
   * Return the given object as a response.
   *
   * @param object The object.
   * @return The object as a response or <code>null</code>.
   */
  public static native Response asResponse(JavaScriptObject object) /*-{
    return object && object.hasOwnProperty("$response") ? object : null;
  }-*/;
  
  /**
   * Retrieve the response data.
   *
   * @return The response data.
   */
  public final native JsAny<?> getData() /*-{
    return { "value" : this.data };
  }-*/;
  
  /**
   * Construct a new Response.
   */
  protected Response() {
  }
}
