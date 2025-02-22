use treninordovest;
insert into treno values('FS1127','ATR223',4469,124);
insert into treno values('FS1124','ATR223',4469,124);
select * from treno;

insert into tratta values("RE1123","Milano - Torino",200);
select * from tratta;

insert into fermata values("FS001","Milano Centrale",20);
insert into fermata values("FS002","Novara",6);
insert into fermata values("FS003","Vercelli",6);
insert into fermata values("FS004","Chivasso",4);
insert into fermata values("FS005","Torino Porta Nuova",20);

select * from fermata;

insert into trattafermata values("RE1123",1,"FS001");
insert into trattafermata values("RE1123",2,"FS002");
insert into trattafermata values("RE1123",3,"FS003");
insert into trattafermata values("RE1123",4,"FS004");
insert into trattafermata values("RE1123",5,"FS005");

select * from trattafermata;

select * 
from (tratta tr join trattafermata tf  on tr.IDTratta=tf.IDTratta) join fermata fr on fr.IDFermata=tf.IDFermata  ;


insert into utente values("US0013","Tuasorella","Paolino","Finotti","M","Napoli","1967-2-11","3341125478","Napoli, Via Brombeis 2");
insert into cliente values("US0013",350.37,"paolinofino@gmail.com");
insert into utente values("DP0014","Tuasorella","Marino","Armandi","M","Napoli","1997-9-17","3841125478","Napoli, Via Spaccanapoli 28");
insert into dipendente values("DP0014",1000,"Macchinista","FS1127");

select * from utente;
select * from cliente;
select * from dipendente;

select * from utente ut join cliente cl on ut.ID=cl.IDCliente;
select * from utente ut join dipendente dp on ut.ID=dp.IDDipendente;

insert into tessera values("TS11245","2021-5-11","2027-5-11","US0013");
select * from tessera;

insert into titoloviaggio values("AB0001","2024-2-9",7.5);
insert into abbonamento values("AB0001","Sett","2024-02-16","TS11245");

select * from titoloviaggio;
select * from abbonamento;
select * from biglietto;

select * from titoloviaggio join abbonamento on IDAbbonamento=IDTitolo;

insert into titoloviaggio values("BG0001","PG2314","2025-2-12",5);
insert into titoloviaggio values("BG0002","PG2314","2025-2-12",5);
insert into biglietto values ("BG0001",false,false);
insert into biglietto values ("BG0002",false,false);

insert into pagamento values ("PG2314","US0013",5.2,"Carta","2025-02-12 12:34:56");

select  * from pagamento;

