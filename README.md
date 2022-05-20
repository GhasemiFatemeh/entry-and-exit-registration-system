# employeesTime
This project saves employee's entrance and exit time. employee should login with they employee code and password, then register the time with click on related button. also  the admin can see the list of the information of people such as name, family, employee code and exit and entrance time.

prerequisites:
please create tables on oracle RDBMS with following sql queries(If you have tables with same following names, drop them)

create table employee(employeeId number, name varchar2(20), family varchar2(20), empCode varchar2(20), password varchar2(20), entranceTime timeStamp, exitTime timeStamp);

create sequence employee_seq start with 1 increment by 1;

create table role (employeeId number, role varchar2(10));
