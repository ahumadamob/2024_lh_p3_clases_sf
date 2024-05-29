package imb.lh.p3.clases.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private int pokedex_id;
	private String nombre;
	private String tipo;	
	private int nivel;
	private boolean legendario;
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPokedex_id() {
		return pokedex_id;
	}
	public void setPokedex_id(int pokedex_id) {
		this.pokedex_id = pokedex_id;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public boolean isLegendario() {
		return legendario;
	}
	public void setLegendario(boolean legendario) {
		this.legendario = legendario;
	}
	
	

}
