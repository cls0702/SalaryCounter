package com.test.counter;

import com.test.bean.Employee;

import java.math.BigDecimal;

public class CounterRule_Hour implements CounterRule<Employee> {

    float basePerHour, baseWorkHour, overFactorPerHour;

    @Override
    public BigDecimal count(Employee employee) {
        final BigDecimal basePerHour = new BigDecimal(this.basePerHour);
        final BigDecimal baseWorkHour = new BigDecimal(this.baseWorkHour);
        final BigDecimal overFactorPerHour = new BigDecimal(this.overFactorPerHour);

        float hours = employee.getWorkingHours();
        if (hours <= 0f){
            return BigDecimal.ZERO;
        } else if (hours <= this.baseWorkHour) {
            return basePerHour.multiply(new BigDecimal(hours));
        } else {
            final BigDecimal base = basePerHour.multiply(baseWorkHour);
            final BigDecimal overHours = new BigDecimal(hours).subtract(baseWorkHour);
            final BigDecimal over = overHours.multiply(basePerHour).multiply(overFactorPerHour);
            return base.add(over);
        }
    }

    public CounterRule_Hour(float basePerHour, float baseWorkHour, float overFactorPerHour) {
        this.basePerHour = basePerHour;
        this.baseWorkHour = baseWorkHour;
        this.overFactorPerHour = overFactorPerHour;
    }

    public CounterRule_Hour() {
    }

    public float getBasePerHour() {
        return basePerHour;
    }

    public void setBasePerHour(float basePerHour) {
        this.basePerHour = basePerHour;
    }

    public float getBaseWorkHour() {
        return baseWorkHour;
    }

    public void setBaseWorkHour(float baseWorkHour) {
        this.baseWorkHour = baseWorkHour;
    }

    public float getOverFactorPerHour() {
        return overFactorPerHour;
    }

    public void setOverFactorPerHour(float overFactorPerHour) {
        this.overFactorPerHour = overFactorPerHour;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setWorkingHours(200f);
        CounterRule_Hour counter_hour = new CounterRule_Hour(10f, 100f, 1.5f);
        final BigDecimal count = counter_hour.count(employee);
        System.out.println(count);
    }

}
