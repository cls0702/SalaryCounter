
package com.test.bean;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employee")
public class Employee {

    @XmlAttribute(name = "name", required = true)
    private String name;
    @XmlAttribute(name = "type", required = true)
    private String type;
    @XmlAttribute(name = "birthday", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar birthday;
    @XmlAttribute(name = "workingHours")
    private Float workingHours = 0.0f;
    @XmlAttribute(name = "amount")
    private Float amount = 0.0f;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public XMLGregorianCalendar getBirthday() {
        return birthday;
    }

    public void setBirthday(XMLGregorianCalendar value) {
        this.birthday = value;
    }

    public Float getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Float value) {
        this.workingHours = value;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float value) {
        this.amount = value;
    }

}
