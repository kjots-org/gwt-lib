/* 
 * Copyright © 2012 Karl J. Ots <kjots@kjots.org>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kjots.lib.gwt.client;

/**
 * java.lang.ThreadLocal Emulation GWT Test.
 * <p>
 * Created: 8th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class ThreadLocalEmulGwtTest extends ThreadLocalEmulGwtTestBase {
  /**
   * Test {@link ThreadLocal}.
   */
  public void testThreadLocal() {
    ThreadLocal<String> testThreadLocal = new ThreadLocal<String>();
    
    assertNull(testThreadLocal.get());
    
    testThreadLocal.set("Test String");
    
    assertEquals("Test String", testThreadLocal.get());
    
    testThreadLocal.remove();
    
    assertNull(testThreadLocal.get());
  }
  
  /**
   * Test {@link ThreadLocal@get} with an initial value.
   */
  public void testGetWithInitialValue() {
    final boolean[] initialValueInvoked = new boolean[] { false };
    
    ThreadLocal<String> testThreadLocal = new ThreadLocal<String>() {
      @Override
      protected String initialValue() {
        initialValueInvoked[0] = true;
        
        return "Test Initial Value String";
      }
    };
    
    assertEquals("Test Initial Value String", testThreadLocal.get());
    assertTrue(initialValueInvoked[0]);
  }
  
  /**
   * Test {@link ThreadLocal#set(Object)} with an initial value.
   */
  public void testSetWithInitialValue() {
    final boolean[] initialValueInvoked = new boolean[] { false };
    
    ThreadLocal<String> testThreadLocal = new ThreadLocal<String>() {
      @Override
      protected String initialValue() {
        initialValueInvoked[0] = true;
        
        return "Test Initial Value String";
      }
    };
    
    testThreadLocal.set("Test String");
    
    assertEquals("Test String", testThreadLocal.get());
    assertFalse(initialValueInvoked[0]);
  }
  
  /**
   * Test {@link ThreadLocal#remove()} with an initial value.
   */
  public void testRemoveWithInitialValue() {
    final boolean[] initialValueInvoked = new boolean[] { false };
    
    ThreadLocal<String> testThreadLocal = new ThreadLocal<String>() {
      @Override
      protected String initialValue() {
        initialValueInvoked[0] = true;
        
        return "Test Initial Value String";
      }
    };
    
    testThreadLocal.set("Test String");
    testThreadLocal.remove();
    
    assertEquals("Test Initial Value String", testThreadLocal.get());
    assertTrue(initialValueInvoked[0]);
  }
}
