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
package org.kjots.lib.gwt.event.message.shared

import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.mockito.ArgumentCaptor
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import org.scalatest.mock.MockitoSugar
import org.scalatest.GivenWhenThen
import org.scalatest.Spec
import com.google.gwt.event.shared.GwtEvent
import com.google.web.bindery.event.shared.EventBus

/**
 * Message Event Specification.
 * <p>
 * Created: 5th December 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@RunWith(classOf[JUnitRunner])
class MessageEventSpec extends Spec
  with GivenWhenThen
  with MustMatchers
  with MockitoSugar {

  describe("A MessageEvent") {
    it("should be fired on an EventBus when a message is sent") {
      given("a MessageType, a message and an EventBus")
      val messageType = new MessageType[String]("TestMessageType")
      val message = "Test Message"
      val eventBus = mock[EventBus]

      when("the message is sent on the EventBus")
      messageType.send(eventBus, message);

      then("a MessageEvent is fired on the EventBus")
      val argument = ArgumentCaptor.forClass(classOf[GwtEvent[_]])

      verify(eventBus).fireEvent(argument.capture())

      argument.getValue().isInstanceOf[MessageEvent[_]] must be (true)

      and("the MessageEvent contains the MessageType")
      argument.getValue().asInstanceOf[MessageEvent[String]].getMessageType() must be theSameInstanceAs (messageType)

      and("the MessageEvent contains the message")
      argument.getValue().asInstanceOf[MessageEvent[String]].getMessage() must be theSameInstanceAs (message)
    }
  }
}
