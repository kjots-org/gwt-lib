/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.js.util.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.kjots.lib.gwt.js.util.client.JsAnyGwtTest;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * JavaScript Utilities GWT Test Suite.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class JsUtilsGwtTestSuite extends GWTTestSuite {
  /**
   * Create the test suite.
   *
   * @return The test suite.
   */
  public static Test suite() {
    JsUtilsGwtTestSuite suite = new JsUtilsGwtTestSuite();
    
    addTestSuites(suite);
    
    return suite;
  }
  
  /**
   * Add the test suites.
   *
   * @param suite The test suite.
   */
  public static void addTestSuites(TestSuite suite) {
    suite.addTestSuite(JsAnyGwtTest.class);
  }
  
  /**
   * Construct a new JavaScript Utilities GWT Test Suite.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   */
  private JsUtilsGwtTestSuite() {
    super("JavaScript Utilities GWT Test Suite.");
  }
}
