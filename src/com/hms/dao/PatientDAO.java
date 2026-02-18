package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hms.config.dbConnection;
import com.hms.model.Patient;

public class PatientDAO {

    // ADD PATIENT
    public void addPatient(Patient patient) {
        String sql = "INSERT INTO patients(name, age, gender, phone) VALUES(?,?,?,?)";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());

            ps.executeUpdate();
            System.out.println("✅ Patient added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW PATIENTS
    public void viewPatients() {
        String sql = "SELECT * FROM patients";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Patient List ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("gender") + " | " +
                                rs.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
