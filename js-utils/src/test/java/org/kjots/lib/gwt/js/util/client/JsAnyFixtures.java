/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.js.util.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * JS Any Fixtures.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
class JsAnyFixtures {
  /** The undefined JS Any. */
  static final JsAny<Void> undefinedJsAny = createUndefinedJsAny();
  
  /** The null JS Any. */
  static final JsAny<JavaScriptObject> nullJsAny = createNullJsAny();
  
  /** The boolean JS Any. */
  static final JsAny<Boolean> booleanJsAny = createBooleanJsAny();
  
  /** The number JS Any. */
  static final JsAny<Number> numberJsAny = createNumberJsAny();
  
  /** The string JS Any. */
  static final JsAny<String> stringJsAny = createStringJsAny();
  
  /** The string object JS Any. */
  static final JsAny<String> stringObjectJsAny = createStringObjectJsAny();
  
  /** The object JS Any. */
  static final JsAny<JavaScriptObject> objectJsAny = createObjectJsAny();
  
  /** The array JS Any. */
  static final JsAny<JavaScriptObject> arrayJsAny = createArrayJsAny();
  
  /** The function JS Any. */
  static final JsAny<JavaScriptObject> functionJsAny = createFunctionJsAny();
  
  /**
   * Retrieve the value of the given JS Any as a <code>boolean<code>.
   *
   * @param any The JS Any.
   * @return The boolean value.
   */
  static native boolean booleanValue(JsAny<Boolean> any) /*-{
    return any.value;
  }-*/;
  
  /**
   * Retrieve the value of the given JS Any as a <code>double</code>.
   *
   * @param any The JS Any.
   * @return The number value.
   */
  static native double doubleValue(JsAny<Number> any) /*-{
    return any.value;
  }-*/;
  
  /**
   * Retrieve the value of the given JS Any as a {@link String}.
   *
   * @param any The JS Any.
   * @return The string value.
   */
  static native String stringValue(JsAny<String> any) /*-{
    return any.value;
  }-*/;
  
  /**
   * Retrieve the value of the given JS Any as a {@link JavaScriptObject}.
   *
   * @param any The JS Any.
   * @return The object value.
   */
  static native JavaScriptObject objectValue(JsAny<? extends JavaScriptObject> any) /*-{
    return any.value;
  }-*/;
  
  /**
   * Retrieve the result of the given <code>toString</code> method of the value
   * of the given JS Any.
   *
   * @param any The JS Any.
   * @return The value string.
   */
  static native String valueToString(JsAny<?> any) /*-{
    return any.value.toString();
  }-*/;
  
  /**
   * Create a JS Any with an undefined value.
   *
   * @return The undefined JS Any.
   */
  private static native JsAny<Void> createUndefinedJsAny() /*-{
    return { "value" : undefined };
  }-*/;
  
  /**
   * Create a JS Any with a <code>null</code> value.
   *
   * @return The null JS Any.
   */
  private static native JsAny<JavaScriptObject> createNullJsAny() /*-{
    return { "value" : null };
  }-*/;
  
  /**
   * Create a JS Any with a boolean value.
   *
   * @return The boolean JS Any.
   */
  private static native JsAny<Boolean> createBooleanJsAny() /*-{
    return { "value" : true };
  }-*/;
  
  /**
   * Create a JS Any with a boolean object value.
   *
   * @return The boolean object JS Any.
   */
  private static native JsAny<JavaScriptObject> createBooleanObjectJsAny() /*-{
    return { "value" : new Boolean(true) };
  }-*/;
  
  /**
   * Create a JS Any with a number value.
   *
   * @return The number JS Any.
   */
  private static native JsAny<Number> createNumberJsAny() /*-{
    return { "value" : 3.14 };
  }-*/;
  
  /**
   * Create a JS Any with a number object value.
   *
   * @return The number object JS Any.
   */
  private static native JsAny<JavaScriptObject> createNumberObjectJsAny() /*-{
    return { "value" : new Number(3.14) };
  }-*/;
  
  /**
   * Create a JS Any with a string value.
   *
   * @return The string JS Any.
   */
  private static native JsAny<String> createStringJsAny() /*-{
    return { "value" : "value" };
  }-*/;
  
  /**
   * Create a JS Any with a string object value.
   *
   * @return The string object JS Any.
   */
  private static native JsAny<String> createStringObjectJsAny() /*-{
    return { "value" : new String("value") };
  }-*/;
  
  /**
   * Create a JS Any with an object value.
   *
   * @return The object JS Any.
   */
  private static native JsAny<JavaScriptObject> createObjectJsAny() /*-{
    return { "value" : {} };
  }-*/;
  
  /**
   * Create a JS Any with an array value.
   *
   * @return The array JS Any.
   */
  private static native JsAny<JavaScriptObject> createArrayJsAny() /*-{
    return { "value" : [] };
  }-*/;
  
  /**
   * Create a JS Any with an function value.
   *
   * @return The function JS Any.
   */
  private static native JsAny<JavaScriptObject> createFunctionJsAny() /*-{
    return { "value" : function(){} };
  }-*/;
}
