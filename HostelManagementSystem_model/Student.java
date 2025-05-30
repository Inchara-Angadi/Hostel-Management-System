package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Student {
    private int studentId;
    private String studentName;
    private String roomNumber;
    private LocalDate admissionDate;
    private BigDecimal feesPaid;
    private BigDecimal pendingFees;

    // Constructors
    public Student() {
    }

    public Student(int studentId, String studentName, String roomNumber, LocalDate admissionDate,
                   BigDecimal feesPaid, BigDecimal pendingFees) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.roomNumber = roomNumber;
        this.admissionDate = admissionDate;
        this.feesPaid = feesPaid;
        this.pendingFees = pendingFees;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public BigDecimal getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(BigDecimal feesPaid) {
        this.feesPaid = feesPaid;
    }

    public BigDecimal getPendingFees() {
        return pendingFees;
    }

    public void setPendingFees(BigDecimal pendingFees) {
        this.pendingFees = pendingFees;
    }
}
