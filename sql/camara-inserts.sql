--inserts

--importar csv: COPY <tabela> FROM 'path\arquivo.csv' [DELIMITER] 'char_delimitador' [CSV HEADER];

COPY legislatura FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\legislaturas.csv'
DELIMITER ';' CSV HEADER;

COPY deputado (id_dep, nome_parlamentar, id_ultima_legislatura, nome_civil, sexo,
			   data_nasc, data_falec, UF_nasc, município_nasc)
FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\deputados.csv'
DELIMITER ';' CSV HEADER;

COPY dep_profissao (id_dep, data_hora_registro, cod_tipo, titulo)
FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\deputadosProfissoes.csv'
DELIMITER ';' CSV HEADER;

COPY dep_ocupacao (id_dep, titulo, entidade, UF_entidade, pais_entidade, ano_inicio, ano_fim)
FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\deputadosOcupacoes.csv'
DELIMITER ';' CSV HEADER; --requer chave artificial

COPY orgao FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\orgaos.csv'
DELIMITER ';' CSV HEADER;

COPY evento FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\eventos-2022.csv'
DELIMITER ';' CSV HEADER;

COPY requerimento FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\requerimentos_2022.csv'
DELIMITER ';' CSV HEADER;

COPY dep_trabalha_orgao 
FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\orgaosDeputados-L56.csv'
DELIMITER ';' CSV HEADER;

COPY orgao_realiza_evento 
FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\eventosOrgaos-2022.csv'
DELIMITER ';' CSV HEADER;

COPY evento_requer_aprovacao
FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\eventosRequerimentos-2022.csv'
DELIMITER ';' CSV HEADER;

COPY deputado_participa_evento (id_evento, id_dep)
FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\eventosPresencaDeputados-2022.csv'
DELIMITER ';' CSV HEADER;

COPY votacao FROM 'D:\COMPUEL\BD\dados-abertos\dados-camara\votacoes-2022.csv'
DELIMITER ';' CSV HEADER;

--muitas tabelas com dados desatualizados/inexistentes?