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

insert into contas (numero,saldo,dataAbertura,operacao,cliente) values (122101,0.00,'2000-01-01','001','84212885123');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values (122102,0.00,'2000-01-02','001','13018244370');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values (122103,0.00,'2000-01-03','001','47268404522');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values (122104,0.00,'2000-01-04','001','92324841614');
insert into contas (numero,saldo,dataAbertura,operacao,cliente) values (122105,0.00,'2000-05-04','002','92324841614');

select * from contas where numero =;


select 
  numero 'Nº da Conta', 
  nome 'Nome', 
  EXTRACT(YEAR FROM now()) - EXTRACT(YEAR FROM clientes.dataNascimento) 'Idade'
from contas,clientes where contas.cliente = clientes.cpf  and  EXTRACT(YEAR FROM now()) - EXTRACT(YEAR FROM clientes.dataNascimento) >= 22;

