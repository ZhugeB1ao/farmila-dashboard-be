CREATE TABLE Employee (
  id CHAR(36) PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL,
  gender VARCHAR(20),
  birth_day DATE,

  department VARCHAR(100),

  bank_account VARCHAR(100),
  bank VARCHAR(100),

  sin VARCHAR(50),
  ptin VARCHAR(50),
  national_id VARCHAR(50),

  address VARCHAR(255),
  phone_no VARCHAR(20),
  zalo_no VARCHAR(20),
  email VARCHAR(100),

  hobby VARCHAR(100),
  favorite_sport VARCHAR(100),
  marital_status VARCHAR(50),

  date_in DATE,
  specialization VARCHAR(100),
  image VARCHAR(255),

  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
      ON UPDATE CURRENT_TIMESTAMP
);