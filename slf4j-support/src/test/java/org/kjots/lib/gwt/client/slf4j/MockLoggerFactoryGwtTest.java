/* 
 * Copyright © 2011 Karl J. Ots <kjots@kjots.org>
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
package org.kjots.lib.gwt.client.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mock Logger Factory GWT Test.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class MockLoggerFactoryGwtTest extends Slf4jSupportGwtTestBase {
  /**
   * Test the retrieval of a logger by name.
   */
  public void testGetLoggerByName() {
    Logger logger = LoggerFactory.getLogger("loggerName");
    
    assertNotNull(logger);
    assertTrue(logger instanceof MockLogger);
    assertEquals("loggerName", logger.getName());
  }
  
  /**
   * Test the retrieval of a logger by class.
   */
  public void testGetLoggerByClass() {
    Logger logger = LoggerFactory.getLogger(Object.class);
    
    assertNotNull(logger);
    assertTrue(logger instanceof MockLogger);
    assertEquals(Object.class.getName(), logger.getName());
  }
}