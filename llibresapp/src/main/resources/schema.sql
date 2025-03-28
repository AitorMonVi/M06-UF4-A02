CREATE TABLE IF NOT EXISTS llibre (
    id_Llibre INT NOT NULL AUTO_INCREMENT,
    titol VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editorial VARCHAR(255),
    datapublicacio DATE,
    tematica VARCHAR(100),
    ISBN VARCHAR(13) UNIQUE NOT NULL,
    PRIMARY KEY (id_Llibre)
);
