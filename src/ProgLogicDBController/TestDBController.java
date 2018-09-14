/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicDBController;

import ProgLogicModel.TestModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MAHBUB
 */
public class TestDBController {

    DBConnect dbConnect = new DBConnect();
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<TestModel> getAllTest() {

        ArrayList<TestModel> testModels = new ArrayList<TestModel>();

        try {
            String sql = "SELECT * FROM test";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TestModel testModel = new TestModel();
                testModel.setTestNo(Integer.valueOf(rs.getString("testNo")));
                testModel.setTestName(rs.getString("testName"));
                testModel.setTime(Integer.valueOf(rs.getString("time")));
                testModel.setTotalQuestion(Integer.valueOf(rs.getString("totalQ")));
                testModel.setAccessPass(rs.getString("accessPass"));
                testModel.setExamineePass(rs.getString("examineePass"));
                testModels.add(testModel);
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return testModels;
    }
    
    public TestModel getTestByTestName(String testName) {
        
        TestModel testModel = new TestModel();

        try {
            String sql = "SELECT * FROM test where testName = '" + testName +"'";
            ps = dbConnect.connect().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                testModel.setTestNo(Integer.valueOf(rs.getString("testNo")));
                testModel.setTestName(rs.getString("testName"));
                testModel.setTime(Integer.valueOf(rs.getString("time")));
                testModel.setTotalQuestion(Integer.valueOf(rs.getString("totalQ")));
                testModel.setAccessPass(rs.getString("accessPass"));
                testModel.setExamineePass(rs.getString("examineePass"));
            }
            ps.execute();
            ps.close();
            dbConnect.connect().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
        return testModel;
    }
}
