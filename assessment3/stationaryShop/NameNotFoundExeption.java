package com.mobile_application;

public class NameNotFoundExeption extends RuntimeException{
@Override
public String getMessage() {
	// TODO Auto-generated method stub
return "Name not found...";
}
}
