package com.hms.model;

import java.sql.Date;

public class Appointment {

    private int id;
    private int doctorId;
    private int patientId;
    private Date appointmentDate;

    public Appointment() {}

    public Appointment(int doctorId, int patientId, Date appointmentDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
    }

    public int getId() {
        return id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }
}

