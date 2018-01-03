CREATE SCHEMA IF NOT EXISTS `testdb`
  DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `testdb`.`item`;
DROP TABLE IF EXISTS `testdb`.`invoice`;
DROP TABLE IF EXISTS `testdb`.`product`;
DROP TABLE IF EXISTS `testdb`.`customer`;
DROP TABLE IF EXISTS `testdb`.`seller`;

CREATE TABLE `testdb`.`product` (
  `id`    INT(11)        NOT NULL AUTO_INCREMENT,
  `name`  VARCHAR(200)   NULL     DEFAULT NULL,
  `price` DECIMAL(20, 2) NULL     DEFAULT NULL,
  `vat`   DOUBLE         NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8;


CREATE TABLE `testdb`.`customer` (
  `id`          INT(11)      NOT NULL AUTO_INCREMENT,
  `first_name`   VARCHAR(200) NULL     DEFAULT NULL,
  `last_name`   VARCHAR(200) NULL     DEFAULT NULL,
  `street`      VARCHAR(200) NULL     DEFAULT NULL,
  `postal_code` VARCHAR(200) NULL     DEFAULT NULL,
  `city`        VARCHAR(200) NULL     DEFAULT NULL,
  `country`     VARCHAR(200) NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8;


CREATE TABLE `testdb`.`seller` (
  `id`          INT(11)      NOT NULL AUTO_INCREMENT,
  `name`   VARCHAR(200) NULL     DEFAULT NULL,
  `street`      VARCHAR(200) NULL     DEFAULT NULL,
  `postal_code` VARCHAR(200) NULL     DEFAULT NULL,
  `city`        VARCHAR(200) NULL     DEFAULT NULL,
  `country`     VARCHAR(200) NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8;


CREATE TABLE `testdb`.`invoice` (
  `id`           INT(11) NOT NULL AUTO_INCREMENT,
  `invoice_date` DATE    NULL     DEFAULT NULL,
  `seller_id`    INT(11) NOT NULL,
  `customer_id`  INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_invoice_seller`
  FOREIGN KEY (`seller_id`)
  REFERENCES `testdb`.`seller` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_customer`
  FOREIGN KEY (`customer_id`)
  REFERENCES `testdb`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET = utf8;


CREATE TABLE `testdb`.`item` (
  `invoice_id` INT(11) NOT NULL,
  `product_id` INT(11) NOT NULL,
  `number`     INT(11) NULL DEFAULT NULL,
  `quantity`   INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_id`, `product_id`),
  INDEX `fk_invoice_has_product_product1_idx` (`product_id` ASC),
  INDEX `fk_invoice_has_product_invoice1_idx` (`invoice_id` ASC),
  CONSTRAINT `fk_invoice_has_product_invoice1`
  FOREIGN KEY (`invoice_id`)
  REFERENCES `testdb`.`invoice` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_has_product_product1`
  FOREIGN KEY (`product_id`)
  REFERENCES `testdb`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;