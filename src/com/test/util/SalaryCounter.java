package com.test.util;

import com.test.bean.Department;
import com.test.bean.Employee;
import com.test.bean.Month;
import com.test.counter.CounterRule;

import java.math.BigDecimal;
import java.util.Map;

public class SalaryCounter {

    public static BigDecimal countInToal(Department department, Map<String, CounterRule> counterRules) {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal birthdayPart = new BigDecimal(100);

        for (Month month : department.getMonth()) {
            for (Employee employee : month.getEmployee()) {
                CounterRule cr = counterRules.get(employee.getType().trim());
                if (isBirthday(month.getValue(), employee)){
                    total = total.add(cr.count(employee)).add(birthdayPart);
                } else {
                    total = total.add(cr.count(employee));
                }
            }
        }
        return total;
    }

    private static boolean isBirthday(int month, Employee employee) {
        return employee.getBirthday().getMonth() == month;
    }
}