/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.js.util.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * JS Any.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class JsAny<T> extends JavaScriptObject {
  /**
   * Create a JS Any with the given boolean value.
   *
   * @param value The boolean value.
   * @return The JS Any.
   */
  public static native JsAny<Boolean> create(Boolean value) /*-{
    return { "value" : value.@java.lang.Boolean::booleanValue()() };
  }-*/;
  
  /**
   * Create a JS Any with the given number value.
   *
   * @param value The number value.
   * @return The JS Any.
   */
  public static native JsAny<Number> create(Number value) /*-{
    return { "value" : value.@java.lang.Number::doubleValue()() };
  }-*/;
  
  /**
   * Create a JS Any with the given string value.
   *
   * @param value The string value.
   * @return The JS Any.
   */
  public static native JsAny<String> create(String value) /*-{
    return { "value" : value };
  }-*/;
  
  /**
   * Create a JS Any with the given object value.
   *
   * @param value The object value.
   * @return The JS Any.
   */
  public static native <T extends JavaScriptObject> JsAny<T> create(T value) /*-{
    return { "value" : value };
  }-*/;
  
  /**
   * Determine if the value is defined.
   *
   * @return <code>true</code> if the value is defined.
   */
  public final native boolean isDefined() /*-{
    return typeof this.value !== "undefined";
  }-*/;
  
  /**
   * Determine if the value is <code>null</code>.
   *
   * @return <code>true</code> if the value is <code>null</code>.
   */
  public final native boolean isNull() /*-{
    return this.value === null;
  }-*/;
  
  /**
   * Determine if the value is a boolean.
   *
   * @return <code>true</code> if the value is a boolean.
   */
  public final native boolean isBoolean() /*-{
    return typeof this.value === "boolean";
  }-*/;
  
  /**
   * Determine if the value is a number.
   *
   * @return <code>true</code> if the value is a number.
   */
  public final native boolean isNumber() /*-{
    return typeof this.value === "number";
  }-*/;
  
  /**
   * Determine if the value is a string.
   *
   * @return <code>true</code> if the value is a string.
   */
  public final native boolean isString() /*-{
    var type = typeof this.value
    
    return type === "string" || (type === "object" && Object.prototype.toString.call(this.value).slice(8, -1) === "String");
  }-*/;
  
  /**
   * Determine if the value is an object.
   *
   * @return <code>true</code> if the value is a object.
   */
  public final boolean isObject() {
    return isDefined() && !isBoolean() && !isNumber() && !isString();
  }
  
  /**
   * Determine if the value is an array.
   *
   * @return <code>true</code> if the value is an array.
   */
  public final native boolean isArray() /*-{
    return Object.prototype.toString.call(this.value).slice(8, -1) === "Array";
  }-*/;
  
  /**
   * Determine if the value is a function.
   *
   * @return <code>true</code> if the value is a function.
   */
  public final native boolean isFunction() /*-{
    return typeof this.value === "function";
  }-*/;
  
  /**
   * Retrieve the value as a {@link Boolean}.
   * <p>
   * This method will return <code>null</code> if the value is not a boolean
   * value.
   *
   * @return The boolean value or <code>null</code>.
   * @see #isBoolean()
   */
  public final Boolean asBoolean() {
    return isBoolean() ? booleanValue() : null;
  }
  
  /**
   * Retrieve the value as a {@link JsAny}&lt;{@link Boolean}&gt;.
   * <p>
   * This method will return <code>null</code> if the value is not a boolean
   * value.
   *
   * @return The boolean JS Any value or <code>null</code>.
   * @see #isString()
   */
  public final JsAny<Boolean> asBooleanJsAny() {
    return isBoolean() ? this.<JsAny<Boolean>>cast() : null;
  }
  
  /**
   * Retrieve the value as a {@link Number}.
   * <p>
   * This method will return <code>null</code> if the value is not a number
   * value.
   *
   * @return The number value or <code>null</code>.
   * @see #isNumber()
   */
  public final Number asNumber() {
    return isNumber() ? doubleValue() : null;
  }
  
  /**
   * Retrieve the value as a {@link JsAny}&lt;{@link Number}&gt;.
   * <p>
   * This method will return <code>null</code> if the value is not a number
   * value.
   *
   * @return The number JS Any value or <code>null</code>.
   * @see #isString()
   */
  public final JsAny<Number> asNumberJsAny() {
    return isNumber() ? this.<JsAny<Number>>cast() : null;
  }
  
  /**
   * Retrieve the value as a {@link String}.
   * <p>
   * This method will return <code>null</code> if the value is not a string
   * value.
   *
   * @return The string value or <code>null</code>.
   * @see #isString()
   */
  public final String asString() {
    return isString() ? stringValue() : null;
  }
  
  /**
   * Retrieve the value as a {@link JsAny}&lt;{@link String}&gt;.
   * <p>
   * This method will return <code>null</code> if the value is not a string
   * value.
   *
   * @return The string JS Any value or <code>null</code>.
   * @see #isString()
   */
  public final JsAny<String> asStringJsAny() {
    return isString() ? this.<JsAny<String>>cast() : null;
  }
  
  /**
   * Retrieve the value as a {@link JavaScriptObject}.
   * <p>
   * This method will return <code>null</code> if the value is not an object
   * value.
   *
   * @return The object value or <code>null</code>.
   * @see #isObject()
   * @see #isNull()
   */
  public final <J extends JavaScriptObject> J asObject() {
    return isObject() && !isNull() ? objectValue().<J>cast() : null;
  }
  
  /**
   * Retrieve the value as a {@link JsAny}&lt;? extends {@link JavaScriptObject}&gt;.
   * <p>
   * This method will return <code>null</code> if the value is not an object
   * value.
   *
   * @return The object JS Any value or <code>null</code>.
   * @see #isString()
   */
  public final <J extends JavaScriptObject> JsAny<J> asObjectJsAny() {
    return isObject() ? this.<JsAny<J>>cast() : null;
  }
  
  /**
   * Construct a new JS Any.
   */
  protected JsAny() {
  }
  
  /**
   * Retrieve the value as a <code>boolean</code>.
   *
   * @return The boolean value.
   */
  private native boolean booleanValue() /*-{
    return this.value;
  }-*/;
  
  /**
   * Retrieve the value as a <code>double</code>.
   *
   * @return The double value.
   */
  private native double doubleValue() /*-{
    return this.value;
  }-*/;
  
  /**
   * Retrieve the value as a {@link String}.
   *
   * @return The string value.
   */
  private native String stringValue() /*-{
    return this.value;
  }-*/;
  
  /**
   * Retrieve the value as a {@link JavaScriptObject}.
   *
   * @return The object value.
   */
  private native JavaScriptObject objectValue() /*-{
    return this.value;
  }-*/;
}
