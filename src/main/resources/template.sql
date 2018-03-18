CREATE TABLE CONTA (SALDOATUAL REAL, LIMITE REAL, NUMEROCONTA INTEGER, CONSTRAINT PK_CONTA PRIMARY KEY (NUMEROCONTA));

CREATE TABLE TRANSACAO (ID_TRANSACAO INTEGER, VALOR REAL, TIPOTRANSACAO VARCHAR(10), DATE VARCHAR(20), NCONTA INTEGER, CONSTRAINT PK_TRANSACAO PRIMARY KEY (ID_TRANSACAO), CONSTRAINT FK_TRANS_CONTA FOREIGN KEY (NCONTA) REFERENCES CONTA(NUMEROCONTA));