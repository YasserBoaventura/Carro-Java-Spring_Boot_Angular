package AppD.AppD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import AppD.AppD.Entity.Carro;
import AppD.AppD.Entity.MarcaS;
import AppD.AppD.Service.CarroService;
import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("Ap/Carros")
public class CarroController {
	

	@Autowired
	private CarroService carroService;  

	
	@PostMapping("/carros")
	public ResponseEntity<String> salvarCarro(@RequestBody Carro carro) {
		try {
			String mensagem=this.carroService.salvarCarro(carro);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	   
	} 
	//Metodo que faz a actualizacao dos dados
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update(@RequestBody  Carro carro, @PathVariable long id) {
		
       try {
    	   String mensagem=this.carroService.update(carro, id);
    	   return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
			
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
     //Metodo que faz Remove um objecto por id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
	    try {
	        String mensagem = carroService.delete(id);
	        return new ResponseEntity<>(mensagem, HttpStatus.OK);
	    } catch (EntityNotFoundException e) {
	        return new ResponseEntity<>("Carro não encontrado", HttpStatus.NOT_FOUND);
	    } catch (Exception e) {
	    	   e.printStackTrace(); 
	        return new ResponseEntity<>("Erro ao deletar", HttpStatus.INTERNAL_SERVER_ERROR);
	        
	    }
	}

	//Metodo que faz a busca Total os objectos
   @GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll() {
	    try {
	        List<Carro> lista = this.carroService.findAll();

	        if (lista.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	        } else {
	            return new ResponseEntity<>(lista, HttpStatus.OK); // 200
	        }

	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
	    }
	}

   //Metodo que faz a busca por Id
   @GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable long id) {
		
    try {
    	Carro carro=this.carroService.findById(id);
    	return new ResponseEntity<>(carro, HttpStatus.CREATED);
			
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		
	}
   //Faz a busca do carro atravez do nome do carro     
   @GetMapping("/findByNome")
	public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome) {
	    try {
	        List<Carro> lista = this.carroService.findyByNome(nome);

	        if (lista.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	        } else {
	            return new ResponseEntity<>(lista, HttpStatus.OK); // 200
	        }

	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
	    }
	}
   
   //Metodo que faz a busca por id da marca e retorna o Objecto Marca
   @GetMapping("/findByMarca")
  	public ResponseEntity<List<Carro>> findByMarcaS(@RequestParam long IdMarca) {
  	    try {
  	        List<Carro> lista = this.carroService.findyByMarcas(IdMarca);

  	        if (lista.isEmpty()) {
  	            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
  	        } else {
  	            return new ResponseEntity<>(lista, HttpStatus.OK); // 200
  	        }

  	    } catch (Exception e) {
  	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
  	    }
  	}
   //Metodo que faz a busca por ano Acima do ano digitado pelo prarmetro
   @GetMapping("/findAnoAcima")
  	public ResponseEntity<List<Carro>> findByAno(@RequestParam int ano) {
  	    try {
  	        List<Carro> lista = this.carroService.findAnoAcima(ano);

  	        if (lista.isEmpty()) {
  	            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
  	        } else {
  	            return new ResponseEntity<>(lista, HttpStatus.OK); // 200
  	        }
    
  	        
  	    } catch (Exception e) {
  	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
  	    }
  	}
   
   //Metodo que retorna a lista dos carros de uma certa marca
   @GetMapping("/findByMarcaNome")
   public ResponseEntity<List<Carro>> findByMarcasNome( @RequestParam String nomeMarca){
	   try {
		   List<Carro> lista = this.carroService.findByMarcasNome(nomeMarca); 
		   if(lista.isEmpty()) {
			   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		   } else {
			   return new ResponseEntity<>(lista,  HttpStatus.OK);
		   }
	   }catch(Exception e) {
		     e.printStackTrace(); // para debug
		   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		   
	   }
	   
	   
   }
}
