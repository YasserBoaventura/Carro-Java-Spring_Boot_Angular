package AppD.AppD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppD.AppD.Entity.Carro;
import AppD.AppD.Entity.MarcaS;

public interface CarroRepository extends JpaRepository<Carro, Long> {
	
	public List<Carro> findByNome(String nome);
		
	// Metodo que faz a consulta com o id da Marca passado por paramentro
	public List<Carro> findByMarcas(MarcaS marcas);
	
	//Metodo que faz a Consultas por ano Maiores que o qno digidado o @RequestParam
	@Query("FROM Carro c WHERE c.ano > :ano")
	public List<Carro> findAnoAcima(@Param("ano") int ano);

	public List<Carro> findByMarcasNome(String nome);
}
