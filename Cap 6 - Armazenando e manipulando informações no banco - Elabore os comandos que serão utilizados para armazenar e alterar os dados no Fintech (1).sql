CREATE TABLE `T_FIN_USER` (
  `nr_cpf` varchar(11) NOT NULL,
  `nm_email` varchar(100) NOT NULL,
  `nm_nome` varchar(100) NOT NULL,
  PRIMARY KEY (`nr_cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `T_FIN_AUTH` (
  `vl_passhash` varchar(32) NOT NULL,
  `nr_cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`nr_cpf`),
  CONSTRAINT `T_FIN_AUTH_FK` FOREIGN KEY (`nr_cpf`) REFERENCES `T_FIN_USER` (`nr_cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `T_FIN_CONTA` (
  `nr_cpf` varchar(11) NOT NULL,
  `nr_agencia` int(11) NOT NULL,
  `nr_conta` int(11) NOT NULL,
  `id_conta` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_conta`),
  KEY `T_FIN_CONTA_FK` (`nr_cpf`),
  CONSTRAINT `T_FIN_CONTA_FK` FOREIGN KEY (`nr_cpf`) REFERENCES `T_FIN_USER` (`nr_cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `T_FIN_INVESTIMENTOS` (
  `id_conta` int(11) NOT NULL,
  `id_investimento` int(11) NOT NULL AUTO_INCREMENT,
  `vl_investimento` double NOT NULL,
  `vl_variacao` double NOT NULL,
  PRIMARY KEY (`id_investimento`),
  KEY `T_FIN_INVESTIMENTOS_FK` (`id_conta`),
  CONSTRAINT `T_FIN_INVESTIMENTOS_FK` FOREIGN KEY (`id_conta`) REFERENCES `T_FIN_CONTA` (`id_conta`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `T_FIN_LANCAMENTOS` (
  `id_conta` int(11) NOT NULL,
  `id_lancamento` int(11) NOT NULL AUTO_INCREMENT,
  `vl_lancamento` double NOT NULL,
  `dt_data` datetime NOT NULL,
  PRIMARY KEY (`id_lancamento`),
  KEY `T_FIN_LANCAMENTOS_FK` (`id_conta`),
  CONSTRAINT `T_FIN_LANCAMENTOS_FK` FOREIGN KEY (`id_conta`) REFERENCES `T_FIN_CONTA` (`id_conta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;


INSERT INTO T_FIN_USER (nr_cpf,nm_email,nm_nome) VALUES
	 ('26820719531','luizaisabelamoraes@cantinadafazenda.com.br','Luiza Isabela Moraes'),
	 ('66963136564','henriqueigorcampos@bucaneiro.com.br','Henrique Igor Campos');
INSERT INTO T_FIN_AUTH (vl_passhash,nr_cpf) VALUES
	 ('e47b7382e302b0896f158ba952366600','26820719531'),
	 ('5450abbba2be12b1dcc93936cee3bd9b','66963136564');
INSERT INTO T_FIN_CONTA (nr_cpf,nr_agencia,nr_conta) VALUES
	 ('66963136564',4,125),
	 ('26820719531',4,133),
	 ('26820719531',6,1155);
INSERT INTO T_FIN_LANCAMENTOS (id_conta,vl_lancamento,dt_data) VALUES
	 (1,500.0,'2022-10-15 10:00:00'),
	 (2,2650.0,'2022-10-15 12:00:00'),
	 (3,100.0,'2022-10-15 14:00:00'),
	 (2,-2100.25,'2022-10-15 16:00:00'),
	 (1,-250.0,'2022-10-15 18:00:00');
INSERT INTO T_FIN_INVESTIMENTOS (id_conta,vl_investimento,vl_variacao) VALUES
	 (1,150.0,15.58),
	 (1,200.5,-5.12),
	 (2,86.0,0.0),
	 (3,90.0,-35.24);


SELECT nm_nome,B.id_conta,vl_investimento
FROM T_FIN_USER A,T_FIN_INVESTIMENTOS B,T_FIN_CONTA C
WHERE B.id_conta = C.id_conta
AND A.nr_cpf = C.nr_cpf
AND A.nr_cpf = 26820719531
AND B.id_investimento = 4;

SELECT nm_nome,C.id_conta,vl_lancamento
FROM T_FIN_USER A,T_FIN_LANCAMENTOS B,T_FIN_CONTA C
WHERE B.id_conta = C.id_conta
AND A.nr_cpf = C.nr_cpf
AND A.nr_cpf = 26820719531
AND C.nr_conta = 1155;

SELECT nm_nome,nm_email FROM T_FIN_USER WHERE nr_cpf = 26820719531;

UPDATE T_FIN_USER
SET nm_email = 'luizaisabelamoraes@gmail.com',
    nm_nome = 'Luisa Isabela Moraez'
WHERE nr_cpf = 26820719531;