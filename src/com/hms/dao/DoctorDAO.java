package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.hms.config.dbConnection;
import com.hms.model.doctor;

public class DoctorDAO {

    public void addDoctor(doctor doctor) {
        String query = "INSERT INTO doctors(name, specialization, phone) VALUES(?,?,?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());

            ps.executeUpdate();
            System.out.println("Doctor added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
