;              

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
