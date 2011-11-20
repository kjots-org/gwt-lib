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
import org.slf4j.helpers.MarkerIgnoringBase;

import com.allen_sauer.gwt.log.client.Log;

/**
 * gwt-log Logger.
 * <p>
 * Created: 20th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class GwtlogLogger extends MarkerIgnoringBase {
  /**
   * Construct a new gwt-log Logger.
   *
   * @param name The name.
   */
  public GwtlogLogger(String name) {
    this.name = name;
  }
  
  /**
   * @see Logger#isTraceEnabled()
   */
  @Override
  public boolean isTraceEnabled() {
    return Log.isTraceEnabled();
  }

  /**
   * @see Logger#trace(String)
   */
  @Override
  public void trace(String msg) {
    Log.trace(this.name, msg);
  }

  /**
   * @see Logger#trace(String, Object)
   */
  @Override
  public void trace(String format, Object arg) {
    Log.trace(this.name, format(format, arg));
  }

  /**
   * @see Logger#trace(String, Object, Object)
   */
  @Override
  public void trace(String format, Object arg1, Object arg2) {
    Log.trace(this.name, format(format, arg1, arg2));
  }

  /**
   * @see Logger#trace(String, Object[])
   */
  @Override
  public void trace(String format, Object[] argArray) {
    Log.trace(this.name, format(format, argArray));
  }

  /**
   * @see Logger#trace(String, Throwable)
   */
  @Override
  public void trace(String msg, Throwable t) {
    Log.trace(this.name, msg, t);
  }

  /**
   * @see Logger#isDebugEnabled()
   */
  @Override
  public boolean isDebugEnabled() {
    return Log.isDebugEnabled();
  }

  /**
   * @see Logger#debug(String)
   */
  @Override
  public void debug(String msg) {
    Log.debug(this.name, msg);
  }

  /**
   * @see Logger#debug(String, Object)
   */
  @Override
  public void debug(String format, Object arg) {
    Log.debug(this.name, format(format, arg));
  }

  /**
   * @see Logger#debug(String, Object, Object)
   */
  @Override
  public void debug(String format, Object arg1, Object arg2) {
    Log.debug(this.name, format(format, arg1, arg2));
  }

  /**
   * @see Logger#debug(String, Object[])
   */
  @Override
  public void debug(String format, Object[] argArray) {
    Log.debug(this.name, format(format, argArray));
  }

  /**
   * @see Logger#debug(String, Throwable)
   */
  @Override
  public void debug(String msg, Throwable t) {
    Log.debug(this.name, msg, t);
  }

  /**
   * @see Logger#isInfoEnabled()
   */
  @Override
  public boolean isInfoEnabled() {
    return Log.isInfoEnabled();
  }

  /**
   * @see Logger#info(String)
   */
  @Override
  public void info(String msg) {
    Log.info(this.name, msg);
  }

  /**
   * @see Logger#info(String, Object)
   */
  @Override
  public void info(String format, Object arg) {
    Log.info(this.name, format(format, arg));
  }

  /**
   * @see Logger#info(String, Object, Object)
   */
  @Override
  public void info(String format, Object arg1, Object arg2) {
    Log.info(this.name, format(format, arg1, arg2));
  }

  /**
   * @see Logger#info(String, Object[])
   */
  @Override
  public void info(String format, Object[] argArray) {
    Log.info(this.name, format(format, argArray));
  }

  /**
   * @see Logger#info(String, Throwable)
   */
  @Override
  public void info(String msg, Throwable t) {
    Log.info(this.name, msg, t);
  }

  /**
   * @see Logger#isWarnEnabled()
   */
  @Override
  public boolean isWarnEnabled() {
    return Log.isWarnEnabled();
  }

  /**
   * @see Logger#warn(String)
   */
  @Override
  public void warn(String msg) {
    Log.warn(this.name, msg);
  }

  /**
   * @see Logger#warn(String, Object)
   */
  @Override
  public void warn(String format, Object arg) {
    Log.warn(this.name, format(format, arg));
  }

  /**
   * @see Logger#warn(String, Object, Object)
   */
  @Override
  public void warn(String format, Object arg1, Object arg2) {
    Log.warn(this.name, format(format, arg1, arg2));
  }

  /**
   * @see Logger#warn(String, Object[])
   */
  @Override
  public void warn(String format, Object[] argArray) {
    Log.warn(this.name, format(format, argArray));
  }

  /**
   * @see Logger#warn(String, Throwable)
   */
  @Override
  public void warn(String msg, Throwable t) {
    Log.warn(this.name, msg, t);
  }

  /**
   * @see Logger#isErrorEnabled()
   */
  @Override
  public boolean isErrorEnabled() {
    return Log.isErrorEnabled();
  }

  /**
   * @see Logger#error(String)
   */
  @Override
  public void error(String msg) {
    Log.error(this.name, msg);
  }

  /**
   * @see Logger#error(String, Object)
   */
  @Override
  public void error(String format, Object arg) {
    Log.error(this.name, format(format, arg));
  }

  /**
   * @see Logger#error(String, Object, Object)
   */
  @Override
  public void error(String format, Object arg1, Object arg2) {
    Log.error(this.name, format(format, arg1, arg2));
  }

  /**
   * @see Logger#error(String, Object[])
   */
  @Override
  public void error(String format, Object[] argArray) {
    Log.error(this.name, format(format, argArray));
  }

  /**
   * @see Logger#error(String, Throwable)
   */
  @Override
  public void error(String msg, Throwable t) {
    Log.error(this.name, msg, t);
  }
  
  /**
   * Format the given string with the given arguments.
   *
   * @param format The string.
   * @param args The arguments.
   * @return The formatted string.
   */
  private String format(String format, Object... args) {
    throw new UnsupportedOperationException();
  }
}
