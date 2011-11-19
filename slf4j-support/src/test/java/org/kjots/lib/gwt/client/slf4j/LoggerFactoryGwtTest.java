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

import org.kjots.lib.gwt.client.Slf4jSupportGwtTestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger Factory GWT Test.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class LoggerFactoryGwtTest extends Slf4jSupportGwtTestBase {
  /**
   * Test the retrieval of a logger.
   * <p>
   * This test asserts that the emulated {@link LoggerFactory} returns a logger.
   */
  public void testGetLogger() {
    Logger logger = LoggerFactory.getLogger(Object.class);
    
    assertNotNull(logger);
  }
}
