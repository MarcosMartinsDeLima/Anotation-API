CREATE TABLE user (
    id_user INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    apelido VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_user)
);

CREATE TABLE anotation(
    id_anotation INT NOT NULL AUTO_INCREMENT,
    id_user INT NOT NULL,
    anotacao VARCHAR(255) NOT NULL,
    terminado TINYINT  DEFAULT(0),
    PRIMARY KEY (id_anotation),
    FOREIGN KEY (id_user) REFERENCES user(id_user)
);