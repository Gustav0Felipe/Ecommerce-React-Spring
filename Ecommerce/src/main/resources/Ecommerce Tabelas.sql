create database ecommerce;
 
use ecommerce;

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



create table log_cad_cliente(
	id_log_cad int auto_increment,
	cod_cliente_log_cad int not null,
    data_cadastro_log_cad datetime,
	old_email_log_cad varchar(100),
    old_tel_log_cad varchar(20),
    old_cpf_log_cad varchar(20),
	new_email_log_cad varchar(100),
    new_tel_log_cad varchar(20),
    tipo_movimentacao varchar(20) not null,
    
    primary key (id_log_cad),
	foreign key (cod_cliente_log_cad) references clientes (cod_cli)
);

select * from log_cad_cliente;
select* from clientes;
select * from clientes where cod_cli > 8;
select * from log_cad_cliente;
select * from pedidos;
##update pedidos set status_ped = "pendente" where num_ped >= 1;
##insert into pedidos values(null, 1 , now(), now(), "pendente", 0);
##call pd_subir_encomenda_itens(4, 1, 3);
select * from produtos_imagens;
select * from produtos order by nome_prod;
select pedidos.num_ped "Pedido",nome_prod "Produto", nome_cli "Cliente", valor_total "Total" from pedidos_produtos 
join produtos on produtos.id_prod = pedidos_produtos.id_prod 
join pedidos on pedidos.num_ped = pedidos_produtos.num_ped
join clientes on pedidos.cod_cli = clientes.cod_cli where nome_cli = "Usuario De Teste";

select * from admin_sistema_loja;
select year(data_inicial) from pedidos group by year(data_inicial) order by max(year(data_inicial)) asc;
select * from produtos order by nome_prod desc;



