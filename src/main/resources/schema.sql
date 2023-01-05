drop table if exists hospital CASCADE;

CREATE TABLE IF NOT EXISTS `hospital`
(
    `id`             BIGINT          NOT NULL AUTO_INCREMENT,
    `name`           VARCHAR(50)     NOT NULL,
    `description`    TEXT            NULL,
    `contact_number` VARCHAR(30)     NOT NULL,
    `latitude`       DECIMAL(17, 14) NOT NULL,
    `longitude`      DECIMAL(17, 14) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC)
)
    ENGINE = InnoDB;