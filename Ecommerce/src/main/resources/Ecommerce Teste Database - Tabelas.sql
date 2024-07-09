
create database test;
 
use test;

create table clientes(
	cod_cli int auto_increment,
    nome_cli varchar(255) not null,
    tel_cli varchar(20),
    email_cli varchar(100) unique not null,
    cpf_cli varchar(20),
    verification_code varchar(255),
    role varchar(30),
    enabled boolean default(false),
    pass_cli varchar(100),
    primary key(cod_cli)
);


create table pedidos(
		num_ped int not null auto_increment,
        cod_cli int not null,
        data_inicial datetime not null,
        data_final datetime,
        status_ped varchar(30),
        valor_total decimal(10,2),
        
        constraint pk_ped primary key(num_ped),
        constraint fk_ped_2 foreign key(cod_cli) references clientes (cod_cli)
);

create table categorias(
	cod_cat int auto_increment,
    nome_cat varchar(20) unique,
    
    primary key (cod_cat)
);


create table produtos(
	id_prod int not null auto_increment,
    nome_prod varchar(75) not null unique,
    desc_prod varchar(255) not null,
    custo_prod decimal(10,2) not null,
    val_prod decimal(10,2) not null,
    qtd_estq int not null,
    cod_cat int, 
    image varchar(255),
    
    constraint pk_prod primary key(id_prod),
    
    constraint fk_prod foreign key(cod_cat) references categorias(cod_cat),
    
	constraint ch_prod_1 check(val_prod>=0),

	constraint ch_prod_2 check(qtd_estq>=0)
);

create table pedidos_produtos(
	id_prod int,
    num_ped int,
    qtd_prod int, 
    val_prod decimal(10, 2),
    
    constraint pk_pedprod primary key(id_prod, num_ped),
    constraint fk_pedprod_1 foreign key(id_prod) references produtos (id_prod),
    constraint fk_pedprod_2 foreign key(num_ped) references pedidos(num_ped)
);

insert into categorias values(1, "comida");




