# M06-UF4-A02

### Per què al servei estem utilitzant mètodes que no hem declarat explícitament al repositori? Com és possible?
Perque que ens proporciona els metodes la clase CrudRepository la qual estem extenen en el repository.

### El repositori pot elegir fer l’extends de les interfícies PagingAndSortingRepository o de JpaRepository. En què es diferencien aquestes dues amb la interfície CrudRepository?
Perque la calse CrudRepository te nomes les operacions de CRUD basiques en canvi les altres tenen funcionalitats extres com paginació o altres.

### Què significa Optional<Classe> i per a què serveix?
Te la opcion de tornar un valor o no i serveix per evitar NullPointerExceptions.

### Per què el controlador utilitza el servei i no la seva implementació?
Per separar la lògica de negoci de la gestió de les sol·licituds HTTP, mantenint el controlador més net i fàcil de gestionar.