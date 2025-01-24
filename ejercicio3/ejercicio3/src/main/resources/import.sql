INSERT INTO estacion (id, nombre, numero, coordenadas, capacidad)
VALUES (nextval('estacion_seq'), 'Estación Central', 101, '40.416775,-3.703790', 50);


INSERT INTO estacion (id, nombre, numero, coordenadas, capacidad)
VALUES (nextval('estacion_seq'), 'Plaza Mayor', 102, '40.415363,-3.707398', 30);


INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Orbea', 'Rallon', 'Disponible', (SELECT id FROM estacion WHERE nombre = 'Estación Central')
);


INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Specialized', 'Stumpjumper', 'En reparación', (SELECT id FROM estacion WHERE nombre = 'Estación Central')
);


INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Trek', 'Domane', 'Disponible', (SELECT id FROM estacion WHERE nombre = 'Plaza Mayor')
);

INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Cannondale', 'Trail 7', 'Disponible', (SELECT id FROM estacion WHERE nombre = 'Puerta del Sol'));

INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Giant', 'Defy', 'En reparación', (SELECT id FROM estacion WHERE nombre = 'Estación Atocha'));

INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Bianchi', 'Oltre XR4', 'Disponible', (SELECT id FROM estacion WHERE nombre = 'Gran Vía'));

INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Scott', 'Spark', 'Reservada', (SELECT id FROM estacion WHERE nombre = 'Estación Atocha'));

INSERT INTO bicicleta (id, marca, modelo, estado, estacion_id)
VALUES (nextval('bicicleta_seq'), 'Merida', 'Big Nine', 'Disponible', (SELECT id FROM estacion WHERE nombre = 'Puerta del Sol'));