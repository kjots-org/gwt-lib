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
package org.kjots.lib.gwt.event.signal.shared

import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.mockito.ArgumentCaptor
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import org.scalatest.mock.MockitoSugar
import org.scalatest.GivenWhenThen
import org.scalatest.Spec

import com.google.gwt.event.shared.EventBus
import com.google.gwt.event.shared.GwtEvent

/**
 * Signal Specification.
 * <p>
 * Created: 16th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@RunWith(classOf[JUnitRunner])
class SignalSpec extends Spec
  with GivenWhenThen
  with MustMatchers
  with MockitoSugar {
  
  describe("A Signal") {
    it("should fire a SignalEvent when raised on an EventBus") {
      given("a Signal and an EventBus")
      val signal = new Signal("TestSignal")
      val eventBus = mock[EventBus]
      
      when("the Signal is raised on the EventBus")
      signal.raise(eventBus)
      
      then("a SignalEvent is fired on the EventBus")
      val argument = ArgumentCaptor.forClass(classOf[GwtEvent[_]])
      
      verify(eventBus).fireEvent(argument.capture())
      
      argument.getValue().isInstanceOf[SignalEvent] must be (true)
      
      and("the SignalEvent contains the Signal")
      argument.getValue().asInstanceOf[SignalEvent].getSignal() must be theSameInstanceAs (signal)
    }
  }
}
