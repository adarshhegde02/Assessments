package com.mobile_application;

public class NotDeletedException extends RuntimeException{
@Override
public String getMessage() {
	return "Not deleted...";
}
}
