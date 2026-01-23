CREATE TABLE EmploymentContract (
    id CHAR(36) PRIMARY KEY,
    emp_id CHAR(36) NOT NULL,

    contract_no VARCHAR(50) NOT NULL UNIQUE,
    duration_type VARCHAR(50),
    duration_value VARCHAR(50),

    start_date DATE,
    end_date DATE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_contract_employee
        FOREIGN KEY (emp_id)
            REFERENCES employee(id)
            ON DELETE CASCADE
);