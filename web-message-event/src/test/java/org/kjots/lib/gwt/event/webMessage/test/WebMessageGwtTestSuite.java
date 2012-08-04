/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * Web Message GWT Test Suite.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class WebMessageGwtTestSuite extends GWTTestSuite {
  /**
   * Create the test suite.
   *
   * @return The test suite.
   */
  public static Test suite() {
    WebMessageGwtTestSuite suite = new WebMessageGwtTestSuite();
    
    addTestSuites(suite);
    
    return suite;
  }
  
  /**
   * Add the test suites.
   *
   * @param suite The test suite.
   */
  public static void addTestSuites(TestSuite suite) {
  }
  
  /**
   * Construct a new Web Message GWT Test Suite.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   */
  private WebMessageGwtTestSuite() {
    super("Web Message GWT Test Suite.");
  }
}