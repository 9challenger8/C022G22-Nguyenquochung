package com.back_end_final_module5_2.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id_record")
    private String idRecord;

    @Column(name = "id_patient")
    private String idPatient;

    @Column(name="name_patient")
    private String namePatient;

    @Column(name="start_date")
    private String startDate;

    @Column(name="out_date")
    private String outDate;

    private String issue;

    private String solution;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String idRecord, String idPatient, String namePatient, String startDate, String outDate,
                   String issue, String solution, Doctor doctor) {
        this.idRecord = idRecord;
        this.idPatient = idPatient;
        this.namePatient = namePatient;
        this.startDate = startDate;
        this.outDate = outDate;
        this.issue = issue;
        this.solution = solution;
        this.doctor = doctor;
    }

    public String getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(String idRecord) {
        this.idRecord = idRecord;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
