package com.internousdev.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

public class LoginDAO {
//LoginDTO型を最後に呼び出し元に渡すため、LoginDTO型を戻り値にするメソッドを作成する。
//そのため、Actionクラスの値を引数として受け取る。
	public LoginDTO select(String name,String password) throws SQLException{
		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from user where user_name=? and password=?";

		try {
		//PreparedStatementはDBまで値を運んでくれる箱のイメージ
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, password);
//select文を実行する(executeQuery())と必ず戻り値はResultSetが返ってくる。
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
			//select文で取得した情報をString型に変換(setString(""))してDTOクラスに格納する。
			//LoginDTOクラスのsetName,setPasswordを利用している。(dtoをどこからインスタンスしているのか見ればわかる)
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		//dtoに入った値を呼び出し元であるActionクラスに返す。
		return dto;
	}
}
