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

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Message Type.
 * <p>
 * Created: 5th December 2011.
 *
 * @param <T> The type of the message.
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class MessageType<T> extends GwtEvent.Type<MessageHandler<T>> {
  /** The name of the message type. */
  private final String name;
  
  /**
   * Construct a new Message Type.
   *
   * @param name The name of the message type.
   */
  public MessageType(String name) {
    this.name = name;
  }
  
  /**
   * Retrieve the name of the message type.
   *
   * @return The name of the message type.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Send the given message over the given event bus.
   *
   * @param eventBus The event bus.
   * @param message The message.
   */
  public void send(EventBus eventBus, T message) {
    MessageEvent.fire(eventBus, this, message);
  }
  
  /**
   * Send the given message over the given event bus from the given source.
   *
   * @param eventBus The event bus.
   * @param message The message.
   * @param source The source.
   */
  public void send(EventBus eventBus, T message, Object source) {
    MessageEvent.fire(eventBus, this, message, source);
  }
  
  /**
   * Create a string representation of this object.
   *
   * @return The string representation of this object.
   */
  @Override
  public String toString() {
    return this.name;
  }
}
