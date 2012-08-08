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
package java.lang;

import org.kjots.lib.gwt.client.ThreadLocalEmulGwtTestBase;

/**
 * java.lang.ThreadLocal Emulation.
 * <p>
 * Created: 8th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class ThreadLocal<T> {
  /** The value. */
  private T value;
  
  /** The value set flag. */
  private boolean valueSet;
  
  /**
   * Retrieve the value.
   *
   * @return The value.
   */
  public T get() {
    if (!this.valueSet) {
      this.value = this.initialValue();
      
      this.valueSet = true;
    }
    
    return this.value;
  }
  
  /**
   * Set the value.
   *
   * @param value The value.
   */
  public void set(T value) {
    this.value = value;
    
    this.valueSet = true;
  }
  
  /**
   * Remove the value.
   */
  public void remove() {
    this.value = null;
    
    this.valueSet = false;
  }
  
  /**
   * Retrieve the initial value.
   *
   * @return The initial value.
   */
  protected T initialValue() {
    return null;
  }
}
