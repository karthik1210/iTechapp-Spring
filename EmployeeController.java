package com.kartik.iTechapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    List<Employee> employeeList = new ArrayList<>();
    @RequestMapping(value = "/employee/all")
    List<Employee> getEmployees()
    {
        List<Employee> employeeList = prepareData();
        return employeeList;
    }
    @RequestMapping(value = "/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Integer id){
        List<Employee> employeeList = prepareData();
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                ResponseEntity responseEntity = new ResponseEntity(employee, HttpStatus.OK);
                return responseEntity;
            }
        }
        //String m = "Employee not found";
        Map<String,String> map = new HashMap<>();
        map.put("message","Employee not Found");
        ResponseEntity responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @RequestMapping(value  = "/employee", method = RequestMethod.POST)
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        addEmployee(employee);
        ResponseEntity responseEntity;
        Map<String, String> map = new HashMap<>();
        map.put("message", "Employee added Successfully");
        esponseEntity = new ResponseEntity(map, HttpStatus.CREATED);
        return responseEntity;
    }

        @RequestMapping(value = "/employee", method = RequestMethod.PUT)
        public ResponseEntity updateEmployee(@RequestBody Employee employee)
        {
            boolean updated = updateMyEmployee(employee);
            Map<String,String> map = new HashMap<>();
            ResponseEntity responseEntity;
            if(updated)
            {
                map.put("message","Employee Updated Successfully");
                responseEntity = new ResponseEntity(map,HttpStatus.OK);
            }
            else
            {
                map.put("message","Employee not Found");
                responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
            }
            return responseEntity;
        }


    @RequestMapping(value = "/employee/01")
    public Employee getEmployeeByone()
    {
        List<Employee> employeeList = prepareData();
        for(Employee employee : employeeList){
            if(employee.getId() == 1){
                return employee;
            }
        }
        return null;
    }
    /*
    @RequestMapping(value = "/employee/1")
    public Employee getEmployeeOne() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("karti");
        Role role = new Role();
        role.setDesignation("CEO");
        role.setDept("Company");
        e1.setRole(role);
        return e1;
    }
    @RequestMapping(value = "/employee/2")
            public Employee getEmployeeTwo(){
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Sofi");
        Role role = new Role();
        role.setDesignation("CFO");
        role.setDept("Finance");
        e2.setRole(role);
        return e2;
    }*/
    private List<Employee> prepareData()
    {
        if(employeeList.isEmpty())
        {
                Employee e1 = new Employee();
                e1.setId(1);
                e1.setName("karti");
                Role role = new Role();
                role.setDesignation("CEO");
                role.setDept("Company");
                e1.setRole(role);
                Employee e2 = new Employee();
                e2.setId(2);
                e2.setName("Sofi");
                Role role1 = new Role();
                role1.setDesignation("CFO");
                role1.setDept("Finance");
                e2.setRole(role1);
                // List<Employee> employeeList = new ArrayList<>();
                employeeList.add(e1);
                employeeList.add(e2);
            }
        return employeeList;
    }

    private void addEmployee(Employee employee) {
        List<Employee> employeeList = prepareData();
        employeeList.add(employee);
    }
    private boolean updateMyEmployee(Employee tobeUpdatedEmployee)
    {
        List<Employee> employeeList = prepareData();
        Iterator<Employee> iterator = employeeList.iterator();
        boolean removed = false;
        while(iterator.hasNext())
        {
            Employee employee = iterator.next();
            if(employee.getId() == tobeUpdatedEmployee.getId()) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if(removed) {
            employeeList.add(tobeUpdatedEmployee);
        }
        return removed;

    }
}
