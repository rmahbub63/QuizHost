/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicDBController;

import ProgLogicModel.QuestionModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MAHBUB
 */
public class QuestionDBController {

    DBConnect dbConnect = new DBConnect();
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public boolean saveAllQuestion(ArrayList<QuestionModel> questionModelList) {
        boolean value = false;
        try {
            String sql = "insert into question values (?,?,?,?,?,?,?,?,?)";
            ps = dbConnect.connect().prepareStatement(sql);
            for (int i = 0; i < questionModelList.size(); i++) {
                ps.setString(1, "0");
                ps.setString(2, questionModelList.get(i).getQuestionStatement());
                ps.setString(3, questionModelList.get(i).getOptionOne());
                ps.setString(4, questionModelList.get(i).getOptionTwo());
                ps.setString(5, questionModelList.get(i).getOptionThree());
                ps.setString(6, questionModelList.get(i).getOptionFour());
                ps.setString(7, questionModelList.get(i).getQuizId());
                ps.setString(8, questionModelList.get(i).getQuizName());
                ps.setString(9, questionModelList.get(i).getAnswer());
                ps.execute();
            }
            value = true;
            ps.close();
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

    public ArrayList<QuestionModel> getAllQuestionByQuizIdAndQuizName(String quizId, String quizName) {

        ArrayList<QuestionModel> questionModelList = new ArrayList<QuestionModel>();
        try {
            String sql = "SELECT * FROM question where quizId = '" + quizId + "' and quizName = '" + quizName + "'";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionModel questionModel = new QuestionModel();
                questionModel.setQuestionNo(Integer.valueOf(rs.getString("questionNo")));
                questionModel.setQuestionStatement(rs.getString("questionStatement"));
                questionModel.setOptionOne(rs.getString("optionOne"));
                questionModel.setOptionTwo(rs.getString("optionTwo"));
                questionModel.setOptionThree(rs.getString("optionThree"));
                questionModel.setOptionFour(rs.getString("optionFour"));
                questionModel.setQuizId(rs.getString("quizId"));
                questionModel.setQuizName(rs.getString("quizName"));
                questionModel.setAnswer(rs.getString("answer"));
                questionModelList.add(questionModel);
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return questionModelList;
    }
}
