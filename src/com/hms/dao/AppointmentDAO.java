package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hms.config.dbConnection;
import com.hms.model.Appointment;

public class AppointmentDAO {

    // BOOK APPOINTMENT
    public void bookAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments(doctor_id, patient_id, appointment_date) VALUES(?,?,?)";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getDoctorId());
            ps.setInt(2, appointment.getPatientId());
            ps.setDate(3, appointment.getAppointmentDate());

            ps.executeUpdate();
            System.out.println("✅ Appointment booked successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW APPOINTMENTS
    public void viewAppointments() {
        String sql = """
                SELECT a.id, d.name AS doctor, p.name AS patient, a.appointment_date
                FROM appointments a
                JOIN doctors d ON a.doctor_id = d.id
                JOIN patients p ON a.patient_id = p.id
                """;

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Appointments ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("doctor") + " | " +
                                rs.getString("patient") + " | " +
                                rs.getDate("appointment_date")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
