

create table usuarios(id_usuario INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255) NOT NULL, pass VARCHAR(255) NOT NULL, rol VARCHAR(255) NOT NULL);
insert into usuarios values (0, "admin", MD5("admin"), "ADMIN"), (0, "user", MD5("user"), "OPERARIO"), (0, "idt", MD5("idt"), "IDT");

insert into proveedor (id_proveedor, nombre, nif, telefono, direccion) values (0, "HARIVASA", "A1254376", "949765412", "Av. del trigo, 25"), (0, "Sal de Roca", "T9835376", "917760987", "C/ del galgo, 1"), 
		      (0, "GRACOMSA", "R1254432", "929875344", "Av. del hormigón, SN"), (0, "QUIMOSA", "A7645324", "962348700", "C/ del altiplano, 44"), 
		      (0, "Envalajes del Centro S.A.", "A7654397", "976645398", "C/ Santa Eulalia, 15"), (0, "Plásticos Romero S.L.", "P6534231", "928345672", "C/ del Espolón, 1"), (0, "Canal de Isabel II", "A86488087", "900365365", "C/ Santa Engracia, 125");

insert into producto (id_producto, nombre , tipo) values (0, "Agua", "MP"), (0, "Harina de trigo", "MP"), (0, "Harina integral", "MP"), (0, "Harina de maiz", "MP"), 
		     (0, "Sal fina", "MP"), (0, "Levadura química", "MP"), (0, "Aceite de girasol", "MP"), (0, "Mantequilla", "MP"), (0, "Propionato", "MP"),
		     (0, "Caja 12UDS", "CAJA"), (0, "Caja 24UDS", "CAJA"), (0, "Caja Plástico", "CAJA"), (0, "Rollo PET Tortillas", "ENV"), (0, "Rollo PET Barras", "ENV");

insert into suministra (id_suministro, albaran, cantidad_recepcionada, cantidad_stock, fecha_recepcion, fecha_caducidad, lote_producto, id_producto, id_proveedor) values (0, "0000", "0000", "0000", "0000-00-00", "0000-00-00", "00000", 1, 7),
		       (0, "126543H", "18000", "18000", "2023-03-09", "2023-06-09", "45678HB", 2, 1), (0, "126543H", "12500", "12500", "2023-03-09", "2023-05-09", "56778HI", 3, 1), 
		       (0, "1399326S", "1000", "1000", "2023-03-11", "2024-03-01", "00326S", "5", "2"), (0, "765439L", "12500", "12500", "2023-03-12", "2025-01-01", "20230101-BC", "6", "4"), 
		       (0, "9008765G", "20000", "20000", "2023-03-12", "2023-07-20", "567432G", "7", "3"), (0, "9008765G", "20000", "20000", "2023-03-12", "2023-07-20", "777432M", "8", "3"), 
		       (0, "876123CC", "20000", "20000", "2023-03-13", null, "8723CC", "10", "5"), (0, "876123CC", "18000", "18000", "2023-03-13", null, "6123CC", "11", "5"), 
		       (0, "654783CP", "5000","5000", "2023-03-13", null, "5534P", "12", "6"), (0, "654783CP", "5000","5000", "2023-03-13", null, "6534P", "13", "6"),
		       (0, "654783CP", "500", "500", "2023-03-13", null, "7534P", "14", "6"), (0, "9118767G", "20000", "20000", "2023-03-15", "2023-08-01", "567440G", "7", "3"),
		       (0, "1454326S", "1000","1000", "2023-03-16", "2024-03-01", "00326S", "5", "2"), (0, "237640H", "19700","19700", "2023-03-20", "2023-06-20", "45689HB", "2", "1"),
		       (0, "237640H", "17850", "17850", "2023-03-20", "2023-05-20", "65189HM", "4", "1"), (0, "807639L", "2500","2500", "2023-03-21", "2030-01-01", "20230101-PS", "9", "4"),
		       (0, "807639L", "12500", "12500", "2023-03-21", "2025-02-01", "20230201-BC", 6, 4);

insert into receta values (0, "Baguette"), (0, "Tortilla de trigo"), (0, "Tortilla de trigo integral"), (0, "Arepa");

insert into utiliza (id_uso, cantidad_mp, id_producto, id_receta) values 
		    (0, 585.0, 2, 1), (0, 390.0, 1, 1), (0, 10.0, 5, 1), (0, 5.0, 6, 1),
		    (0, 585.5, 2, 2), (0, 390.0, 1, 2), (0, 10.0, 5, 2), (0, 0.5, 9, 2), (0, 10.0, 7, 2),
		    (0, 540.0, 3, 3), (0, 435.5, 1, 3), (0, 10.0, 5, 3), (0, 0.5, 9, 3), (0, 10.0, 7, 3),
 		    (0, 654.0, 4, 4), (0, 325.5, 1, 4), (0, 10.0, 5, 4), (0, 0.5, 9, 4), (0, 10.0, 8, 4);

insert into producto_final(id_producto_final, nombre, peso_por_unidad, unidades_por_paquete, paquetes_por_caja) values (0, "Baguette", 0.3, 1, 24), (0, "Fajitas naturales", 0.07, 8, 12), (0, "Pan de pita integral", 0.08, 3, 6), (0, "Arepa venezolana", 0.1, 4, 8);

insert into consume (id_consumo, cantidad, lote_produccion, id_suministro) values ();

insert into produccion (lote_produccion, fecha_produccion, fecha_caducidad, unidades, id_producto_final) values ();

insert into cliente (id_cliente, nombre, nif, telefono, direccion) values (0, "Carrefour", "A12376453", "901754329", "C/ de los Almendros, 12"), (0, "ALDI", "A12376453", "949758741", "Av. de las Canteras, 211"), (0, "Alimentacion MariSol", "AR62376467", "928754334", "C/ del Mercurio, 51");

insert into envio (id_envio, albaran, cantidad, fecha_envio, lote, id_cliente, id_producto_final) values (); 
		       


