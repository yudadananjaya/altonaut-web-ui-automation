package com.altonaut.db;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/altonaut_automation_data";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password";

    /**
     * Retrieves test data from the database based on the test_case_id
     *
     * @param testCaseId The ID of the test case
     * @return A JSONObject containing the test data, account data, and expected result
     * @throws SQLException If there's an error executing the query
     */
    public static JSONObject getTestData(String testCaseId) throws SQLException {
        JSONObject testData = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String query = "SELECT test_platform, account, test_data, expected_result_data FROM test_cases WHERE test_case_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, testCaseId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
              
                        String testPlatform = rs.getString("test_platform");
                        String accountData = rs.getString("account");
                        String testDataJson = rs.getString("test_data");
                        String expectedResultJson = rs.getString("expected_result_data");

                        testData = new JSONObject();
                        testData.put("test_platform", testPlatform);
                        testData.put("account", new JSONObject(accountData));
                        testData.put("test_data", new JSONObject(testDataJson));
                        testData.put("expected_result_data", new JSONObject(expectedResultJson));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving test data for test_case_id: " + testCaseId, e);
        }

        return testData;
    }
}
