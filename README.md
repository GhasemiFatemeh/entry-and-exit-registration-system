# employeesTime
This project saves employee's entrance and exit time. employee should login with they employee code and password, then register the time with click on related button. also  the admin can see the list of the information of people such as name, family, employee code and exit and entrance time.
Oracle RDBMS is used for this project. It is not embedded, you have to install it and make a user for it, then replace your user's information(such as username and password) to JDBC class.
Tomcat is used as web application on this system. As a result, this is a web-based application. You have to download and install it too.
Servlet is used for controller part.
This project is implemented based on MVC architecture, it has model, view and controller layers. model layer is seperated with entity, repository and service layers.
Entity package has Employee, role and user which are the tables for database.
Repository is a section that relates system with database.
Service layer implements system's business.
Obviously, controller section is controlling the system; like inputs validation, etc.
Common package contains classes that is related to all of the system.
It is web application, so we have web package for our templates and front-end codes.
That was the short description of system's construction, now I am going to explain how to use this appliction.
For using this system, first you have to register; but as administrator, you can login with login/login as username/password. If you entered as admin you can see the report of employees' entry and exit time and also you can registrate your entry and exit time. But as normal user, you just can registrate your entry and exit time and if you try to see the reports, you might see an error!

prerequisites:
please create tables on oracle RDBMS with following sql queries(If you have tables with same following names, drop them)

create sequence employee_seq start with 1 increment by 1;

create table role (employeeId number, role varchar2(10));
