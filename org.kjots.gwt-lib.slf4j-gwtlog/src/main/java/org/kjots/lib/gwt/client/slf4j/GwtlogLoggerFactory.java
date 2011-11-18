/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.client.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.helpers.MarkerIgnoringBase;

import com.allen_sauer.gwt.log.client.Log;

/**
 * gwt-log Logger Factory.
 * <p>
 * Created: 17th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class GwtlogLoggerFactory extends GwtLoggerFactory {
  /** The gwt-log logger. */
  @SuppressWarnings("serial")
  public static final Logger gwtlogLogger = new MarkerIgnoringBase() {
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
      Log.trace(msg);
    }

    /**
     * @see Logger#trace(String, Object)
     */
    @Override
    public void trace(String format, Object arg) {
      Log.trace(format(format, arg));
    }

    /**
     * @see Logger#trace(String, Object, Object)
     */
    @Override
    public void trace(String format, Object arg1, Object arg2) {
      Log.trace(format(format, arg1, arg2));
    }

    /**
     * @see Logger#trace(String, Object[])
     */
    @Override
    public void trace(String format, Object[] argArray) {
      Log.trace(format(format, argArray));
    }

    /**
     * @see Logger#trace(String, Throwable)
     */
    @Override
    public void trace(String msg, Throwable t) {
      Log.trace(msg, t);
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
      Log.debug(msg);
    }

    /**
     * @see Logger#debug(String, Object)
     */
    @Override
    public void debug(String format, Object arg) {
      Log.debug(format(format, arg));
    }

    /**
     * @see Logger#debug(String, Object, Object)
     */
    @Override
    public void debug(String format, Object arg1, Object arg2) {
      Log.debug(format(format, arg1, arg2));
    }

    /**
     * @see Logger#debug(String, Object[])
     */
    @Override
    public void debug(String format, Object[] argArray) {
      Log.debug(format(format, argArray));
    }

    /**
     * @see Logger#debug(String, Throwable)
     */
    @Override
    public void debug(String msg, Throwable t) {
      Log.debug(msg, t);
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
      Log.info(msg);
    }

    /**
     * @see Logger#info(String, Object)
     */
    @Override
    public void info(String format, Object arg) {
      Log.info(format(format, arg));
    }

    /**
     * @see Logger#info(String, Object, Object)
     */
    @Override
    public void info(String format, Object arg1, Object arg2) {
      Log.info(format(format, arg1, arg2));
    }

    /**
     * @see Logger#info(String, Object[])
     */
    @Override
    public void info(String format, Object[] argArray) {
      Log.info(format(format, argArray));
    }

    /**
     * @see Logger#info(String, Throwable)
     */
    @Override
    public void info(String msg, Throwable t) {
      Log.info(msg, t);
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
      Log.warn(msg);
    }

    /**
     * @see Logger#warn(String, Object)
     */
    @Override
    public void warn(String format, Object arg) {
      Log.warn(format(format, arg));
    }

    /**
     * @see Logger#warn(String, Object, Object)
     */
    @Override
    public void warn(String format, Object arg1, Object arg2) {
      Log.warn(format(format, arg1, arg2));
    }

    /**
     * @see Logger#warn(String, Object[])
     */
    @Override
    public void warn(String format, Object[] argArray) {
      Log.warn(format(format, argArray));
    }

    /**
     * @see Logger#warn(String, Throwable)
     */
    @Override
    public void warn(String msg, Throwable t) {
      Log.warn(msg, t);
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
      Log.error(msg);
    }

    /**
     * @see Logger#error(String, Object)
     */
    @Override
    public void error(String format, Object arg) {
      Log.error(format(format, arg));
    }

    /**
     * @see Logger#error(String, Object, Object)
     */
    @Override
    public void error(String format, Object arg1, Object arg2) {
      Log.error(format(format, arg1, arg2));
    }

    /**
     * @see Logger#error(String, Object[])
     */
    @Override
    public void error(String format, Object[] argArray) {
      Log.error(format(format, argArray));
    }

    /**
     * @see Logger#error(String, Throwable)
     */
    @Override
    public void error(String msg, Throwable t) {
      Log.error(msg, t);
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
  };
  
  /**
   * @see ILoggerFactory#getLogger(String)
   */
  @Override
  public Logger getLogger(String name) {
    return gwtlogLogger;
  }
}
