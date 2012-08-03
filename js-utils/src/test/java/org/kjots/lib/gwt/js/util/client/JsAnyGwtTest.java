/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.js.util.client;

import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.arrayJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.booleanJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.booleanValue;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.doubleValue;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.functionJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.nullJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.numberJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.objectJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.objectValue;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.stringJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.stringObjectJsAny;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.stringValue;
import static org.kjots.lib.gwt.js.util.client.JsAnyFixtures.undefinedJsAny;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * JS Any GWT Test.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class JsAnyGwtTest extends JsUtilsGwtTestBase {
  /**
   * Test {@link JsAny#create(Boolean)}.
   * <p>
   * {@link JsAny#create(Boolean)} should return a new JS Any instance with the
   * value set to the provided boolean value. 
   */
  public void testCreateWithBoolean() {
    JsAny<Boolean> newBooleanJsAny = JsAny.create(booleanValue(booleanJsAny));
    
    assertTrue(newBooleanJsAny.isBoolean());
    assertEquals(booleanValue(booleanJsAny), newBooleanJsAny.asBoolean().booleanValue());
  }
  
  /**
   * Test {@link JsAny#create(Number)}.
   * <p>
   * {@link JsAny#create(Number)} should return a new JS Any instance with the
   * value set to the provided number value. 
   */
  public void testCreateWithNumber() {
    JsAny<Number> newNumberJsAny = JsAny.create(doubleValue(numberJsAny));
    
    assertTrue(newNumberJsAny.isNumber());
    assertEquals(doubleValue(numberJsAny), newNumberJsAny.asNumber().doubleValue());
  }
  
  /**
   * Test {@link JsAny#create(String)}.
   * <p>
   * {@link JsAny#create(String)} should return a new JS Any instance with the
   * value set to the provided string value. 
   */
  public void testCreateWithString() {
    JsAny<String> newStringJsAny = JsAny.create(stringValue(stringJsAny));
    
    assertTrue(newStringJsAny.isString());
    assertEquals(stringValue(stringJsAny), newStringJsAny.asString());
  }
  
  /**
   * Test {@link JsAny#create(JavaScriptObject)}.
   * <p>
   * {@link JsAny#create(JavaScriptObject)} should return a new JS Any instance
   * with the value set to the provided object value. 
   */
  public void testCreateWithObject() {
    JsAny<JavaScriptObject> newObjectJsAny = JsAny.create(objectValue(objectJsAny));
    
    assertTrue(newObjectJsAny.isObject());
    assertEquals(objectValue(objectJsAny), newObjectJsAny.asObject());
  }
  
  /**
   * Test {@link JsAny#isDefined}.
   * <p>
   * {@link JsAny#isDefined} should return <code>false</code> only for
   * undefined values.
   */
  public void testIsDefined() {
    assertFalse(undefinedJsAny.isDefined());
    assertTrue(nullJsAny.isDefined());
    assertTrue(booleanJsAny.isDefined());
    assertTrue(numberJsAny.isDefined());
    assertTrue(stringJsAny.isDefined());
    assertTrue(stringObjectJsAny.isDefined());
    assertTrue(objectJsAny.isDefined());
    assertTrue(arrayJsAny.isDefined());
    assertTrue(functionJsAny.isDefined());
  }
  
  /**
   * Test {@link JsAny#isNull}.
   * <p>
   * {@link JsAny#isNull} should return <code>true</code> only for
   * <code>null</code> values.
   */
  public void testIsNull() {
    assertFalse(undefinedJsAny.isNull());
    assertTrue(nullJsAny.isNull());
    assertFalse(booleanJsAny.isNull());
    assertFalse(numberJsAny.isNull());
    assertFalse(stringJsAny.isNull());
    assertFalse(stringObjectJsAny.isNull());
    assertFalse(objectJsAny.isNull());
    assertFalse(arrayJsAny.isNull());
    assertFalse(functionJsAny.isNull());
  }
  
  /**
   * Test {@link JsAny#isBoolean}.
   * <p>
   * {@link JsAny#isBoolean} should return <code>true</code> only for values
   * with type <code>boolean</code>.
   */
  public void testIsBoolean() {
    assertFalse(undefinedJsAny.isBoolean());
    assertFalse(nullJsAny.isBoolean());
    assertTrue(booleanJsAny.isBoolean());
    assertFalse(numberJsAny.isBoolean());
    assertFalse(stringJsAny.isBoolean());
    assertFalse(stringObjectJsAny.isBoolean());
    assertFalse(objectJsAny.isBoolean());
    assertFalse(arrayJsAny.isBoolean());
    assertFalse(functionJsAny.isBoolean());
  }
  
  /**
   * Test {@link JsAny#isNumber}.
   * <p>
   * {@link JsAny#isNumber} should return <code>true</code> only for values
   * with type <code>number</code>.
   */
  public void testIsNumber() {
    assertFalse(undefinedJsAny.isNumber());
    assertFalse(nullJsAny.isNumber());
    assertFalse(booleanJsAny.isNumber());
    assertTrue(numberJsAny.isNumber());
    assertFalse(stringJsAny.isNumber());
    assertFalse(stringObjectJsAny.isNumber());
    assertFalse(objectJsAny.isNumber());
    assertFalse(arrayJsAny.isNumber());
    assertFalse(functionJsAny.isNumber());
  }
  
  /**
   * Test {@link JsAny#isString}.
   * <p>
   * {@link JsAny#isNumber} should return <code>true</code> only values
   * with type <code>string</code> and object values with class
   * <code>String</code>, and <code>false</code> for all other values.
   */
  public void testIsString() {
    assertFalse(undefinedJsAny.isString());
    assertFalse(nullJsAny.isString());
    assertFalse(booleanJsAny.isString());
    assertFalse(numberJsAny.isString());
    assertTrue(stringJsAny.isString());
    assertTrue(stringObjectJsAny.isString());
    assertFalse(objectJsAny.isString());
    assertFalse(arrayJsAny.isString());
    assertFalse(functionJsAny.isString());
  }
  
  /**
   * Test {@link JsAny#isObject}.
   * <p>
   * {@link JsAny#isObject} should return <code>false</code> for undefined
   * values and for values with type <code>boolean</code>, <code>number</code>
   * or <code>string</code>, and <code>true</code> for all other values.
   */
  public void testIsObject() {
    assertFalse(undefinedJsAny.isObject());
    assertTrue(nullJsAny.isObject());
    assertFalse(booleanJsAny.isObject());
    assertFalse(numberJsAny.isObject());
    assertFalse(stringJsAny.isObject());
    assertFalse(stringObjectJsAny.isObject());
    assertTrue(objectJsAny.isObject());
    assertTrue(arrayJsAny.isObject());
    assertTrue(functionJsAny.isObject());
  }
  
  /**
   * Test {@link JsAny#isArray}.
   * <p>
   * {@link JsAny#isArray} should return <code>true</code> only for object
   * values with class <code>Array</code>.
   */
  public void testIsArray() {
    assertFalse(undefinedJsAny.isArray());
    assertFalse(nullJsAny.isArray());
    assertFalse(booleanJsAny.isArray());
    assertFalse(numberJsAny.isArray());
    assertFalse(stringJsAny.isArray());
    assertFalse(stringObjectJsAny.isArray());
    assertFalse(objectJsAny.isArray());
    assertTrue(arrayJsAny.isArray());
    assertFalse(functionJsAny.isArray());
  }
  
  /**
   * Test {@link JsAny#isFunction}.
   * <p>
   * {@link JsAny#isFunction} should return <code>true</code> only for values
   * with type <code>function</code>.
   */
  public void testIsFunction() {
    assertFalse(undefinedJsAny.isFunction());
    assertFalse(nullJsAny.isFunction());
    assertFalse(booleanJsAny.isFunction());
    assertFalse(numberJsAny.isFunction());
    assertFalse(stringJsAny.isFunction());
    assertFalse(stringObjectJsAny.isFunction());
    assertFalse(objectJsAny.isFunction());
    assertFalse(arrayJsAny.isFunction());
    assertTrue(functionJsAny.isFunction());
  }
  
  /**
   * Test {@link JsAny#asBoolean}.
   * <p>
   * {@link JsAny#asBoolean} should return the value as a {@link Boolean} if
   * the value is a boolean value and <code>null</code> for all other values.
   */
  public void testAsBoolean() {
    assertNull(undefinedJsAny.asBoolean());
    assertNull(nullJsAny.asBoolean());
    assertEquals(booleanValue(booleanJsAny), booleanJsAny.asBoolean().booleanValue());
    assertNull(numberJsAny.asBoolean());
    assertNull(stringJsAny.asBoolean());
    assertNull(stringObjectJsAny.asBoolean());
    assertNull(objectJsAny.asBoolean());
    assertNull(arrayJsAny.asBoolean());
    assertNull(functionJsAny.asBoolean());
  }
  
  /**
   * Test {@link JsAny#asBooleanJsAny}.
   * <p>
   * {@link JsAny#asBooleanJsAny} should return the JS Any as a {@link JsAny}&lt;{@link Boolean}&gt;
   * if the value is a boolean value and <code>null</code> for all other values.
   */
  public void testAsBooleanJsAny() {
    assertNull(undefinedJsAny.asBooleanJsAny());
    assertNull(nullJsAny.asBooleanJsAny());
    assertSame(booleanJsAny, booleanJsAny.asBooleanJsAny());
    assertNull(numberJsAny.asBooleanJsAny());
    assertNull(stringJsAny.asBooleanJsAny());
    assertNull(stringObjectJsAny.asBooleanJsAny());
    assertNull(objectJsAny.asBooleanJsAny());
    assertNull(arrayJsAny.asBooleanJsAny());
    assertNull(functionJsAny.asBooleanJsAny());
  }
  
  /**
   * Test {@link JsAny#asNumber}.
   * <p>
   * {@link JsAny#asNumber} should return the value as a {@link Number} if
   * the value is a number value and <code>null</code> for all other values.
   */
  public void testAsNumber() {
    assertNull(undefinedJsAny.asNumber());
    assertNull(nullJsAny.asNumber());
    assertNull(booleanJsAny.asNumber());
    assertEquals(doubleValue(numberJsAny), numberJsAny.asNumber().doubleValue());
    assertNull(stringJsAny.asNumber());
    assertNull(stringObjectJsAny.asNumber());
    assertNull(objectJsAny.asNumber());
    assertNull(arrayJsAny.asNumber());
    assertNull(functionJsAny.asNumber());
  }
  
  /**
   * Test {@link JsAny#asNumberJsAny}.
   * <p>
   * {@link JsAny#asNumberJsAny} should return the JS Any as a {@link JsAny}&lt;{@link Number}&gt;
   * if the value is a number value and <code>null</code> for all other values.
   */
  public void testAsNumberJsAny() {
    assertNull(undefinedJsAny.asNumberJsAny());
    assertNull(nullJsAny.asNumberJsAny());
    assertNull(booleanJsAny.asNumberJsAny());
    assertSame(numberJsAny, numberJsAny.asNumberJsAny());
    assertNull(stringJsAny.asNumberJsAny());
    assertNull(stringObjectJsAny.asNumberJsAny());
    assertNull(objectJsAny.asNumberJsAny());
    assertNull(arrayJsAny.asNumberJsAny());
    assertNull(functionJsAny.asNumberJsAny());
  }
  
  /**
   * Test {@link JsAny#asString}.
   * <p>
   * {@link JsAny#asString} should return the value as a {@link String} if
   * the value is a string value and <code>null</code> for all other values.
   */
  public void testAsString() {
    assertNull(undefinedJsAny.asString());
    assertNull(nullJsAny.asString());
    assertNull(booleanJsAny.asString());
    assertNull(numberJsAny.asString());
    assertEquals(stringValue(stringJsAny), stringJsAny.asString());
    assertEquals(stringValue(stringObjectJsAny), stringObjectJsAny.asString());
    assertNull(objectJsAny.asString());
    assertNull(arrayJsAny.asString());
    assertNull(functionJsAny.asString());
  }
  
  /**
   * Test {@link JsAny#asStringJsAny}.
   * <p>
   * {@link JsAny#asStringJsAny} should return the JS Any as a {@link JsAny}&lt;{@link String}&gt;
   * if the value is a string value and <code>null</code> for all other values.
   */
  public void asStringJsAny() {
    assertNull(undefinedJsAny.asStringJsAny());
    assertNull(nullJsAny.asStringJsAny());
    assertNull(booleanJsAny.asStringJsAny());
    assertNull(numberJsAny.asStringJsAny());
    assertSame(stringJsAny, stringJsAny.asStringJsAny());
    assertSame(stringObjectJsAny, stringObjectJsAny.asStringJsAny());
    assertNull(objectJsAny.asStringJsAny());
    assertNull(arrayJsAny.asStringJsAny());
    assertNull(functionJsAny.asStringJsAny());
  }
  
  /**
   * Test {@link JsAny#asObject}.
   * <p>
   * {@link JsAny#asObject} should return the value as a {@link JavaScriptObject}
   * if the value is an object value and <code>null</code> for all other values.
   */
  public void testAsObject() {
    assertNull(undefinedJsAny.asObject());
    assertNull(nullJsAny.asObject());
    assertNull(booleanJsAny.asObject());
    assertNull(numberJsAny.asObject());
    assertNull(stringJsAny.asObject());
    assertNull(stringObjectJsAny.asObject());
    assertSame(objectValue(objectJsAny), objectJsAny.asObject());
    assertSame(objectValue(arrayJsAny), arrayJsAny.asObject());
    assertSame(objectValue(functionJsAny), functionJsAny.asObject());
  }
  
  /**
   * Test {@link JsAny#asObjectJsAny}.
   * <p>
   * {@link JsAny#asObjectJsAny} should return the JS Any as a {@link JsAny}&lt;? extends {@link JavaScriptObject}&gt;
   * if the value is an object value or <code>null</code> and <code>null</code>
   * for all other values.
   */
  public void testAsObjectJsAny() {
    assertNull(undefinedJsAny.asObjectJsAny());
    assertSame(nullJsAny, nullJsAny.asObjectJsAny());
    assertNull(booleanJsAny.asObjectJsAny());
    assertNull(numberJsAny.asObjectJsAny());
    assertNull(stringJsAny.asObjectJsAny());
    assertNull(stringObjectJsAny.asObjectJsAny());
    assertSame(objectJsAny, objectJsAny.asObjectJsAny());
    assertSame(arrayJsAny, arrayJsAny.asObjectJsAny());
    assertSame(functionJsAny, functionJsAny.asObjectJsAny());
  }
}
