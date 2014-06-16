use exportcontas;

insert into clientes (cpf,nome,dataNascimento,sexo ) values ('74144989801','Matheus Henrique De Oliveira','1994-12-01','M');
insert into clientes (cpf,nome,dataNascimento,sexo ) values ('59472923518','Jean Kunert Reolon'          ,'1974-01-03','M');  
insert into clientes (cpf,nome,dataNascimento,sexo ) values ('37482404309','Jarbas Lemos Pereira Junior' ,'1976-08-01','M');
insert into clientes (cpf,nome,dataNascimento,sexo ) values ('81956258604','Ramon Medeiros de Oliveira'  ,'1992-05-24','M');
insert into clientes (cpf,nome,dataNascimento,sexo ) values ('84212885123','Jefersson Barbosa'           ,'1969-05-01','M');
insert into clientes (cpf,nome,dataNascimento,sexo ) values ('47268404522','Ana Carolina de Melo'        ,'2000-12-01','F'); 
insert into clientes (cpf,nome,dataNascimento,sexo ) values ('92324841614','Alissandra De Cassio Sousa'  ,'1990-07-22','F');  
insert into clientes (cpf,nome,dataNascimento,sexo ) values ('13018244370','Bruno Bernardo dos Santos'   ,'1973-04-02','M');

select * from clientes;

insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220100,123.44,'2000-01-01','001','74144989801');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220110,123.44,'2000-01-01','002','74144989801');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220101, 99.50,'2010-03-25','001','59472923518');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220111, 99.50,'2010-03-25','002','59472923518');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220102, 30.32,'2012-04-17','001','37482404309');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220112, 30.32,'2012-04-17','002','37482404309');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220103,  0.00,'2013-05-06','001','81956258604');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220113,  0.00,'2013-05-06','002','81956258604');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220104,300.20,'2014-12-01','001','84212885123');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220114,300.20,'2014-12-01','002','84212885123');

insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220105,245.15,'2009-02-28','001','47268404522');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220115,245.15,'2009-02-28','002','47268404522');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220106,500.10,'2007-05-09','001','92324841614');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220116,500.10,'2007-05-09','002','92324841614');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220107,200.10,'2007-03-13','001','13018244370');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values  (1220117,200.10,'2007-03-13','002','13018244370');



select * from contas ;


select 
  numero 'Nº da Conta', 
  nome 'Nome', 
  EXTRACT(YEAR FROM now()) - EXTRACT(YEAR FROM clientes.dataNascimento) 'Idade'
from contas,clientes where contas.cliente = clientes.cpf  order by idade -- and  EXTRACT(YEAR FROM now()) - EXTRACT(YEAR FROM clientes.dataNascimento) >= 22;

