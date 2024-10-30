
use movilexpress;
select*from cliente;
select*from empleado;
-- MySQL Script generatedusuario by MySQL Workbench
-- Fri Dec  2 21:46:24 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema movilexpress
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `movilexpress` ;

-- -----------------------------------------------------
-- Schema movilexpress
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movilexpress` DEFAULT CHARACTER SET utf8mb4 ;
USE `movilexpress` ;

-- -----------------------------------------------------
-- Table `movilexpress`.`distrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`distrito` (
  `COD_DISTRITO` CHAR(6) NOT NULL,
  `NOM_DISTRITO` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`COD_DISTRITO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `movilexpress`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`cliente` (
  `CODIGO` INT(11) NOT NULL,
  `NOMBRES` VARCHAR(30) NOT NULL,
  `APELLIDOS` VARCHAR(30) NOT NULL,
  `ING_MENSUAL` FLOAT NULL DEFAULT NULL,
  `CORREO` VARCHAR(40) NULL DEFAULT NULL,
  `EDAD` INT(11) NULL DEFAULT NULL,
  `FECHA_NAC` DATE NULL DEFAULT NULL,
  `COD_DIS` CHAR(6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  CONSTRAINT `FK_CODIS`
    FOREIGN KEY (`COD_DIS`)
    REFERENCES `movilexpress`.`distrito` (`COD_DISTRITO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;



-- -----------------------------------------------------
-- Table `movilexpress`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`empleado` (
  `DNI` CHAR(8) NOT NULL,
  `NOMEMPLEADO` VARCHAR(30) NULL DEFAULT NULL,
  `APEMPLE` VARCHAR(30) NULL DEFAULT NULL,
  `COD_DIS` CHAR(6) NULL DEFAULT NULL,
  `CARGO` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  CONSTRAINT `FK_CODD`
    FOREIGN KEY (`COD_DIS`)
    REFERENCES `movilexpress`.`distrito` (`COD_DISTRITO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `movilexpress`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`cargo` (
  `COD_CARGO` CHAR(4) NOT NULL,
  `NOM_CARGO` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`COD_CARGO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `movilexpress`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`producto` (
  `ID_PRODUCTO` VARCHAR(8) NOT NULL,
  `NOMPRODUCTO` VARCHAR(30) NOT NULL,
  `PANTALLA` VARCHAR(30) NOT NULL,
  `CAMARA` VARCHAR(30) NOT NULL,
  `MEMORIA_RAM` VARCHAR(30) NOT NULL,
  `BATERIACEL` VARCHAR(30) NOT NULL,
  `MEMORIA_INTERNA` VARCHAR(10) NOT NULL,
  `FECHA_LANZAMIENTO` DATE NULL DEFAULT NULL,
  `PRECIO_VENTA` FLOAT NOT NULL,
  `STOCK_ACTUAL` INT(11) NULL DEFAULT NULL,
  `COD_MARCA` CHAR(4) NOT NULL,
  PRIMARY KEY (`ID_PRODUCTO`),
  CONSTRAINT `FK_CODC`
    FOREIGN KEY (`COD_MARCA`)
    REFERENCES `movilexpress`.`marcacel` (`COD_MARCACEL`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `movilexpress`.`marcacel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`marcacel` (
  `COD_MARCACEL` CHAR(4) NOT NULL,
  `NOM_CATEG` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`COD_MARCACEL`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `movilexpress`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`usuario` (
  `NOMUSUARIO` VARCHAR(20) NULL DEFAULT NULL,
  `CONTRASEÑA` VARCHAR(20) NULL DEFAULT NULL,
  `COD_EMPLEADO` CHAR(8) NOT NULL,
  CONSTRAINT `FK_CODEM`
    FOREIGN KEY (`COD_EMPLEADO`)
    REFERENCES `movilexpress`.`empleado` (`DNI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `movilexpress`.`boletaventa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`boletaventa` (
  `NROBOLETA` CHAR(8) NOT NULL,
  `FECHA_EMISION` DATE NOT NULL,
  `TIPO_PAGO` VARCHAR(20) NOT NULL,
  `COD_CLIE` INT(11) NOT NULL,
  `dni_emple` CHAR(8) NOT NULL,
  `TOTAL` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`NROBOLETA`),
  CONSTRAINT `FK_CODCLIE`
    FOREIGN KEY (`COD_CLIE`)
    REFERENCES `movilexpress`.`cliente` (`CODIGO`),
  CONSTRAINT `FK_DNIE`
    FOREIGN KEY (`dni_emple`)
    REFERENCES `movilexpress`.`empleado` (`DNI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `movilexpress`.`detalle_boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movilexpress`.`detalle_boleta` (
  `NROBOLE` CHAR(8) NOT NULL,
  `COD_PROD` VARCHAR(8) NOT NULL,
  `CANTIDAD` INT(11) NOT NULL,
  `IMPORTE` DECIMAL(8,2) NOT NULL,
  CONSTRAINT `FK_CODP`
    FOREIGN KEY (`COD_PROD`)
    REFERENCES `movilexpress`.`producto` (`ID_PRODUCTO`),
  CONSTRAINT `FK_NBOL`
    FOREIGN KEY (`NROBOLE`)
    REFERENCES `movilexpress`.`boletaventa` (`NROBOLETA`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- procedure SP_ACTUALIZAR_PRODUCTO
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ACTUALIZAR_PRODUCTO`(
COD_P		VARCHAR(8) ,
NOMP		VARCHAR(30),
PANT 			VARCHAR(30) ,
CAM              VARCHAR(30) ,
MEMORAM         VARCHAR(30),
BATERIA 			VARCHAR(30) ,
MEMOINT     VARCHAR(10) ,
FECHALANZ   DATE  ,
PREVENT	FLOAT,
STOCK		INT	,
CODMARCA			CHAR(4)
)
BEGIN
UPDATE PRODUCTO SET NOMPRODUCTO = NOMP,PANTALLA =PANT,CAMARA=CAM,MEMORIA_RAM=MEMORAM,BATERIACEL=BATERIA,MEMORIA_INTERNA=MEMOINT,FECHA_LANZAMIENTO=FECHALANZ,PRECIO_VENTA=PREVENT,STOCK_ACTUAL =STOCK,COD_NARCA=CODMARCA
          WHERE ID_PRODUCTO=CODP;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_ACTUALIZAR_STOCK
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ACTUALIZAR_STOCK`(
	IDPROD CHAR(9),
    CANTIVENTA INT
)
BEGIN
	UPDATE PRODUCTO SET STOCK_ACTUAL=STOCK_ACTUAL-CANTIVENTA WHERE ID_PRODUCTO=IDPROD;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_BUSCAR_EMPLEADO
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_BUSCAR_EMPLEADO`(
BUSCA	VARCHAR		(35)
)
BEGIN
SELECT 
E.DNI, E.NOMEMPLEADO,E.APEMPLE,E.COD_DIS,E.CARGO
FROM EMPLEADO E  WHERE E.DNI LIKE CONCAT(BUSCA,'%') OR
E.APEMPLE LIKE CONCAT(BUSCA,'%');
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_BUSCAR_PRODUCTO
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_BUSCAR_PRODUCTO`(
BUSCA	VARCHAR		(35)
)
BEGIN
SELECT 
P.ID_PRODUCTO,P.NOMPRODUCTO ,P.PANTALLA,P.CAMARA,P.MEMORIA_RAM,P.BATERIACEL,P.MEMORIA_INTERNA,P.FECHA_LANZAMIENTO,P.PRECIO_VENTA,P.STOCK_ACTUAL,M.COD_MARCACEL
FROM PRODUCTO P INNER JOIN MARCACEL M ON P.COD_MARCA=M.COD_MARCACEL WHERE P.ID_PRODUCTO LIKE CONCAT(BUSCA,'%') OR
P.PRECIO_VENTA LIKE CONCAT(BUSCA,'%');
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_CANTIDAD_VECES_VENDIDOS
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_CANTIDAD_VECES_VENDIDOS`(

NOMP VARCHAR(30)

)
BEGIN

SELECT P.NOMPRODUCTO,COUNT(DB.COD_PROD) AS CANTIDAD, SUM(DB.IMPORTE) AS TOTAL_INGRESO

 FROM DETALLE_BOLETA DB INNER JOIN PRODUCTO P ON DB.COD_PROD=P.ID_PRODUCTO WHERE P.NOMPRODUCTO=NOMP

 GROUP BY P.NOMPRODUCTO;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_CONSULTAR_CLIENTE_CODIGO_APE
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_CONSULTAR_CLIENTE_CODIGO_APE`(
BUSCA VARCHAR(10)
)
BEGIN
SELECT CODIGO, 
    APELLIDOS,
    NOMBRES,
    CORREO
    FROM CLIENTE WHERE CODIGO LIKE CONCAT(BUSCA,'%') OR APELLIDOS LIKE CONCAT(BUSCA,'%');
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_CONSULTAR_PRODUCTO_MARCA_NOMBRE
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_CONSULTAR_PRODUCTO_MARCA_NOMBRE`(
MARCA VARCHAR(30),
NOMP VARCHAR(30)
)
BEGIN
SELECT P.ID_PRODUCTO,
    P.NOMPRODUCTO,
    P.PRECIO_VENTA,
    P.STOCK_ACTUAL
    FROM PRODUCTO P INNER JOIN MARCACEL M
       ON P.COD_MARCA=M.COD_MARCACEL WHERE M.NOM_CATEG=MARCA
			AND P.NOMPRODUCTO LIKE CONCAT(NOMP,'%');
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_ELIMINAR_PRODUCTO
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ELIMINAR_PRODUCTO`(
CODP		VARCHAR(8)
)
BEGIN
DELETE FROM PRODUCTO WHERE ID_PRODUCTO=CODP;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_GENERAR_NUMEROBOLETA
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_GENERAR_NUMEROBOLETA`()
BEGIN

  DECLARE NUMEROBOL INT;

  DECLARE NUEVONUMERO CHAR(8);

  SET NUMEROBOL=(SELECT IFNULL(MAX(CONVERT(SUBSTRING(NROBOLETA,2),SIGNED INTEGER)),0) FROM BOLETAVENTA)+1;

  SET NUEVONUMERO=CONCAT('B',LPAD(NUMEROBOL,7,0));

  SELECT NUEVONUMERO AS NRO_BOLETA;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_LISTAR_CLIENTES
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAR_CLIENTES`()
BEGIN

SELECT CL.CODIGO, CL.APELLIDOS FROM CLIENTE CL;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_LISTAR_MARCACEL
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAR_MARCACEL`()
BEGIN
SELECT * FROM MARCACEL;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_LISTAR_PRODUCTOS
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAR_PRODUCTOS`()
BEGIN

SELECT P.ID_PRODUCTO, P.COD_MARCA FROM PRODUCTO P;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_LISTAR_PRODUCTOSXNOMBRE
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAR_PRODUCTOSXNOMBRE`()
BEGIN

SELECT P.ID_PRODUCTO, P.NOMPRODUCTO FROM PRODUCTO P;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_LISTAR_STOCK_P
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAR_STOCK_P`()
BEGIN
select P.NOMPRODUCTO ,P.STOCK_ACTUAL FROM PRODUCTO P;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_LISTAR_VENTAS_x_CLIENTES
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAR_VENTAS_x_CLIENTES`()
BEGIN

	SELECT CONCAT(C.APELLIDOS,' ',C.NOMBRES) AS CLIENTE, COUNT(B.NROBOLETA) AS VENTAS

  FROM CLIENTE C

  INNER JOIN BOLETAVENTA B

  WHERE C.CODIGO=B.COD_CLIE

  GROUP BY C.CODIGO;

END$$

DELIMITER ;


CALL SP_LISTAR_VENTAS_x_CLIENTES();

SELECT*FROM CLIENTE;
select *from boletaventa;
select * from producto;
-- -----------------------------------------------------
-- procedure SP_MOSTRAR_CODIGO_MARCACEL
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_MOSTRAR_CODIGO_MARCACEL`(
NONMARCA	VARCHAR(35)
)
BEGIN
SELECT * FROM MARCACEL WHERE NOM_CATEG=NONMARCA;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_REGISTRAR_BOLETA
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_REGISTRAR_BOLETA`(
NBOL		CHAR(8),
FECHA_EMI		DATE,
TP				VARCHAR(20),
CCLIE			INT,
DNIEM			CHAR(8),
TOTAL 			DECIMAL(8,2)
)
BEGIN
INSERT INTO BOLETAVENTA VALUES(NBOL,FECHA_EMI,TP,CCLIE,DNIEM,TOTAL);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_REGISTRAR_DETALLE_BOLETA
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_REGISTRAR_DETALLE_BOLETA`(
NBOL		CHAR(8),
CODPROD		VARCHAR(8),
CANTI			INT,
IMPORTE 			DECIMAL(8,2)
)
BEGIN
INSERT INTO DETALLE_BOLETA VALUES(NBOL,CODPROD,CANTI,IMPORTE);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_REGISTRAR_EMPLEADO
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_REGISTRAR_EMPLEADO`(
DNI_EM		VARCHAR(8) ,
NOME		VARCHAR(30),
APEMPLE VARCHAR(30),
CODIS CHAR(6),
CARGOE VARCHAR(20)
)
BEGIN	

INSERT INTO EMPLEADO VALUES(DNI_EM,NOME,APEMPLE,CODIS,CARGOE);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_REGISTRAR_PRODUCTO
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_REGISTRAR_PRODUCTO`(
COD_P		VARCHAR(8) ,
NOMP		VARCHAR(30),
PANT 			VARCHAR(30) ,
CAM              VARCHAR(30) ,
MEMORAM         VARCHAR(30),
BATERIA 			VARCHAR(30) ,
MEMOINT     VARCHAR(10) ,
FECHALANZ   DATE  ,
PREVENT	FLOAT,
STOCK		INT	,
CODMARCA			CHAR(4)
)
BEGIN	

INSERT INTO PRODUCTO VALUES(COD_P,NOMP,PANT,CAM,MEMORAM,BATERIA,MEMOINT,FECHALANZ,PREVENT,STOCK,CODMARCA);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_VENTAS_x_Cliente
-- -----------------------------------------------------

DELIMITER $$
USE `movilexpress`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_VENTAS_x_Cliente`(

Ape		varchar(30)

)
BEGIN

SELECT B.NROBOLETA, B.FECHA_EMISION,B.TIPO_PAGO,B.TOTAL

FROM BOLETAVENTA B INNER JOIN CLIENTE C ON B.COD_CLIE=C.CODIGO

WHERE 	C.APELLIDOS=Ape;

END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


SELECT*FROM PRODUCTO;
select*from boletaventa;
select*from detalle_boleta;
CALL SP_GENERAR_NUMEROBOLETA();

insert into marcacel values("MC01","APPLE");
insert into marcacel values("MC02","SANSUMG");
insert into marcacel values("MC03","MOTOROLA");
insert into marcacel values("MC04","HUAWEI");
insert into marcacel values("MC05","LG");
insert into marcacel values("MC06","ZTE");

insert into distrito values ("DIS001","SJL");
insert into distrito values ("DIS002","COMAS");
insert into distrito values ("DIS003","MIRAFLORES");
insert into distrito values ("DIS004","BARRANCO");
insert into distrito values ("DIS005","CHORRILLOS");
insert into distrito values ("DIS006","RIMAC");
insert into distrito values ("DIS007","LA MOLINA");
insert into distrito values ("DIS008","CARABAYLLO");
insert into distrito values ("DIS009","SAN ISIDRO");
insert into distrito values ("DIS010","El Agustino");


insert into cargo values("CG01","VENDEDOR");
insert into cargo values("CG02","ALMACENERO");

select*from empleado;


INSERT INTO CLIENTE VALUES("1","Jerson","laureano","1500","jerson@hotmail.com","25","1994-07-07","DIS001");

select * from usuario where NOMUSUARIO ="PACHON" and CONTRASEÑA ="123456";
select * from usuario;
insert into usuario values ("JERSON","123456","48562162");
insert into usuario values ("PACHON","123456","12345678");

USE movilexpress;
SELECT*FROM PRODUCTO;
select*from distrito;
select*from marcacel;
select*from empleado;

describe cliente;
describe empleado;

drop table cliente;

