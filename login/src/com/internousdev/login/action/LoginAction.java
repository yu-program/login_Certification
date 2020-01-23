package com.internousdev.login.action;

import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//struts2のActionSupportというクラスを継承する。(Actionクラスは基本的にこのクラスを継承する)
public class LoginAction extends ActionSupport {
//フィールド変数の定義。JSPから受け取った値を入れる。必ず、JSPと同じ変数名にする。
	private String name;
	private String password;

//execute()メソッドを定義。結果はERRORかSUCCESSで返す。これによりstruts.xmlに定義した遷移先に振り分けられる。
	public String execute() throws SQLException{
//メソッドの戻り値を定義。初期値はERROR
		String ret = ERROR;

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

//JSPから送られてきたnameとpasswordを引数として、LoginDAOクラスのselectメソッドを呼び出す。その後LoginDAOで
//取得した結果をLoginDTOに代入する。
		dto = dao.select(name,password);
//ユーザーが入力したnameとpassword　と　DTOからgetしてきたdto.getNameとdto.getPasswordがそれぞれ一致するかを確認。
		if(name.equals(dto.getName())) {
			if(password.equals(dto.getPassword())) {
				//条件をみたしたらretにSUCCESSを格納。
				ret = SUCCESS;
			}
		}
	return ret;
	}

	public String getName() {
		return name;
	}
//setterを定義することで、JSPでユーザーが入力したnameとpasswordの値がそれぞれのフィールド変数に格納される。
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
//setterを定義することで、JSPでユーザーが入力したnameとpasswordの値がそれぞれのフィールド変数に格納される。
	public void setPassword(String password) {
		this.password = password;
	}
}
