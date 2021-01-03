package com.test.counter;

import com.test.bean.Employee;

import java.math.BigDecimal;

public class CounterRule_Sale implements CounterRule<Employee> {

    float baseSalary;
    float [] overSoldSteps; // {20000f, 30000f}
    float [] overSoldPromoteFactor; // {1.05f, 1.08f}

    @Override
    public BigDecimal count(Employee employee) {
        float soldAmount = employee.getAmount();

        final BigDecimal baseSalary = new BigDecimal(this.baseSalary);

        if (soldAmount <= 0f){
            return BigDecimal.ZERO;
        } else if (soldAmount <= overSoldSteps[0]){
            return baseSalary;
        } else {
            int index = overSoldSteps.length-1;
            while (overSoldSteps[index] >= soldAmount) {
                index --;
            }

            final BigDecimal overAmount = new BigDecimal(soldAmount).subtract(new BigDecimal(overSoldSteps[0]));
            final BigDecimal overPart = overAmount.multiply(new BigDecimal(overSoldPromoteFactor[index]));
            return baseSalary.add(overPart);
        }
    }

    public CounterRule_Sale(float baseSalary, float[] overSoldSteps, float[] overSoldPromoteFactor) {
        this.baseSalary = baseSalary;
        this.overSoldSteps = overSoldSteps;
        this.overSoldPromoteFactor = overSoldPromoteFactor;
    }

    public CounterRule_Sale() {
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public float[] getOverSoldSteps() {
        return overSoldSteps;
    }

    public void setOverSoldSteps(float[] overSoldSteps) {
        this.overSoldSteps = overSoldSteps;
    }

    public float[] getOverSoldPromoteFactor() {
        return overSoldPromoteFactor;
    }

    public void setOverSoldPromoteFactor(float[] overSoldPromoteFactor) {
        this.overSoldPromoteFactor = overSoldPromoteFactor;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setAmount(30001f);
        float[] overSoldSteps = {20000f,30000f};
        float[] overSoldFactors = {0.1f,0.5f};
        CounterRule_Sale counter_sale = new CounterRule_Sale(3000f, overSoldSteps, overSoldFactors);
        final BigDecimal count = counter_sale.count(employee);
        System.out.println(count);
    }

}
