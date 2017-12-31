DROP SCHEMA IF EXISTS `testdb`;

CREATE SCHEMA IF NOT EXISTS `testdb`
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `testdb`.`product` (
  `id`    INT(11)        NOT NULL AUTO_INCREMENT,
  `name`  VARCHAR(200)   NULL     DEFAULT NULL,
  `price` DECIMAL(20, 2) NULL     DEFAULT NULL,
  `vat`   DOUBLE         NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `testdb`.`customer` (
  `id`          INT(11)      NOT NULL AUTO_INCREMENT,
  `firs_name`   VARCHAR(200) NULL     DEFAULT NULL,
  `last_name`   VARCHAR(200) NULL     DEFAULT NULL,
  `street`      VARCHAR(200) NULL     DEFAULT NULL,
  `postal_code` VARCHAR(200) NULL     DEFAULT NULL,
  `city`        VARCHAR(200) NULL     DEFAULT NULL,
  `country`      VARCHAR(200) NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `testdb`.`seller` (
  `id`          INT(11)      NOT NULL AUTO_INCREMENT,
  `firs_name`   VARCHAR(200) NULL     DEFAULT NULL,
  `last_name`   VARCHAR(200) NULL     DEFAULT NULL,
  `street`      VARCHAR(200) NULL     DEFAULT NULL,
  `postal_code` VARCHAR(200) NULL     DEFAULT NULL,
  `city`        VARCHAR(200) NULL     DEFAULT NULL,
  `country`      VARCHAR(200) NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)

  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `testdb`.`invoice` (
  `id`           INT(11) NOT NULL AUTO_INCREMENT,
  `invoice_date` DATE    NULL     DEFAULT NULL,
  `seller_id`    INT(11) NOT NULL,
  `customer_id`  INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_invoice_seller_idx` (`seller_id` ASC),
  INDEX `fk_invoice_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_invoice_seller`
  FOREIGN KEY (`seller_id`)
  REFERENCES `mydb`.`seller` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_customer1`
  FOREIGN KEY (`customer_id`)
  REFERENCES `mydb`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `testdb`.`item` (
  `invoice_id` INT(11) NOT NULL,
  `product_id` INT(11) NOT NULL,
  `number`     INT(11) NULL DEFAULT NULL,
  `quantity`   INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_id`, `product_id`),
  INDEX `fk_invoice_has_product_product1_idx` (`product_id` ASC),
  INDEX `fk_invoice_has_product_invoice1_idx` (`invoice_id` ASC),
  CONSTRAINT `fk_invoice_has_product_invoice1`
  FOREIGN KEY (`invoice_id`)
  REFERENCES `mydb`.`invoice` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_has_product_product1`
  FOREIGN KEY (`product_id`)
  REFERENCES `mydb`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  DEFAULT CHARACTER SET = utf8;