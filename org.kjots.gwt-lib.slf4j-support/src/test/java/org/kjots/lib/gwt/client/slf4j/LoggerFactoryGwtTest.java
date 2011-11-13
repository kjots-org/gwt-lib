/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
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
