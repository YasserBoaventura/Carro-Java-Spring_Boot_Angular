package AppD.AppD.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AppD.AppD.Entity.Carro;
import AppD.AppD.Entity.MarcaS;
import AppD.AppD.Entity.Propretario;
import AppD.AppD.Repository.CarroRepository;
import AppD.AppD.Repository.ProprietarioRepository;





@Service
public class CarroService {
	

	@Autowired
	private CarroRepository carroRepository;
	
   @Autowired
	private ProprietarioRepository proprietarioRepository;

    public String salvarCarro(Carro carro) {
    
    	
        // Salvar proprietários novos antes de salvar o carro
        if (carro.getProprietarios() != null) {
        	
            List<Propretario> proprietariosSalvos = new ArrayList<>();
            
            for (Propretario p : carro.getProprietarios()) {
            	
                if (p != null && p.getId() == null) {
                	
                    p = proprietarioRepository.save(p); // garante que o id é gerado
                }
                proprietariosSalvos.add(p);
            }
            carro.setProprietarios(proprietariosSalvos);
        }
        
        carroRepository.save(carro);
       
        return "Carro salvo com sucesso!";
    }
    
	//Actualiza os dados do carro
	public String update(Carro carro,long id) {
	      
	       carro.setId(id);
	       this.carroRepository.save(carro);
		   return "Actualizado com sucesso";
		
	}
	//Deleta por Id
	public String delete(long id) {
		this.carroRepository.deleteById(id);
		return "Deletado com sucesso";	
	}
	
	//Lista todos os carros
	public List<Carro> findAll(){
		 List<Carro> carro;
		 carro=this.carroRepository.findAll();
		 return carro;
	
		}
	
	//Faz a busca via Id
	public Carro findById(long id) {
	 Carro carro=this.carroRepository.findById(id).get();
	 return carro;
	
	
	}
	//Metodo que faz a busca por nome 
	public List<Carro> findyByNome(String nome){
		return this.carroRepository.findByNome(nome);
	}
	
	//Metodo que faz a busca por Id da marca
	public List<Carro> findyByMarcas(long Idmarcas){
		MarcaS marcas=new MarcaS();
		marcas.setId(Idmarcas);
		return this.carroRepository.findByMarcas(marcas);
	}
	
	//Metodo que faz a busca por ano
	public List<Carro> findAnoAcima(int ano){
		
		return this.carroRepository.findAnoAcima(ano);
		
	}
	public List<Carro> findByMarcasNome(String omeMarca){
		return this.findByMarcasNome(omeMarca);
	}
  
}

	


