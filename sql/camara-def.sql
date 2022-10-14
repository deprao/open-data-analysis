CREATE TABLE legislatura(
    id INT,
    data_inicio DATE,
    data_fim DATE,
    ano_eleicao INT,
    CONSTRAINT pk_leg PRIMARY KEY(id)
);

CREATE TABLE deputado(
    id_dep INT,
    nome_parlamentar VARCHAR(60),
    nome_civil VARCHAR(100),
    data_nasc DATE,
    data_falec DATE,
    sexo CHAR,
    UF_nasc VARCHAR(2),
    município_nasc VARCHAR(50),
    id_ultima_legislatura INT,
    CONSTRAINT fk_dep_legis FOREIGN KEY(id_ultima_legislatura)
		REFERENCES legislatura(id),
    CONSTRAINT pk_dep PRIMARY KEY(id_dep),
    CONSTRAINT ck_sexo CHECK (sexo IN ('M', 'F', 'O'))
);

CREATE TABLE dep_ocupacao(
    titulo VARCHAR(100),
    entidade VARCHAR(150),
    ano_inicio INT,
    ano_fim INT,
    UF_entidade VARCHAR(2),
    pais_entidade VARCHAR(20),
    id_dep INT,
    CONSTRAINT fk_dep_depocu FOREIGN KEY(id_dep)
		REFERENCES deputado(id_dep) ON DELETE CASCADE,
    CONSTRAINT pk_ocup PRIMARY KEY(id_dep, titulo, entidade)
);

CREATE TABLE dep_profissao(
    id_dep INT,
    cod_tipo INT,
    titulo VARCHAR(50),
    data_hora_registro TIMESTAMP,
    CONSTRAINT fk_dep_depprof FOREIGN KEY(id_dep)
		REFERENCES deputado(id_dep) ON DELETE CASCADE,
    CONSTRAINT pk_prof PRIMARY KEY(id_dep, cod_tipo)
);

CREATE TABLE orgao(
    id INT,
    sigla VARCHAR(20),
    nome VARCHAR(100),
    tipo VARCHAR(50),
    data_inicio TIMESTAMP,
    data_instalacao TIMESTAMP,
    data_fim TIMESTAMP,
    descricao_situacao VARCHAR(50),
    casa VARCHAR(100),
    sala VARCHAR(100),
    CONSTRAINT pk_org PRIMARY KEY(id)
);

CREATE TABLE dep_trabalha_orgao(
    id_org INT,
    id_dep INT,
    sigla_partido VARCHAR(20),
    sigla_UF VARCHAR(2),
    cargo VARCHAR(100),
    data_inicio DATE,
    data_fim DATE,
    CONSTRAINT fk_dep_deptraborg FOREIGN KEY(id_dep)
		REFERENCES deputado(id_dep),
    CONSTRAINT fk_org_deptraborg FOREIGN KEY(id_org)
		REFERENCES orgao(id),
    CONSTRAINT pk_dep_trab_org PRIMARY KEY(id_org, id_dep, cargo, data_inicio)
);

CREATE TABLE evento(
    id INT,
    data_hora_inicio TIMESTAMP,
    data_hora_fim TIMESTAMP,
    situacao VARCHAR(50),
    descricao VARCHAR(10000),
    descricao_tipo VARCHAR(100),
    localizacao VARCHAR(100),
    CONSTRAINT pk_evento PRIMARY KEY(id)
);

CREATE TABLE requerimento(
    id INT,
    titulo VARCHAR(50),
    CONSTRAINT pk_req PRIMARY KEY(id)
);

CREATE TABLE orgao_realiza_evento(
    id_evento INT,
    id_org INT,
    CONSTRAINT fk_eve_orgreaeve FOREIGN KEY(id_evento)
		REFERENCES evento(id),
    CONSTRAINT fk_org_orgreaeve FOREIGN KEY(id_org)
		REFERENCES orgao(id),
    CONSTRAINT pk_org_rea_eve PRIMARY KEY(id_evento, id_org)
);
