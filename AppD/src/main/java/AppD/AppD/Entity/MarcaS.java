package AppD.AppD.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class MarcaS {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nome;
		private String cnpj;
		
	    @OneToMany(mappedBy = "marcas", cascade = CascadeType.PERSIST)
		private List<Carro> carros;
	    
}