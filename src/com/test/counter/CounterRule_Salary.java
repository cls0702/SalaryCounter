package com.test.counter;

import com.test.bean.Employee;

import java.math.BigDecimal;

public class CounterRule_Salary implements CounterRule<Employee> {
    private float hard;

    public BigDecimal count(Employee employee) {
        return new BigDecimal(hard);
    };

    public CounterRule_Salary(float hard) {
        this.hard = hard;
    }

    public CounterRule_Salary() {
    }

    public float getBase() {
        return hard;
    }

    public void setBase(float hard) {
        this.hard = hard;
    }

}
