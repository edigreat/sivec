DROP TABLE IF EXISTS EquipoValorCarac;
DROP TABLE IF EXISTS ReparacionEquipo;
DROP TABLE IF EXISTS EquipoComputo;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS MenuItemRol;
DROP TABLE IF EXISTS MenuItem;
DROP TABLE IF EXISTS MenuRol;
DROP TABLE IF EXISTS DependenciaUniversitaria;




CREATE  TABLE IF NOT EXISTS DependenciaUniversitaria (
  id_dependencia INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_dependencia));

CREATE  TABLE IF NOT EXISTS MenuRol (
  id_menuRol INT NOT NULL AUTO_INCREMENT,
  ref_role VARCHAR(45) NOT NULL,
  descripcion_rol VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_menuRol));  
  
  
  

  CREATE  TABLE IF NOT EXISTS MenuItem (
  id_menuItem INT NOT NULL AUTO_INCREMENT,
  id_menuParent INT NULL DEFAULT NULL,
  etiqueta VARCHAR(45) NOT NULL,
  accion VARCHAR(45) NOT NULL,
  nombre_menu VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_menuItem),
  CONSTRAINT fk_MenuItems_MenuItems
    FOREIGN KEY (id_menuParent)
    REFERENCES MenuItem (id_menuItem)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  
    
CREATE TABLE IF NOT EXISTS MenuItemRol (
  id_menuRol INT NOT NULL,
  id_menuItem INT NOT NULL,
  INDEX fk_MenuItemsRoles_MenuRoles1_idx (id_menuRol ASC),
  INDEX fk_MenuItemsRoles_MenuItems1_idx (id_menuItem ASC),
  CONSTRAINT fk_MenuItemsRoles_MenuRoles1
    FOREIGN KEY (id_menuRol)
    REFERENCES MenuRol (id_menuRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_MenuItemsRoles_MenuItems1
    FOREIGN KEY (id_menuItem)
    REFERENCES MenuItem (id_menuItem)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  
CREATE  TABLE IF NOT EXISTS   Usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  ap_paterno VARCHAR(45) NOT NULL,
  ap_materno VARCHAR(45) NULL,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  correo_eletronico VARCHAR(80) NOT NULL,
  password VARCHAR(45) NOT NULL,
  ind_vigencia_usuario INT NOT NULL DEFAULT 1,
  dependencia_universitaria VARCHAR(80) NOT NULL,
  id_menuRol INT NOT NULL,

  PRIMARY KEY (id_usuario),
  UNIQUE INDEX correo_eletronico_UNIQUE (correo_eletronico ASC),
   CONSTRAINT fk_Usuario_MenuRol1
    FOREIGN KEY (id_menuRol)
    REFERENCES MenuRol (id_menuRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 
    
CREATE TABLE IF NOT EXISTS EquipoComputo (
  id_equipoComputo INT NOT NULL AUTO_INCREMENT,
  id_usuarioResponsable INT NOT NULL,
  desc_tipoEquipo VARCHAR(45) NOT NULL,
  id_usuarioAsignado INT NULL,
  marca_computo VARCHAR(45) NOT NULL,
  modelo_computo VARCHAR(45) NOT NULL,
  ubicacion VARCHAR(45) NULL,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion DATETIME NULL,
  ind_vigencia_equipo INT NOT NULL DEFAULT 0,
  estado_equipo VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_equipoComputo),
  INDEX fk_EquipoComputo_TipoEquipoComputo1_idx (desc_tipoEquipo ASC),
  INDEX fk_EquipoComputo_Usuario1_idx (id_usuarioResponsable ASC),
  INDEX fk_EquipoComputo_Usuario2_idx (id_usuarioAsignado ASC),
  CONSTRAINT fk_EquipoComputo_Usuario1
    FOREIGN KEY (id_usuarioResponsable)
    REFERENCES Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_EquipoComputo_Usuario2
    FOREIGN KEY (id_usuarioAsignado)
    REFERENCES Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE   TABLE IF NOT EXISTS ReparacionEquipo (
  id_reparacionEquipo INT NOT NULL AUTO_INCREMENT,
  id_equipoComputo INT NOT NULL,
  id_usuarioAsignado INT NOT NULL,
  id_usuarioResponsable INT NOT NULL,
  desc_reparacion VARCHAR(105) NOT NULL,
  desc_motivo VARCHAR(45) NOT NULL,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion DATETIME NULL,
  ind_vigencia_reparacion INT NULL DEFAULT 0,
  PRIMARY KEY (id_reparacionEquipo),
  CONSTRAINT fk_ReparacionEquipo_EquipoComputo1
    FOREIGN KEY (id_equipoComputo)
    REFERENCES EquipoComputo (id_equipoComputo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ReparacionEquipo_Usuario1
    FOREIGN KEY (id_usuarioAsignado)
    REFERENCES Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ReparacionEquipo_Usuario2
    FOREIGN KEY (id_usuarioResponsable)
    REFERENCES Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS EquipoValorCarac (
  id_equipo_val_carac INT NOT NULL AUTO_INCREMENT,
  id_equipoComputo INT NOT NULL,
  descripcion_caract VARCHAR(45) NOT NULL,
  valor_caract VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_equipo_val_carac),
  INDEX fk_EquipoValorCarac_EquipoComputo1_idx (id_equipoComputo ASC),
  CONSTRAINT fk_EquipoValorCarac_EquipoComputo1
    FOREIGN KEY (id_equipoComputo)
    REFERENCES EquipoComputo (id_equipoComputo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(1,null,'USUARIOS','etiqueta','memu');
INSERT INTO MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(2,null,'EQUIPOS','etiqueta','memu');
INSERT INTO MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(3,null,'REPORTES','etiqueta','memu');
INSERT INTO MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(4,1,'Administrar Usuarios','etiqueta','memu');
INSERT INTO MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(5,2,'Administrar Equipos','etiqueta','memu');
INSERT INTO MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(6,2,'Equipos Asignados','etiqueta','memu');
INSERT INTO MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(7,3,'Reporte Movimiento','etiqueta','memu');


INSERT INTO DependenciaUniversitaria(id_dependencia,descripcion) values(1,'AUDITORIA INTERNA');
INSERT INTO DependenciaUniversitaria(id_dependencia,descripcion) values(2,'BIBLIOTECA NACIONAL');
INSERT INTO DependenciaUniversitaria(id_dependencia,descripcion) values(3,'CASA DEL LAGO');
INSERT INTO DependenciaUniversitaria(id_dependencia,descripcion) values(4,'CENTRO DE CIENCIAS FISICAS');
INSERT INTO DependenciaUniversitaria(id_dependencia,descripcion) values(5,'CENTRO DE ESTUDIOS SOBRE LA UNIVERSIDAD');    
    
INSERT INTO MenuRol (id_menuRol,ref_role,descripcion_rol) values(1,'REF_ADMIN',' Usuario Administrador');
INSERT INTO MenuRol (id_menuRol,ref_role,descripcion_rol) values(2,'REF_CAPTURISTA',' Usuario capturista');
INSERT INTO MenuRol (id_menuRol,ref_role,descripcion_rol) values(3,'REF_RESPONSABLE','Usuario Responsable');  

INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,1);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,2);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,3);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,4);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,5);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,6);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,7);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (2,1);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (2,2);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (2,3);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (2,4);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (2,5);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (2,6);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (2,7);

INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (3,1);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (3,2);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (3,3);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (3,4);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (3,5);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (3,6);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (3,7);


INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (1,'nombre1','ap_paterno1','ap_materno1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo1@gmail.com','wedaa1',1,'dependencia_universitaria',1);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (2,'nombre2','ap_paterno2','ap_materno2',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo2@gmail.com','wedaa2',1,'dependencia_universitaria',1);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (3,'nombre3','ap_paterno3','ap_materno3',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo3@hotmail.com','wedaa3',1,'dependencia_universitaria',1);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (4,'nombre4','ap_paterno4','ap_materno4',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo4@hotmail.com','wedaa4',1,'dependencia_universitaria',2);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (5,'nombre5','ap_paterno5','ap_materno5',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo5@hotmail.com','wedaa5',1,'dependencia_universitaria',2);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (6,'nombre6','ap_paterno6','ap_materno6',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo6@hotmail.com','wedaa6',1,'dependencia_universitaria',2);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (7,'nombre7','ap_paterno7','ap_materno7',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo7@hotmail.com','wedaa7',1,'dependencia_universitaria',2);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (8,'nombre8','ap_paterno8','ap_materno8',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo8@hotmail.com','wedaa8',1,'dependencia_universitaria',2);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (9,'nombre9','ap_paterno9','ap_materno9',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo9@hotmail.com','wedaa9',1,'dependencia_universitaria',2);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (10,'nombre10','ap_paterno10','ap_materno10',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo10@yahoo.com','wedaa10',1,'dependencia_universitaria',3);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (11,'nombre11','ap_paterno11','ap_materno11',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo11@yahoo.com','wedaa11',1,'dependencia_universitaria',3);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (12,'nombre12','ap_paterno12','ap_materno12',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo12@yahoo.com','wedaa12',1,'dependencia_universitaria',3);
INSERT INTO Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria,id_menuRol) values (13,'nombre13','ap_paterno13','ap_materno13',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo13@yahoo.com','wedaa13',1,'dependencia_universitaria',3);



INSERT INTO EquipoComputo 
(id_equipoComputo,id_usuarioResponsable,desc_tipoEquipo,id_usuarioAsignado,marca_computo,modelo_computo,ubicacion,fecha_creacion,fecha_actualizacion,ind_vigencia_equipo,estado_equipo)
VALUES
(1,1,'MONITOR',2,'marca','modelo','ubicacion',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0,'REGISTRADO');


INSERT INTO EquipoComputo 
(id_equipoComputo,id_usuarioResponsable,desc_tipoEquipo,id_usuarioAsignado,marca_computo,modelo_computo,ubicacion,fecha_creacion,fecha_actualizacion,ind_vigencia_equipo,estado_equipo)
VALUES
(2,1,'CPU',2,'marca2','modelo2','ubicacion2',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0,'ASIGNADO');





INSERT INTO ReparacionEquipo 
(id_reparacionEquipo,id_equipoComputo,id_usuarioAsignado,id_usuarioResponsable,desc_reparacion,desc_motivo,fecha_creacion,fecha_actualizacion,ind_vigencia_reparacion)
values
(1,1,1,2,'cambio','no prende',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO ReparacionEquipo 
(id_reparacionEquipo,id_equipoComputo,id_usuarioAsignado,id_usuarioResponsable,desc_reparacion,desc_motivo,fecha_creacion,fecha_actualizacion,ind_vigencia_reparacion)
values
(2,2,3,4,'actualizacion de memoria ram','maquina muy lenta',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

