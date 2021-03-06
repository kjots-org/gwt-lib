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
import org.mockito.Matchers.same
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
 * Signal Event Specification.
 * <p>
 * Created: 16th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@RunWith(classOf[JUnitRunner])
class SignalEventSpec extends Spec
  with GivenWhenThen
  with MustMatchers
  with MockitoSugar {
  
  describe("A SignalEvent") {
    it("should be fired on an EventBus when a Signal is raised") {
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
    
    it("should be fired on an EventBus from a source when a Signal is raised from a source") {
      given("a source, Signal and an EventBus")
      val source = this
      val signal = new Signal("TestSignal")
      val eventBus = mock[EventBus]
      
      when("the Signal is raised on the EventBus from the source")
      signal.raise(eventBus, source)
      
      then("a SignalEvent is fired on the EventBus from the source")
      val argument = ArgumentCaptor.forClass(classOf[GwtEvent[_]])
      
      verify(eventBus).fireEventFromSource(argument.capture(), same(source))
      
      argument.getValue().isInstanceOf[SignalEvent] must be (true)
      
      and("the SignalEvent contains the Signal")
      argument.getValue().asInstanceOf[SignalEvent].getSignal() must be theSameInstanceAs (signal)
    }
  }
}
