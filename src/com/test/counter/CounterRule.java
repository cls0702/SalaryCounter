package com.test.counter;

import java.math.BigDecimal;

public interface CounterRule <T> {
    BigDecimal count(T t);
}
