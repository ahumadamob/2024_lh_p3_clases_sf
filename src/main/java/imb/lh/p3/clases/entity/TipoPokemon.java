package imb.lh.p3.clases.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoPokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	private String nombre;
	
	@Column(name="gana_con")
	private String ganaCon;
	
	@Column(name="pierde_con")
	private String pierdeCon;
	
	//@OneToMany(mappedBy="tipoPokemon")
	//private List<Pokemon> pokemones;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGanaCon() {
		return ganaCon;
	}
	public void setGanaCon(String ganaCon) {
		this.ganaCon = ganaCon;
	}
	public String getPierdeCon() {
		return pierdeCon;
	}
	public void setPierdeCon(String pierdeCon) {
		this.pierdeCon = pierdeCon;
	}

	

	
	
}
