package com.employee.data.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String role;

    public Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass ( this ) != Hibernate.getClass ( o )) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals ( id, employee.id );
    }

    @Override
    public int hashCode() {
        return getClass ().hashCode ();
    }
}
