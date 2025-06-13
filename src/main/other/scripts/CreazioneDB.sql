drop schema if exists treninordovest;
create schema treninordovest;
use treninordovest;

/*Controllo tabelle*/
drop table if exists rimborso;
drop table if exists dipendente;
drop table if exists abbonamento;
#drop table if exists bigliettoviaggio;
drop table if exists storicopagamento;
drop table if exists biglietto;
drop table if exists titoloviaggio;
drop table if exists pagamento;
drop table if exists tessera;
drop table if exists cliente;
drop table if exists utente;
drop table if exists trenotratta;
drop table if exists treno;
drop table if exists trattafermata;
drop table if exists viaggio;
drop table if exists tratta;
drop table if exists fermata;



/*Area Treni*/

create table treno(
IDTreno varchar(40) not null,
Modello varchar(30) not null,
KW int not null,
NumPosti int not null,
primary key (IDTreno)
);

create table tratta(
IDTratta varchar(40) not null,
Nome varchar(100) not null,
Lunghezza int not null,
primary key (IDTratta)
);

create table trenotratta(
IDTratta varchar(40) not null,
IDTreno varchar(40) not null,
NumTreno int not null,
primary key (IDTratta,IDTreno),
foreign key (IDTratta) references tratta(IDTratta) on delete cascade on update cascade,
foreign key (IDTreno) references treno(IDTreno) on delete cascade on update cascade
);

create table fermata(
IDFermata varchar(40) not null,
Citta varchar(30) not null,
NumBinari int not null,
primary key (IDFermata)
);


create table trattafermata(
IDTratta varchar(40) not null,
NumOrdine int not null,
IDFermata varchar(40) not null,
Binario int not null,
OraPartenza time not null,
OraArrivo time not null,
primary key (IDTratta,NumOrdine),
foreign key (IDTratta) references tratta(IDTratta) on delete cascade on update cascade,
foreign key (IDFermata) references fermata(IDFermata) on delete cascade on update cascade
);


/*Area Utenze*/
create table utente (
ID varchar(40) not null ,
UserPassword varchar(128),
Nome varchar(30) not null,
Cognome varchar(30) not null,
Sesso varchar(1) not null,
LuogoNascita varchar(20) not null,
DataNascita date not null,
Cellulare varchar(10) not null,
Indirizzo varchar(100) not null,
primary key (ID)
);

create table cliente (
IDCliente varchar(40) not null,
Bilancio double default 0,
Email varchar(40) not null,
primary key (IDCliente),
foreign key (IDCliente) references utente(ID) on delete cascade on update cascade

);

create table dipendente(
IDDipendente varchar(40) not null,
Stipendio double not null,
Ruolo varchar(40) not null,
CodTreno varchar(10) default null,
primary key (IDDipendente),
foreign key (IDDipendente) references utente(ID) on delete cascade on update cascade,
foreign key (CodTreno) references treno(IDTreno) on delete cascade on update cascade
);

create table tessera(
IDTessera varchar(40) not null,
Emissione date not null,
Scadenza date not null,
IDCliente varchar(10) not null,
primary key (IDTessera),
foreign key (IDCliente) references cliente(IDCliente) on delete cascade on update cascade
);

create table pagamento(
IDPagamento varchar(40) not null,
IDCliente varchar(10) not null,
Totale double default 0,
Tipo varchar(30) not null,
DataPagamento date not null ,
primary key (IDPagamento),
foreign key (IDCliente) references cliente(IDCliente) on delete cascade on update cascade
);




/*Area Titoli*/
create table titoloviaggio(
IDTitolo varchar(40) not null,
IDPagamento varchar(40) not null,
Emissione date not null,
Prezzo double not null,
primary key (IDTitolo),
foreign key (IDPagamento) references pagamento(IDPagamento) on delete cascade on update cascade
);

create table biglietto(
IDBiglietto varchar(40) not null,
Ritorno bool default false,
Validato bool default false,
DataRitorno date null ,
DataValidazione date null ,
primary key (IDBiglietto),
foreign key (IDBiglietto) references titoloviaggio(IDTitolo) on delete cascade on update cascade
);

create table abbonamento(
IDAbbonamento varchar(40) not null,
Tipo varchar(30) not null,
Scadenza date not null,
IDTessera varchar(10), 
primary key (IDAbbonamento),
foreign key (IDTessera) references tessera(IDTessera) on delete cascade on update cascade, 
foreign key (IDAbbonamento) references titoloviaggio(IDTitolo) on delete cascade on update cascade
);



create table storicopagamento(
IDStorico varchar(40) not null,
IDPagamento varchar(40) not null,
Stato varchar(10) not null,
primary key (IDStorico),
foreign key (IDPagamento) references pagamento(IDPagamento) on delete cascade on update cascade
);

create table viaggio(
IDViaggio varchar(40) not null,
IDTratta varchar(40) not null,
IDPartenza varchar(40) not null,
IDArrivo varchar(40) not null,
DataViaggio date not null,
OrarioPartenza TIME NOT NULL,
OrarioArrivo TIME NOT NULL,
IDBiglietto varchar(40) not null,
primary key (IDViaggio),
foreign key (IDTratta) references tratta(IDTratta) on delete cascade on update cascade,
foreign key (IDPartenza) references fermata(IDFermata) on delete cascade on update cascade,
foreign key (IDArrivo) references fermata(IDFermata) on delete cascade on update cascade,
foreign key (IDBiglietto) references biglietto(idbiglietto) on delete cascade on update cascade
);

/* Non usata
create table bigliettoviaggio(
IDViaggio varchar(10) not null,
IDBiglietto varchar(10) not null,
primary key (IDViaggio,IDBiglietto),
foreign key (IDViaggio) references viaggio(IDViaggio) on delete cascade on update cascade,
foreign key (IDBiglietto) references biglietto(IDBiglietto) on delete cascade on update cascade
);*/

create table rimborso(
IDRimborso varchar(40) not null,
DataRimborso date not null ,
Totale double not null, 
IDBiglietto varchar(40) not null,
IDRichiedente varchar(40) not null,
primary key (IDRimborso),
foreign key (IDBiglietto) references biglietto(IDBiglietto) on delete cascade on update cascade,
foreign key (IDRichiedente) references cliente(IDCliente) on delete cascade on update cascade
);


drop view if exists utenticlienti;
drop view if exists utentidipendenti;
drop view if exists titoliabbonamenti;
drop view if exists titoliBiglietti;

/*Viste*/
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

/*
create view tratteFermateCompleto as
select tr.IDTratta,Nome,Lunghezza,Fe.idFermata,Citta,NumOrdine,OraPartenza,OraArrivo,NumBinari from tratta tr ,trattafermata tf,fermata fe
where tf.IDFermata = fe.IDFermata and tf.IDTratta=tr.IDtratta;
*/