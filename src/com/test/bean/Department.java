
package com.test.bean;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "department")
public class Department {

    private List<Month> month;

    public List<Month> getMonth() {
        if (month == null) {
            month = new ArrayList<Month>();
        }
        return this.month;
    }

}
