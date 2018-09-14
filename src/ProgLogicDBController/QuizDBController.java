/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicDBController;

import ProgLogicModel.LoginModel;
import ProgLogicModel.QuizModel;
import ProgLogicModel.TestModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MAHBUB
 */
public class QuizDBController {

    DBConnect dbConnect = new DBConnect();
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public boolean saveQuiz(QuizModel quizModel) {
        boolean value = false;
        try {
            String sql = "insert into quiz values (?,?,?,?,?,?,?)";
            ps = dbConnect.connect().prepareStatement(sql);
            ps.setString(1, "0");
            ps.setString(2, quizModel.getQuizId());
            ps.setString(3, quizModel.getQuizName());
            ps.setString(4, String.valueOf(quizModel.getNoOfQuestions()));
            ps.setString(5, String.valueOf(quizModel.getTime()));
            ps.setString(6, quizModel.getAccessPass());
            ps.setString(7, quizModel.getAddByUser());
            ps.execute();
            ps.close();
            value = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                dbConnect.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public ArrayList<QuizModel> getAllQuiz() {

        ArrayList<QuizModel> quizModels = new ArrayList<QuizModel>();

        try {
            String sql = "SELECT * FROM quiz";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuizModel quizModel = new QuizModel();
                quizModel.setQuizNo(Integer.valueOf(rs.getString("quizNo")));
                quizModel.setQuizId(rs.getString("quizId"));
                quizModel.setQuizName(rs.getString("quizName"));
                quizModel.setNoOfQuestions(Integer.valueOf(rs.getString("noOfQuestions")));
                quizModel.setTime(Integer.valueOf(rs.getString("time")));
                quizModel.setAccessPass(rs.getString("accessPass"));
                quizModel.setAddByUser(rs.getString("addByUser"));
                quizModels.add(quizModel);
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return quizModels;
    }

    public ArrayList<QuizModel> getAllQuizByTEacherID(String id) {

        ArrayList<QuizModel> quizModels = new ArrayList<QuizModel>();

        try {
            String sql = "SELECT * FROM quiz where addByUser = '" + id + "'";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuizModel quizModel = new QuizModel();
                quizModel.setQuizNo(Integer.valueOf(rs.getString("quizNo")));
                quizModel.setQuizId(rs.getString("quizId"));
                quizModel.setQuizName(rs.getString("quizName"));
                quizModel.setNoOfQuestions(Integer.valueOf(rs.getString("noOfQuestions")));
                quizModel.setTime(Integer.valueOf(rs.getString("time")));
                quizModel.setAccessPass(rs.getString("accessPass"));
                quizModel.setAddByUser(rs.getString("addByUser"));
                quizModels.add(quizModel);
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return quizModels;
    }

    public QuizModel getQuizByQuizName(String quizName) {

        QuizModel quizModel = new QuizModel();

        try {
            String sql = "SELECT * FROM quiz where quizName = '" + quizName + "'";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                quizModel.setQuizNo(Integer.valueOf(rs.getString("quizNo")));
                quizModel.setQuizId(rs.getString("quizId"));
                quizModel.setQuizName(rs.getString("quizName"));
                quizModel.setNoOfQuestions(Integer.valueOf(rs.getString("noOfQuestions")));
                quizModel.setTime(Integer.valueOf(rs.getString("time")));
                quizModel.setAccessPass(rs.getString("accessPass"));
                quizModel.setAddByUser(rs.getString("addByUser"));
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return quizModel;
    }

    public void updateQuizModel(QuizModel quizModel) {
        try {
            stmt = dbConnect.connect().createStatement();
            String sql = "update quiz set time='" + quizModel.getTime() + "',"
                    + "accessPass='" + quizModel.getAccessPass() + "' where quizId='" + quizModel.getQuizId() + "'";
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
