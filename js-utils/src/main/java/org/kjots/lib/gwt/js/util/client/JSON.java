/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.js.util.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * JSON.
 * <p>
 * GWT Front-end to the <code>JSON</code> JavaScript object.
 * <p>
 * Created: 5th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class JSON extends JavaScriptObject {
  /**
   * Stringify the given value.
   * <p>
   * This method returns the result of <code>JSON.stringify</code> for the
   * given value.
   *
   * @param value The value.
   * @return The stringified value.
   */
  public static native String stringify(Boolean value) /*-{
    return JSON.stringify(value);
  }-*/;
  
  /**
   * Stringify the given value.
   * <p>
   * This method returns the result of <code>JSON.stringify</code> for the
   * given value.
   *
   * @param value The value.
   * @return The stringified value.
   */
  public static native String stringify(Number value) /*-{
    return JSON.stringify(value);
  }-*/;
  
  /**
   * Stringify the given value.
   * <p>
   * This method returns the result of <code>JSON.stringify</code> for the
   * given value.
   *
   * @param value The value.
   * @return The stringified value.
   */
  public static native String stringify(String value) /*-{
    return JSON.stringify(value);
  }-*/;
  
  /**
   * Stringify the given value.
   * <p>
   * This method returns the result of <code>JSON.stringify</code> for the
   * given value.
   *
   * @param value The value.
   * @return The stringified value.
   */
  public static native String stringify(JavaScriptObject value) /*-{
    return JSON.stringify(value);
  }-*/;
  
  /**
   * Stringify the value of the given {@link JsAny}.
   * <p>
   * This method returns the result of <code>JSON.stringify</code> for the
   * value of the given {@link JsAny}.
   *
   * @param any The JS Any.
   * @return The stringified value.
   */
  public static native String stringify(JsAny<?> any) /*-{
    return JSON.stringify(any.value);
  }-*/;
  
  /**
   * Construct a new JSON.
   */
  protected JSON() {
  }
}
