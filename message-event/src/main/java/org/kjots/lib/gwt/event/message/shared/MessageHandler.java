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
package org.kjots.lib.gwt.event.message.shared;

import com.google.gwt.event.shared.EventHandler;

/**
 * Message Handler.
 * <p>
 * Created: 5th December 2011.
 *
 * @param <T> The type of the message.
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public interface MessageHandler<T> extends EventHandler {
  /**
   * Receive notification that a message has been sent.
   * 
   * @param messageType The message type.
   * @param message The message.
   */
  public abstract void onMessage(MessageType<T> messageType, T message);
}
