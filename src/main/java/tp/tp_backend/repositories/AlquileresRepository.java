package tp.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.tp_backend.entities.Alquileres;

@Repository
public interface AlquileresRepository extends JpaRepository<Alquileres, String> {
}
