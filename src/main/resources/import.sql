insert into PRODUCTO (id_Producto,nombre,precio) values(1,'Coca-Cola',12);
insert into PRODUCTO (id_Producto,nombre,precio) values(2,'Pepsi',10);
insert into PRODUCTO (id_Producto,nombre,precio) values(3,'Cola-Real',6);
insert into PRODUCTO (id_Producto,nombre,precio) values(4,'Inka-Cola',10);
insert into PRODUCTO (id_Producto,nombre,precio) values(5,'7Up',8);


insert into CLIENTE(id, nombre,apellido,dni,telefono,email) values (1,'Jhonatan','Mallqui Diaz',77665741,955312358,'Jhonatan@gmail.com')
insert into CLIENTE(id, nombre,apellido,dni,telefono,email) values (2,'Robert','Mallqui Diaz',77666241,955312359,'Robert@gmail.com')
insert into CLIENTE(id, nombre,apellido,dni,telefono,email) values (3,'Jireh','Mallqui Diaz',77665451,955312310,'Jireh@gmail.com')


insert into VENTA (id_venta,id_cliente,fecha) values(1,1,now())
insert into VENTA (id_venta,id_cliente,fecha) values(2,2,now())
insert into VENTA (id_venta,id_cliente,fecha) values(3,3,now())

insert into DETALLE_VENTA(id_detalle_venta,id_venta,id_Producto) values(1,1,1);
insert into DETALLE_VENTA(id_detalle_venta,id_venta,id_Producto) values(2,2,2);
insert into DETALLE_VENTA(id_detalle_venta,id_venta,id_Producto) values(3,3,3);