CREATE DATABASE  IF NOT EXISTS `pizzaria` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pizzaria`;

-- -----------------------------------------------------
-- Table `pizzaria`.`tbl_pessoa`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `pizzaria`.`tbl_pessoa`;

CREATE TABLE `pizzaria`.`tbl_pessoa` (
  `id_pessoa` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `telefone` VARCHAR(20) DEFAULT NULL,
  `celular` VARCHAR(20) NOT NULL,
  `perfil` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(20) NOT NULL,
  `sobrenome` VARCHAR(20) NOT NULL,
  `identificacao` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_pessoa`)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `pizzaria`.`tbl_endereco`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `pizzaria`.`tbl_endereco`;

CREATE TABLE `pizzaria`.`tbl_endereco` (
  `id_endereco` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `id_pessoa` BIGINT(20) NOT NULL,
  `logradouro` VARCHAR(50) NOT NULL,
  `numero` VARCHAR(20) NOT NULL,
  `complemento` VARCHAR(20) DEFAULT NULL,
  `bairro` VARCHAR(20) NOT NULL,
  `cidade` VARCHAR(20) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `cep` BIGINT(8) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  INDEX `fk_pessoa_endereco` (`id_pessoa` ASC),
  CONSTRAINT `fk_pessoa_endereco`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `pizzaria`.`tbl_pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `pizzaria`.`tbl_produto`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `pizzaria`.`tbl_produto`;

CREATE TABLE `pizzaria`.`tbl_produto` (
  `id_produto` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `id_pessoa` BIGINT(20) NOT NULL,
  `categoria` VARCHAR(20) NOT NULL,
  `sub_categoria` VARCHAR(20) DEFAULT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(60) DEFAULT NULL,
  `preco` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`id_produto`),
  INDEX `fk_pessoa_produto` (`id_pessoa` ASC),
  CONSTRAINT `fk_pessoa_produto`
    FOREIGN KEY (`id_pessoa` )
    REFERENCES `pizzaria`.`tbl_pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `pizzaria`.`tbl_pedido`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `pizzaria`.`tbl_pedido`;

CREATE TABLE `pizzaria`.`tbl_pedido` (
  `id_pedido` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `id_pessoa_fisica` BIGINT(20) NOT NULL,
  `id_pessoa_juridica` BIGINT(20) NOT NULL,
  `id_produto` BIGINT(20) NOT NULL,
  `tipo_produto` VARCHAR(20) NOT NULL,
  `quantidade` DECIMAL(12,2) NOT NULL,
  `descricao` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `fk_pf_pedido` (`id_pessoa_fisica` ASC),
  INDEX `fk_pj_pedido` (`id_pessoa_juridica` ASC),
  INDEX `fk_produto_pedido` (`id_produto` ASC),
  CONSTRAINT `fk_pf_pedido`
    FOREIGN KEY (`id_pessoa_fisica` )
    REFERENCES `pizzaria`.`tbl_pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pj_pedido`
    FOREIGN KEY (`id_pessoa_juridica` )
    REFERENCES `pizzaria`.`tbl_pessoa` (`id_pessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_pedido`
    FOREIGN KEY (`id_produto` )
    REFERENCES `pizzaria`.`tbl_produto` (`id_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;