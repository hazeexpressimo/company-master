package com.example.company.data;

public class Company {

    private int earnings;
    private int positiveEmployees;
    private int negativeEmployees;

    public Company(int earnings, int positiveEmployees, int negativeEmployees) {
        this.earnings = earnings;
        this.positiveEmployees = positiveEmployees;
        this.negativeEmployees = negativeEmployees;
    }

    public Company() {
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getPositiveEmployees() {
        return positiveEmployees;
    }

    public void setPositiveEmployees(int positiveEmployees) {
        this.positiveEmployees = positiveEmployees;
    }

    public int getNegativeEmployees() {
        return negativeEmployees;
    }

    public void setNegativeEmployees(int negativeEmployees) {
        this.negativeEmployees = negativeEmployees;
    }
}
