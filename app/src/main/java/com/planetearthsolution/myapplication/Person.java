package com.planetearthsolution.myapplication;



public class Person {

    private long id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String gender;
    private String date_of_birth;
    private String citizenship_no;
    private String driving_license_no;
    private String ph_no;
    private String permanent_address;
    private String occupation;
    private String spouse_name;
    private String father_name;
    private String father_contact;
    private String mother_name;
    private String mother_contact;
    private String grandfather_name;

    public Person() {
    }
    public Person(String first_name, String middle_name, String last_name, String gender, String date_of_birth, String citizenship_no, String driving_license_no, String ph_no, String permanent_address, String occupation, String spouse_name, String father_name, String father_contact, String mother_name, String mother_contact, String grandfather_name) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.citizenship_no = citizenship_no;
        this.driving_license_no = driving_license_no;
        this.ph_no = ph_no;
        this.permanent_address = permanent_address;
        this.occupation = occupation;
        this.spouse_name = spouse_name;
        this.father_name = father_name;
        this.father_contact = father_contact;
        this.mother_name = mother_name;
        this.mother_contact = mother_contact;
        this.grandfather_name = grandfather_name;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCitizenship_no() {
        return citizenship_no;
    }

    public void setCitizenship_no(String citizenship_no) {
        this.citizenship_no = citizenship_no;
    }

    public String getDriving_license_no() {
        return driving_license_no;
    }

    public void setDriving_license_no(String driving_license_no) {
        this.driving_license_no = driving_license_no;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSpouse_name() {
        return spouse_name;
    }

    public void setSpouse_name(String spouse_name) {
        this.spouse_name = spouse_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getFather_contact() {
        return father_contact;
    }

    public void setFather_contact(String father_contact) {
        this.father_contact = father_contact;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getMother_contact() {
        return mother_contact;
    }

    public void setMother_contact(String mother_contact) {
        this.mother_contact = mother_contact;
    }

    public String getGrandfather_name() {
        return grandfather_name;
    }

    public void setGrandfather_name(String grandfather_name) {
        this.grandfather_name = grandfather_name;
    }
}
