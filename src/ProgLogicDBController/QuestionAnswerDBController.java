/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicDBController;

import ProgLogicModel.QuestionAnswerModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MAHBUB
 */
public class QuestionAnswerDBController {

    DBConnect dbConnect = new DBConnect();
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public boolean saveAllQuestionAnswer(ArrayList<QuestionAnswerModel> questionAnswer) {
        boolean value = false;
        try {
            String sql = "insert into questionanswer values (?,?,?,?,?,?)";
            ps = dbConnect.connect().prepareStatement(sql);
            for (int i = 0; i < questionAnswer.size(); i++) {
                ps.setString(1, questionAnswer.get(i).getStudentId());
                ps.setString(2, questionAnswer.get(i).getQuizId());
                ps.setString(3, String.valueOf(questionAnswer.get(i).getQuestionNo()));
                ps.setString(4, questionAnswer.get(i).getAnswer());
                ps.setString(5, questionAnswer.get(i).getStudentAnswer());
                ps.setString(6, questionAnswer.get(i).getAnswerYet());
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

    public ArrayList<QuestionAnswerModel> getAllQuestionAnswer(String quizId, String quizName) {

        ArrayList<QuestionAnswerModel> questionAnswerList = new ArrayList<QuestionAnswerModel>();
        try {
            String sql = "SELECT * FROM question where quizId = '" + quizId + "' and quizName = '" + quizName + "'";
//            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionAnswerModel questionAnswer = new QuestionAnswerModel();
                questionAnswer.setStudentId(rs.getString("studentId"));
                questionAnswer.setQuizId(rs.getString("quizId"));
                questionAnswer.setQuestionNo(Integer.valueOf(rs.getString("questionNo")));
                questionAnswer.setAnswer(rs.getString("answer"));
                questionAnswer.setStudentAnswer(rs.getString("studentAnswer"));
                questionAnswer.setAnswerYet(rs.getString("answerYet"));
                questionAnswerList.add(questionAnswer);
            }
            ps.execute();
            ps.close();
//            dbConnect.connect().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            dbConnect.disconnect();
        }
        return questionAnswerList;
    }

}
