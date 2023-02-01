create table produtos(
    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    preco decimal(10,2) not null,
    descricao text,

    primary key(id)

);