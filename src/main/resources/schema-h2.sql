CREATE SCHEMA IF NOT EXISTS java301;
USE java301 ;

-- -----------------------------------------------------
-- Table java301.users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS java301.users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  email VARCHAR(128) NULL,
  phone VARCHAR(10) NULL,
  role VARCHAR(16) NOT NULL DEFAULT 'USER',
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table java301.user_properties
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS java301.user_properties (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  prop_name VARCHAR(45) NOT NULL,
  prop_value VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));

