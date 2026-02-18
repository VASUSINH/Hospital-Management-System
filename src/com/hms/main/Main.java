package com.hms.main;

import java.sql.Date;
import java.util.Scanner;

import com.hms.dao.*;
import com.hms.model.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    System.out.print("Gender: ");
                    String gender = sc.next();
                    System.out.print("Phone: ");
                    String phone = sc.next();

                    patientDAO.addPatient(new Patient(name, age, gender, phone));
                }

                case 3 -> {
                    System.out.print("Doctor ID: ");
                    int doctorId = sc.nextInt();
                    System.out.print("Patient ID: ");
                    int patientId = sc.nextInt();
                    System.out.print("Date (yyyy-mm-dd): ");
                    Date date = Date.valueOf(sc.next());

                    appointmentDAO.bookAppointment(
                            new Appointment(doctorId, patientId, date)
                    );
                }

                case 5 -> System.exit(0);
            }
        }
    }
}
