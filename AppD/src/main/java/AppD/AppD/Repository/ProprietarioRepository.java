package AppD.AppD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import AppD.AppD.Entity.Carro;
import AppD.AppD.Entity.Propretario;

public interface ProprietarioRepository extends JpaRepository<Propretario, Long>{

	void save(Carro proprietarios);

}
