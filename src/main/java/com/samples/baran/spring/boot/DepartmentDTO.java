package com.samples.baran.spring.boot;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class DepartmentDTO {
    private int id;
    private String name;
    private int salary;
    private int departmentid;
}
