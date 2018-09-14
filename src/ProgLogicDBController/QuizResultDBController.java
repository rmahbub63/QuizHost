/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicDBController;

import ProgLogicModel.QuizResultModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MAHBUB
 */
public class QuizResultDBController {

    DBConnect dbConnect = new DBConnect();
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public boolean saveQuizResult(QuizResultModel quizResult) {
        boolean value = false;
        try {
            String sql = "insert into quizresult values (?,?,?,?,?,?)";
            ps = dbConnect.connect().prepareStatement(sql);
            ps.setString(1, quizResult.getStudentId());
            ps.setString(2, quizResult.getQuizId());
            ps.setString(3, quizResult.getQuizName());
            ps.setString(4, String.valueOf(quizResult.getNoOfQuestions()));
            ps.setString(5, String.valueOf(quizResult.getCorrectAnswer()));
            ps.setString(6, String.valueOf(quizResult.getScoreInPercent()));
            ps.execute();
            value = true;
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return value;
    }

    public ArrayList<QuizResultModel> getAllQuizResultByUsername(String studentId) {

        ArrayList<QuizResultModel> questionAnswerList = new ArrayList<QuizResultModel>();
        try {
            String sql = "SELECT * FROM quizresult where studentId = '" + studentId + "'";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuizResultModel questionAnswer = new QuizResultModel();
                questionAnswer.setStudentId(rs.getString("studentId"));
                questionAnswer.setQuizId(rs.getString("quizId"));
                questionAnswer.setQuizName(rs.getString("quizName"));
                questionAnswer.setNoOfQuestions(Integer.valueOf(rs.getString("noOfQuestions")));
                questionAnswer.setCorrectAnswer(Integer.valueOf(rs.getString("correctAnswer")));
                questionAnswer.setScoreInPercent(Double.valueOf(rs.getString("scoreInPercent")));
                questionAnswerList.add(questionAnswer);
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return questionAnswerList;
    }

    public ArrayList<QuizResultModel> getAllQuizResultByQuizID(String quizID) {

        ArrayList<QuizResultModel> questionAnswerList = new ArrayList<QuizResultModel>();
        try {
            String sql = "SELECT * FROM quizresult where quizId = '" + quizID + "'";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuizResultModel questionAnswer = new QuizResultModel();
                questionAnswer.setStudentId(rs.getString("studentId"));
                questionAnswer.setQuizId(rs.getString("quizId"));
                questionAnswer.setQuizName(rs.getString("quizName"));
                questionAnswer.setNoOfQuestions(Integer.valueOf(rs.getString("noOfQuestions")));
                questionAnswer.setCorrectAnswer(Integer.valueOf(rs.getString("correctAnswer")));
                questionAnswer.setScoreInPercent(Double.valueOf(rs.getString("scoreInPercent")));
                questionAnswerList.add(questionAnswer);
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return questionAnswerList;
    }

}
