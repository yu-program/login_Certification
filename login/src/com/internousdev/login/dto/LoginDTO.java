//DTOクラスの役割は、DAOでselectされた値を格納する。
//getterでActionへ値を渡す(Actionクラスが呼び出す)。setterで自身のフィールド変数に値を格納する。(DAOクラスが呼び出す)
package com.internousdev.login.dto;

public class LoginDTO {

//	カラム名と同じフィールド変数を記述する。
	private int id;
	private String name;
	private String password;

//	getter,setterを用意。
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

//	Actionクラスから呼び出され、nameのフィールド値をActionに渡す。
	public String getPassword() {
		return password;
	}
//	DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のnameフィールドに格納する。
	public void setPassword(String password) {
		this.password = password;
	}
}
