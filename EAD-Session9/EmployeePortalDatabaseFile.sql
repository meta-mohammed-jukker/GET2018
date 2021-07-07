CREATE DATABASE employeePortalDatabase;
drop database employeePortalDatabase;
use employeePortalDatabase;
CREATE TABLE employee
(
    emp_code INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    dob DATE NOT NULL,
    gender CHAR(6) NOT NULL,
    primary_contact_no VARCHAR(15),
    secondary_contact_no VARCHAR(15),
    email_id VARCHAR(50) NOT NULL,
    skype_id VARCHAR(50),
    profile_picture VARCHAR(50),
    password VARCHAR(50) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(emp_code)
);

CREATE TABLE job_title_master
(
    job_code INT NOT NULL AUTO_INCREMENT,
    job_title VARCHAR(50) NOT NULL,
    PRIMARY KEY(job_code)
);

select * from job_title_master;

CREATE TABLE skill_master
(
    skill_id INT NOT NULL AUTO_INCREMENT,
    skill_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(skill_id)
);
select * from skill_master;

CREATE TABLE user_roles
(
    user_role_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY(user_role_id)
);

CREATE TABLE employee_skills
(
    emp_skill_id INT NOT NULL AUTO_INCREMENT,
    emp_code INT NOT NULL,
    skill_code INT NOT NULL,
    PRIMARY KEY(emp_skill_id),
    FOREIGN KEY (emp_code)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (skill_code)
    REFERENCES skill_master(skill_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE project_master
(
    project_id INT NOT NULL AUTO_INCREMENT,
    project_name VARCHAR(50) NOT NULL,
    description VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    project_logo VARCHAR(50),
    PRIMARY KEY(project_id)
);
select * from project_master;
CREATE TABLE address
(
    address_id INT NOT NULL AUTO_INCREMENT,
    emp_code INT NOT NULL,
    add_line_1 VARCHAR(50) NOT NULL,
    add_line_2 VARCHAR(50),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    pincode VARCHAR(10) NOT NULL,
    PRIMARY KEY(address_id),
    FOREIGN KEY (emp_code)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE job_details
(
    emp_code INT NOT NULL,
    job_detail_id INT NOT NULL AUTO_INCREMENT,
    date_of_joining DATE NOT NULL,
    total_exp INT NOT NULL,
    job_code INT NOT NULL,
    reproting_mgr INT,
    team_lead INT,
    curr_proj_id INT,
    PRIMARY KEY(job_detail_id),
    FOREIGN KEY (emp_code)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (job_code)
    REFERENCES job_title_master(job_code)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (reproting_mgr)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (team_lead)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (curr_proj_id)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

DROP TABLE job_details;
DROP TABLE job_title_master;