

use treninordovest;
insert into utente values("US001","Xcaawd21","Paolo","Rossi","M","Napoli","2001-09-11","33213213","Napoli , Via Brombeis 2");
insert into utente values("US002","Xcaawd21","Lorenzo","Brambilla","M","Cologno Monzese","1998-5-2","33213213","Milano , Via Roma 267");

insert into cliente values("US001",250,"Paolo@gmail.com");

select * from utente;
select * from cliente;
select * from abbonamento;
select * from rimborso;
select * from biglietto;

select * from (treno tr join trenotratta tt on tr.IDTreno=tt.IDTreno)join tratta ta on tt.IDTratta=ta.IDTratta;


create view FermateTratte as
select fe.*,ta.*,tt.NumOrdine,tt.Binario,tt.OraPartenza,tt.OraArrivo from (fermata fe join trattafermata tt on fe.IDFermata=tt.IDFermata)join tratta ta on tt.IDTratta=ta.IDTratta;

select * from pagamento;
select * from storicopagamento;
select * from viaggio;

select * from tratta;
select * from trattafermata;
select * from fermata;

insert into treno values("FTN214","Hitachi",3500,150);
insert into treno values("FTN215","Alstom",4500,350);

select * from treno;

select * from cliente;

insert into utente values("US001",0,"spaolo@gmail.com");

select * from FermateTratte;

select * from FermateTratte where IDTratta='T113';



