/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicDBController;

import ProgLogicModel.LoginModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HASAN
 */
public class LoginDBController {

    DBConnect dbConnect = new DBConnect();
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public void saveUser(LoginModel loginModel) {
        try {
            String sql = "INSERT INTO user values(?,?,?,?)";
            ps = dbConnect.connect().prepareStatement(sql);
            ps.setString(1, loginModel.getName());
            ps.setString(2, loginModel.getUsername());
            ps.setString(3, loginModel.getPassword());
            ps.setString(4, loginModel.getRole());
            ps.execute();
            ps.close();
            dbConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
            dbConnect.disconnect();

        } finally {
            // Step 5: Always free resources
            dbConnect.disconnect();
        }
    }

//	public ArrayList<Login> getAllInfo() {
//
//		ArrayList<Login> logins = new ArrayList<Login>();
//
//		try {
//			String sql = "SELECT * FROM user where username=? and password=?";
//			ps = dbConnect.connect().prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				Login login = new Login();
//				// login.setId(rs.getString("id"));
//				// login.setUsername(rs.getString("username"));
//				// login.setPassword(rs.getString("password"));
//				// login.setStatus(rs.getString("status"));
//				logins.add(login);
//			}
//			ps.execute();
//			ps.close();
//			dbConnect.connect().close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			dbConnect.disconnect();
//		}
//		return logins;
//	}
    public LoginModel getLoginInfoByUserName(String userName) {
        LoginModel login = new LoginModel();
        try {
            String sql = "SELECT * FROM user where username = '" + userName + "'";
            System.out.println(sql);
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                login.setName(rs.getString("name"));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                login.setRole(rs.getString("role"));
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return login;
    }

    public void updateUser(LoginModel loginModel) {
        try {
            stmt = dbConnect.connect().createStatement();
            String sql = "update user set name='" + loginModel.getName() + "',"
                    + "password='" + loginModel.getPassword() + "' where username='" + loginModel.getUsername()+ "'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            dbConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
    }

}
