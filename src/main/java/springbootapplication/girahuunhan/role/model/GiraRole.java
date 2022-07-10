package springbootapplication.girahuunhan.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springbootapplication.girahuunhan.common.model.BaseEntity;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="gira_role")
public class GiraRole extends BaseEntity {
	@Size(min= 5,max = 30)
	private String code;
	
	@NotBlank
	private String description;
	
	@ManyToMany(mappedBy = "roles")
	private Set<GiraGroup> groups = new LinkedHashSet<GiraGroup>();
}
