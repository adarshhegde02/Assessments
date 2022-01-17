package com.mobile_application;

public class NotAddedException extends RuntimeException {
@Override
public String getMessage() {
	return "Not Added...";
}
}
