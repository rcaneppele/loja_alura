ALTER TABLE produtos ADD CONSTRAINT produtos_categoria_id_fk FOREIGN KEY (categoria_id)  REFERENCES categorias(id);