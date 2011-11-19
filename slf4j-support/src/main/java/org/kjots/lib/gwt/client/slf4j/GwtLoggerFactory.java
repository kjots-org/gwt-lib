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

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLoggerFactory;

/**
 * GWT Logger Factory.
 * <p>
 * Created: 17th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class GwtLoggerFactory implements ILoggerFactory {
  /** The default logger factory. */
  private final ILoggerFactory defaultLoggerFactory = new NOPLoggerFactory();

  /**
   * @see ILoggerFactory#getLogger(String)
   */
  @Override
  public Logger getLogger(String name) {
    return this.defaultLoggerFactory.getLogger(name);
  }
}
