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
import org.slf4j.Marker;

/**
 * Mock Logger.
 * <p>
 * Created: 20th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public final class MockLogger implements Logger {
  /** The name. */
  private final String name;
  
  /**
   * Construct a new Mock Logger.
   *
   * @param name The name.
   */
  public MockLogger(String name) {
    this.name = name;
  }

  /**
   * @see Logger#getName()
   */
  public String getName() {
    return name;
  }

  /**
   * @see Logger#isTraceEnabled()
   */
  public boolean isTraceEnabled() {
    return false;
  }

  /**
   * @see Logger#trace(String)
   */
  public void trace(String msg) {
  }

  /**
   * @see Logger#trace(String, Object)
   */
  public void trace(String format, Object arg) {
  }

  /**
   * @see Logger#trace(String, Object, Object)
   */
  public void trace(String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#trace(String, Object[])
   */
  public void trace(String format, Object[] argArray) {
  }

  /**
   * @see Logger#trace(String, Throwable)
   */
  public void trace(String msg, Throwable t) {
  }

  /**
   * @see Logger#isTraceEnabled(Marker)
   */
  public boolean isTraceEnabled(Marker marker) {
    return false;
  }

  /**
   * @see Logger#trace(Marker, String)
   */
  public void trace(Marker marker, String msg) {
  }

  /**
   * @see Logger#trace(Marker, String, Object)
   */
  public void trace(Marker marker, String format, Object arg) {
  }

  /**
   * @see Logger#trace(Marker, String, Object, Object)
   */
  public void trace(Marker marker, String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#trace(Marker, String, Object[])
   */
  public void trace(Marker marker, String format, Object[] argArray) {
  }

  /**
   * @see Logger#trace(Marker, String, Throwable)
   */
  public void trace(Marker marker, String msg, Throwable t) {
  }

  /**
   * @see Logger#isDebugEnabled()
   */
  public boolean isDebugEnabled() {
    return false;
  }

  /**
   * @see Logger#debug(String)
   */
  public void debug(String msg) {
  }

  /**
   * @see Logger#debug(String, Object)
   */
  public void debug(String format, Object arg) {
  }

  /**
   * @see Logger#debug(String, Object, Object)
   */
  public void debug(String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#debug(String, Object[])
   */
  public void debug(String format, Object[] argArray) {
  }

  /**
   * @see Logger#debug(String, Throwable)
   */
  public void debug(String msg, Throwable t) {
  }

  /**
   * @see Logger#isDebugEnabled(Marker)
   */
  public boolean isDebugEnabled(Marker marker) {
    return false;
  }

  /**
   * @see Logger#debug(Marker, String)
   */
  public void debug(Marker marker, String msg) {
  }

  /**
   * @see Logger#debug(Marker, String, Object)
   */
  public void debug(Marker marker, String format, Object arg) {
  }

  /**
   * @see Logger#debug(Marker, String, Object, Object)
   */
  public void debug(Marker marker, String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#debug(Marker, String, Object[])
   */
  public void debug(Marker marker, String format, Object[] argArray) {
  }

  /**
   * @see Logger#debug(Marker, String, Throwable)
   */
  public void debug(Marker marker, String msg, Throwable t) {
  }

  /**
   * @see Logger#isInfoEnabled()
   */
  public boolean isInfoEnabled() {
    return false;
  }

  /**
   * @see Logger#info(String)
   */
  public void info(String msg) {
  }

  /**
   * @see Logger#info(String, Object)
   */
  public void info(String format, Object arg) {
  }

  /**
   * @see Logger#info(String, Object, Object)
   */
  public void info(String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#info(String, Object[])
   */
  public void info(String format, Object[] argArray) {
  }

  /**
   * @see Logger#info(String, Throwable)
   */
  public void info(String msg, Throwable t) {
  }

  /**
   * @see Logger#isInfoEnabled(Marker)
   */
  public boolean isInfoEnabled(Marker marker) {
    return false;
  }

  /**
   * @see Logger#info(Marker, String)
   */
  public void info(Marker marker, String msg) {
  }

  /**
   * @see Logger#info(Marker, String, Object)
   */
  public void info(Marker marker, String format, Object arg) {
  }

  /**
   * @see Logger#info(Marker, String, Object, Object)
   */
  public void info(Marker marker, String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#info(Marker, String, Object[])
   */
  public void info(Marker marker, String format, Object[] argArray) {
  }

  /**
   * @see Logger#info(Marker, String, Throwable)
   */
  public void info(Marker marker, String msg, Throwable t) {
  }

  /**
   * @see Logger#isWarnEnabled()
   */
  public boolean isWarnEnabled() {
    return false;
  }

  /**
   * @see Logger#warn(String)
   */
  public void warn(String msg) {
  }

  /**
   * @see Logger#warn(String, Object)
   */
  public void warn(String format, Object arg) {
  }

  /**
   * @see Logger#warn(String, Object[])
   */
  public void warn(String format, Object[] argArray) {
  }

  /**
   * @see Logger#warn(String, Object, Object)
   */
  public void warn(String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#warn(String, Throwable)
   */
  public void warn(String msg, Throwable t) {
  }

  /**
   * @see Logger#isWarnEnabled(Marker)
   */
  public boolean isWarnEnabled(Marker marker) {
    return false;
  }

  /**
   * @see Logger#warn(Marker, String)
   */
  public void warn(Marker marker, String msg) {
  }

  /**
   * @see Logger#warn(Marker, String, Object)
   */
  public void warn(Marker marker, String format, Object arg) {
  }

  /**
   * @see Logger#warn(Marker, String, Object, Object)
   */
  public void warn(Marker marker, String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#warn(Marker, String, Object[])
   */
  public void warn(Marker marker, String format, Object[] argArray) {
  }

  /**
   * @see Logger#warn(Marker, String, Throwable)
   */
  public void warn(Marker marker, String msg, Throwable t) {
  }

  /**
   * @see Logger#isErrorEnabled()
   */
  public boolean isErrorEnabled() {
    return false;
  }

  /**
   * @see Logger#error(String)
   */
  public void error(String msg) {
  }

  /**
   * @see Logger#error(String, Object)
   */
  public void error(String format, Object arg) {
  }

  /**
   * @see Logger#error(String, Object, Object)
   */
  public void error(String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#error(String, Object[])
   */
  public void error(String format, Object[] argArray) {
  }

  /**
   * @see Logger#error(String, Throwable)
   */
  public void error(String msg, Throwable t) {
  }

  /**
   * @see Logger#isErrorEnabled(Marker)
   */
  public boolean isErrorEnabled(Marker marker) {
    return false;
  }

  /**
   * @see Logger#error(Marker, String)
   */
  public void error(Marker marker, String msg) {
  }

  /**
   * @see Logger#error(Marker, String, Object)
   */
  public void error(Marker marker, String format, Object arg) {
  }

  /**
   * @see Logger#error(Marker, String, Object, Object)
   */
  public void error(Marker marker, String format, Object arg1, Object arg2) {
  }

  /**
   * @see Logger#error(Marker, String, Object[])
   */
  public void error(Marker marker, String format, Object[] argArray) {
  }

  /**
   * @see Logger#error(Marker, String, Throwable)
   */
  public void error(Marker marker, String msg, Throwable t) {
  }
}
