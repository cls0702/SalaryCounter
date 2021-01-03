package com.test;

import com.test.bean.Department;
import com.test.counter.CounterRule;
import com.test.counter.CounterRule_Hour;
import com.test.counter.CounterRule_Salary;
import com.test.counter.CounterRule_Sale;
import com.test.util.SalaryCounter;
import com.test.util.Xml2Object;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Department department = (Department) Xml2Object.parse("employeeInfo.xml", Department.class);

            CounterRule counter_salary = new CounterRule_Salary(6000f);
            CounterRule counter_hour = new CounterRule_Hour(35f, 160f, 1.3f);
            float[] overSoldSteps = {20000f, 30000f};
            float[] overSoldFactors = {0.05f, 0.08f};
            CounterRule counter_sale = new CounterRule_Sale(3000f, overSoldSteps, overSoldFactors);

            Map counterRules = new HashMap<String, CounterRule>();
            counterRules.put("salary", counter_salary);
            counterRules.put("hour", counter_hour);
            counterRules.put("sale", counter_sale);

            BigDecimal count = SalaryCounter.countInToal(department, counterRules).setScale(2, BigDecimal.ROUND_HALF_UP);

            System.out.println("The total salary payment would be " + count.floatValue());

        } catch (Exception e) {
            System.out.println("error happened");
            e.printStackTrace();
        }
    }
}
