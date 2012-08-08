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
 * java.lang.InheritableThreadLocal<T> Emulation GWT Test.
 * <p>
 * Created: 8th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class InheritableThreadLocalEmulGwtTest extends ThreadLocalEmulGwtTestBase {
  /**
   * Test {@link InheritableThreadLocal}.
   */
  public void testInheritableThreadLocal() {
    new InheritableThreadLocal<String>() {
      @Override
      protected String childValue(String parentValue) {
        return super.childValue(parentValue);
      }
    };
  }
}
