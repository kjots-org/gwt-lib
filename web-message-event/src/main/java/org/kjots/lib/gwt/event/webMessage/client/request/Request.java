/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.request;

import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Request.
 * <p>
 * Created: 4th August 2012
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class Request extends JavaScriptObject {
  /**
   * Determine if the given object is a request.
   *
   * @param object The object.
   * @return <code>true</code> if the object is a request.
   */
  public static native boolean isRequest(JavaScriptObject object) /*-{
    return object && object.hasOwnProperty("$request");
  }-*/;
  
  /**
   * Return the given object as a request.
   *
   * @param object The object.
   * @return The object as a request or <code>null</code>.
   */
  public static native Request asRequest(JavaScriptObject object) /*-{
    return object && object.hasOwnProperty("$request") ? object : null;
  }-*/;

  /**
   * Retrieve the name of the request.
   *
   * @return The name of the request.
   */
  public final native String getName() /*-{
    return this.name;
  }-*/;
  
  /**
   * Retrieve the request data.
   *
   * @return The request data.
   */
  public final native JsAny<?> getData() /*-{
    return { "value" : this.data };
  }-*/;
  
  /**
   * Construct a new Request.
   */
  protected Request() {
  }
}
