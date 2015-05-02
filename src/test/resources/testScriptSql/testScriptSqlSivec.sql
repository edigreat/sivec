;              

CREATE MEMORY TABLE IF NOT EXISTS PUBLIC.DependenciaUniversitaria (
  id_dependencia INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_dependencia));
  
CREATE MEMORY TABLE IF NOT EXISTS   PUBLIC.Usuario (
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
  PRIMARY KEY (id_usuario),
  UNIQUE INDEX correo_eletronico_UNIQUE (correo_eletronico ASC));
 
CREATE MEMORY TABLE IF NOT EXISTS PUBLIC.MenuRol (
  id_menuRol INT NOT NULL AUTO_INCREMENT,
  ref_role VARCHAR(45) NOT NULL,
  descripcion_rol VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_menuRol));  
  
  CREATE MEMORY TABLE IF NOT EXISTS UsuarioMenuRol (
  id_menuRol INT NOT NULL,
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_menuRol, id_usuario),
  CONSTRAINT fk_UsuarioMenuRol_MenuRol1
    FOREIGN KEY (id_menuRol)
    REFERENCES MenuRol (id_menuRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_UsuarioMenuRol_Usuario1
    FOREIGN KEY (id_usuario)
    REFERENCES Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

  CREATE MEMORY TABLE IF NOT EXISTS MenuItem (
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

    


CREATE MEMORY TABLE IF NOT EXISTS MenuItemRol (
  id_menuRol INT NOT NULL,
  id_menuItem INT NOT NULL,
  PRIMARY KEY (id_menuRol, id_menuItem),
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

 CREATE MEMORY TABLE IF NOT EXISTS CaracteristicaEquipo (
  id_caractaristica_equipo INT NOT NULL AUTO_INCREMENT,
  etiqueta_caracteristica VARCHAR(45) NOT NULL,
  desc_caracteristica VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_caractaristica_equipo));   
 
  CREATE MEMORY TABLE IF NOT EXISTS TipoEquipoComputo (
  id_tipoEquipoComputo INT NOT NULL AUTO_INCREMENT,
  etiqueta_tipoEquipo VARCHAR(45) NOT NULL,
  desc_tipoEquipo VARCHAR(45) NULL,
  PRIMARY KEY (id_tipoEquipoComputo));

  CREATE MEMORY TABLE IF NOT EXISTS TipoCaracteristicaEquipo (
  id_caracterisrica_equipo INT NOT NULL,
  id_tipoEquipoComputo INT NOT NULL,
  PRIMARY KEY (id_caracterisrica_equipo, id_tipoEquipoComputo),
  CONSTRAINT fk_TipoCaracteristicaEquipo_CaracteristicaEquipo1
    FOREIGN KEY (id_caracterisrica_equipo)
    REFERENCES CaracteristicaEquipo (id_caractaristica_equipo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_TipoCaracteristicaEquipo_TipoEquipoComputo1
    FOREIGN KEY (id_tipoEquipoComputo)
    REFERENCES TipoEquipoComputo (id_tipoEquipoComputo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION); 
    
CREATE MEMORY TABLE IF NOT EXISTS EquipoComputo (
  id_equipoComputo INT NOT NULL AUTO_INCREMENT,
  id_usuarioResponsable INT NOT NULL,
  id_tipoEquipo INT NOT NULL,
  id_usuarioAsignado INT NULL,
  marca_computo VARCHAR(45) NOT NULL,
  modelo_computo VARCHAR(45) NOT NULL,
  ubicacion VARCHAR(45) NULL,
  fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  ind_vigencia_equipo INT NOT NULL DEFAULT 0,
  estado_equipo VARCHAR(45) NOT NULL DEFAULT 'REGISTRADO',
  PRIMARY KEY (id_equipoComputo),
  CONSTRAINT fk_EquipoComputo_TipoEquipoComputo1
    FOREIGN KEY (id_tipoEquipo)
    REFERENCES TipoEquipoComputo (id_tipoEquipoComputo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
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

INSERT INTO TipoEquipoComputo(id_tipoEquipoComputo,etiqueta_tipoEquipo,desc_tipoEquipo) values(1,'CPU','Computadora');
INSERT INTO TipoEquipoComputo(id_tipoEquipoComputo,etiqueta_tipoEquipo,desc_tipoEquipo) values(2,'Monitor','Monitor');
    
INSERT INTO CaracteristicaEquipo(id_caractaristica_equipo,etiqueta_caracteristica,desc_caracteristica) values(1,'RAM','Memoria Ram');
INSERT INTO CaracteristicaEquipo(id_caractaristica_equipo,etiqueta_caracteristica,desc_caracteristica) values(2,'SO','Sistema operativo');
INSERT INTO CaracteristicaEquipo(id_caractaristica_equipo,etiqueta_caracteristica,desc_caracteristica) values(3,'Pulg','Pulgadas');
INSERT INTO CaracteristicaEquipo(id_caractaristica_equipo,etiqueta_caracteristica,desc_caracteristica) values(4,'LCD','Disco Duro');
  
INSERT INTO TipoCaracteristicaEquipo(id_caracterisrica_equipo,id_tipoEquipoComputo) values(1,1);
INSERT INTO TipoCaracteristicaEquipo(id_caracterisrica_equipo,id_tipoEquipoComputo) values(2,1);
INSERT INTO TipoCaracteristicaEquipo(id_caracterisrica_equipo,id_tipoEquipoComputo) values(3,2);
INSERT INTO TipoCaracteristicaEquipo(id_caracterisrica_equipo,id_tipoEquipoComputo) values(4,2);

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
  
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (1,'nombre1','ap_paterno1','ap_materno1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo1','wedaa1',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (2,'nombre2','ap_paterno2','ap_materno2',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo2','wedaa2',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (3,'nombre3','ap_paterno3','ap_materno3',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo@3','wedaa3',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (4,'nombre4','ap_paterno4','ap_materno4',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo@4','wedaa4',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (5,'nombre5','ap_paterno5','ap_materno5',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo@5','wedaa5',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (6,'nombre6','ap_paterno6','ap_materno6',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo@6','wedaa6',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (7,'nombre7','ap_paterno7','ap_materno7',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo@7','wedaa7',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (8,'nombre8','ap_paterno8','ap_materno8',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo@8','wedaa8',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (9,'nombre9','ap_paterno9','ap_materno9',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo@9','wedaa9',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (10,'nombre10','ap_paterno10','ap_materno10',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo10','wedaa10',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (11,'nombre11','ap_paterno11','ap_materno11',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo11','wedaa11',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (12,'nombre12','ap_paterno12','ap_materno12',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo12','wedaa12',1,'dependencia_universitaria');
INSERT INTO PUBLIC.Usuario(id_usuario,nombre,ap_paterno,ap_materno,fecha_creacion,fecha_actualizacion,correo_eletronico,password,ind_vigencia_usuario,dependencia_universitaria) values (13,'nombre13','ap_paterno13','ap_materno13',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'miccreo13','wedaa13',1,'dependencia_universitaria');

INSERT INTO PUBLIC.UsuarioMenuRol (id_menuRol,id_usuario) values(1,1);
INSERT INTO PUBLIC.UsuarioMenuRol (id_menuRol,id_usuario) values(2,2);
INSERT INTO PUBLIC.UsuarioMenuRol (id_menuRol,id_usuario) values(3,3);
INSERT INTO PUBLIC.UsuarioMenuRol (id_menuRol,id_usuario) values(2,4);
INSERT INTO PUBLIC.UsuarioMenuRol (id_menuRol,id_usuario) values(3,5);

INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,1);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,2);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,3);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,4);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,5);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,6);
INSERT INTO MenuItemRol(id_menuRol,id_menuItem) values (1,7);

INSERT INTO EquipoComputo 
(id_equipoComputo,id_usuarioResponsable,id_tipoEquipo,id_usuarioAsignado,marca_computo,modelo_computo,ubicacion,fecha_creacion,fecha_actualizacion,ind_vigencia_equipo,estado_equipo)
VALUES
(1,1,1,2,'marca','modelo','ubicacion',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0,'REGISTRADO');


INSERT INTO EquipoComputo 
(id_equipoComputo,id_usuarioResponsable,id_tipoEquipo,id_usuarioAsignado,marca_computo,modelo_computo,ubicacion,fecha_creacion,fecha_actualizacion,ind_vigencia_equipo,estado_equipo)
VALUES
(2,1,1,2,'marca2','modelo2','ubicacion2',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0,'ASIGNADO');
