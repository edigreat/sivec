;

CREATE SCHEMA SIVEC AUTHORIZATION sa;

CREATE MEMORY  TABLE IF NOT EXISTS SIVEC.DependenciaUniversitaria (
  id_dependencia INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_dependencia));

CREATE MEMORY  TABLE IF NOT EXISTS SIVEC.MenuRol (
  id_menuRol INT NOT NULL AUTO_INCREMENT,
  ref_role VARCHAR(45) NOT NULL,
  descripcion_rol VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_menuRol));  
  
  
  

  CREATE MEMORY  TABLE IF NOT EXISTS SIVEC.MenuItem (
  id_menuItem INT NOT NULL AUTO_INCREMENT,
  id_menuParent INT NULL DEFAULT NULL,
  etiqueta VARCHAR(45) NOT NULL,
  accion VARCHAR(45) NOT NULL,
  nombre_menu VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_menuItem),
  CONSTRAINT fk_MenuItems_MenuItems
    FOREIGN KEY (id_menuParent)
    REFERENCES SIVEC.MenuItem (id_menuItem)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
      
    
CREATE MEMORY TABLE IF NOT EXISTS SIVEC.MenuItemRol (
  id_menuRol INT NOT NULL,
  id_menuItem INT NOT NULL,
  CONSTRAINT fk_MenuItemsRoles_MenuRoles1
    FOREIGN KEY (id_menuRol)
    REFERENCES SIVEC.MenuRol (id_menuRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_MenuItemsRoles_MenuItems1
    FOREIGN KEY (id_menuItem)
    REFERENCES SIVEC.MenuItem (id_menuItem)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  
CREATE MEMORY  TABLE IF NOT EXISTS   SIVEC.Usuario (
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
    REFERENCES SIVEC.MenuRol (id_menuRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 
    
CREATE MEMORY TABLE IF NOT EXISTS SIVEC.EquipoComputo (
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
   CONSTRAINT fk_EquipoComputo_Usuario1
    FOREIGN KEY (id_usuarioResponsable)
    REFERENCES SIVEC.Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_EquipoComputo_Usuario2
    FOREIGN KEY (id_usuarioAsignado)
    REFERENCES SIVEC.Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE MEMORY   TABLE IF NOT EXISTS SIVEC.ReparacionEquipo (
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
    REFERENCES SIVEC.EquipoComputo (id_equipoComputo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ReparacionEquipo_Usuario1
    FOREIGN KEY (id_usuarioAsignado)
    REFERENCES SIVEC.Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ReparacionEquipo_Usuario2
    FOREIGN KEY (id_usuarioResponsable)
    REFERENCES SIVEC.Usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE MEMORY TABLE IF NOT EXISTS SIVEC.EquipoValorCarac (
  id_equipo_val_carac INT NOT NULL AUTO_INCREMENT,
  id_equipoComputo INT NOT NULL,
  descripcion_caract VARCHAR(45) NOT NULL,
  valor_caract VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_equipo_val_carac),
  CONSTRAINT fk_EquipoValorCarac_EquipoComputo1
    FOREIGN KEY (id_equipoComputo)
    REFERENCES SIVEC.EquipoComputo (id_equipoComputo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO SIVEC.MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(1,null,'USUARIOS','etiqueta','memu');
INSERT INTO SIVEC.MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(2,null,'EQUIPOS','etiqueta','memu');
INSERT INTO SIVEC.MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(3,null,'REPORTES','etiqueta','memu');
INSERT INTO SIVEC.MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(4,1,'Administrar Usuarios','etiqueta','memu');
INSERT INTO SIVEC.MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(5,2,'Administrar Equipos','etiqueta','memu');
INSERT INTO SIVEC.MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(6,2,'Equipos Asignados','etiqueta','memu');
INSERT INTO SIVEC.MenuItem(id_menuItem,id_menuParent,etiqueta,accion,nombre_menu) values(7,3,'Reporte Movimiento','etiqueta','memu');


INSERT INTO SIVEC.DependenciaUniversitaria(id_dependencia,descripcion) values(1,'AUDITORIA INTERNA');
INSERT INTO SIVEC.DependenciaUniversitaria(id_dependencia,descripcion) values(2,'BIBLIOTECA NACIONAL');
INSERT INTO SIVEC.DependenciaUniversitaria(id_dependencia,descripcion) values(3,'CASA DEL LAGO');
INSERT INTO SIVEC.DependenciaUniversitaria(id_dependencia,descripcion) values(4,'CENTRO DE CIENCIAS FISICAS');
INSERT INTO SIVEC.DependenciaUniversitaria(id_dependencia,descripcion) values(5,'CENTRO DE ESTUDIOS SOBRE LA UNIVERSIDAD');    
    
INSERT INTO SIVEC.MenuRol (id_menuRol,ref_role,descripcion_rol) values(1,'ROLE_ADMIN',' Usuario Administrador');
INSERT INTO SIVEC.MenuRol (id_menuRol,ref_role,descripcion_rol) values(2,'ROLE_CAPTURISTA',' Usuario capturista');
INSERT INTO SIVEC.MenuRol (id_menuRol,ref_role,descripcion_rol) values(3,'ROLE_RESPONSABLE','Usuario Responsable');  

INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (1,1);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (1,2);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (1,3);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (1,4);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (1,5);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (1,6);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (1,7);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (2,1);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (2,2);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (2,3);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (2,4);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (2,5);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (2,6);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (2,7);

INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (3,1);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (3,2);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (3,3);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (3,4);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (3,5);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (3,6);
INSERT INTO SIVEC.MenuItemRol(id_menuRol,id_menuItem) values (3,7);
