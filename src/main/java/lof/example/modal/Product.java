package lof.example.modal;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table( name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7706606838760254672L;
	
	@Id
	@Column
	private Long code;
	@Column
	private String name;
	@Column
	private Boolean active;
	@ManyToOne
	@JoinColumn(referencedColumnName = "code", columnDefinition = "category")
	private Category category;
	
	
	
	public Product(Long code, String name, Boolean active, Category category) {
		super();
		this.code = code;
		this.name = name;
		this.active = active;
		this.category = category;
	}
	
	
	public Product() {
		super();
	}


	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(active, code);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		return Objects.equals(active, other.active) && Objects.equals(code, other.code);
	}
	
		
	
}
