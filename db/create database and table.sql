create database if not exists exportcontas;
use exportcontas;
create table if not exists clientes(
       cpf char(11) not null,
       nome varchar(200) not null ,
       dataNascimento date not null,
       sexo char(1) not null,
       constraint chk_sexo check (sexo in ('M','F')),
       constraint pk_clientes_cpf primary key (cpf)       
);
create table if not exists contas (
       id int not null auto_increment,
       numero int not null ,
       saldo numeric(12,2) not null ,
       dataAbertura Date not null,
       operacao char(3) not null,
       cliente char(11) not null ,
	   constraint chk_tipoConta check (tipoConta in (1,2)),
       constraint pk_contas_id primary key (id),
	   constraint fk_clientes_cpf foreign key (cliente) references clientes (cpf),
       constraint un_conta_operacao unique (cliente,operacao)
);
       

                   




