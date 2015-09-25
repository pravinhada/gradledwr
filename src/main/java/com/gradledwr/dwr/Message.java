package com.test.dwr;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

@RemoteProxy(name = "Message")
public class Message {

	@RemoteMethod
	public String getMessage() {
		return "Hello DWR World!";
	}
}
