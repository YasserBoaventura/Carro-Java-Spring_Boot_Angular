package AppD.AppD.Entity;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import AppD.AppD.Repository.ProprietarioRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Carro {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private int ano;
	   private String nome;
	   
	   //Vamos usar o ManyTone quando o relacionamento muitos para um (Muitos carros podem ter uma marca)
        
	    @ManyToOne(cascade = CascadeType.PERSIST)      
	    @JoinColumn(name = "marcas_id")
	   private MarcaS marcas;
	    
	    //Vamos Usar o ManyToMany para o Relacionamentos muitos para muitos
	    
	    @ManyToMany(cascade = CascadeType.PERSIST)
	    @JoinTable(
	    	    name = "carro_propretario",
	    	    joinColumns = @JoinColumn(name = "carro_id"),        // coluna da entidade Carro
	    	    inverseJoinColumns = @JoinColumn(name = "propretario_id")  // coluna da entidade Propretario
	    	)
	    private List<Propretario> propreparios;
	   
          //Getters and Setters
	    public List<Propretario> getProprietarios() {
	        return propreparios;
	    }

	    public void setProprietarios(List<Propretario> proprietarios) {
	        this.propreparios= proprietarios;
	    }

	   
}
