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
package org.kjots.lib.gwt.test;

import org.kjots.lib.gwt.client.slf4j.LoggerFactoryGwtTest;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * SLF4J Support GWT Test Suite.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class Slf4jSupportGwtTestSuite extends GWTTestSuite {
  /**
   * Create the test suite.
   *
   * @return The test suite.
   */
  public static Test suite() {
    Slf4jSupportGwtTestSuite suite = new Slf4jSupportGwtTestSuite();
    
    addTestSuites(suite);
    
    return suite;
  }
  
  /**
   * Add the test suites.
   *
   * @param suite The test suite.
   */
  public static void addTestSuites(TestSuite suite) {
    suite.addTestSuite(LoggerFactoryGwtTest.class);
  }
  
  /**
   * Construct a new SLF4J Support GWT Test Suite.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   */
  private Slf4jSupportGwtTestSuite() {
    super("SLF4J Support GWT Test Suite.");
  }
}
