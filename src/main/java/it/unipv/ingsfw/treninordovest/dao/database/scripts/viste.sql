use treninordovest;

create view utentiClienti as
select *
from utente ut join cliente cl on ut.ID=cl.IDCliente;

create view utentiDipendenti as
select *
from utente ut join dipendente cl on ut.ID=cl.IDDipendente;

create view titoliAbbonamenti as
select * from titoloviaggio tv join abbonamento ab on tv.IDTitolo=ab.IDAbbonamento;

create view titoliBiglietti as
select * from titoloviaggio tv join biglietto bg on tv.IDTitolo=bg.IDBiglietto;


select * from titoliAbbonamenti;

/*
create view titoloBiglietto
as
*/


select *
from utentiDipendenti;

select * 
from utentiClienti;

select * from cliente;

delete 
from utentiClienti
where ID='U009';

select * from tessera;

select * from abbonamento;



