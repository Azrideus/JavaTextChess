package com.company.Classes;

public class Constant {
	public  static String regexAcceptableCharacters="[a-zA-Z0-9]*";
	public  static String regexRegister="register (.*?) (.*?)$";
	public  static String regexLogin="login (.*?) (.*?)$";
	public  static String regexRemove="remove (.*?) (.*?)$";
	public  static String errNotExistPlayer="no user exists with this username";
	public  static String errInvalidUsername="username format is invalid";
	public  static String errInvalidPass="password format is invalid";
	public  static String errUserAlreadyExist="a user exists with this username";
	public  static String errincorrectPass="incorrect password";
	public  static String successRegister="register successful";
	public  static String successLogin="login successful";
	public  static String successRemove="removed * successfully";
	public  static String errInvalidCmd="invalid command";
}