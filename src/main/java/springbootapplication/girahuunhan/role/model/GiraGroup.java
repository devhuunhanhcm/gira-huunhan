package springbootapplication.girahuunhan.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
@Table(name="gira_group")
public class GiraGroup extends BaseEntity {
	private String code;
	private String description;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name	="gira_group_role",
			joinColumns = @JoinColumn(name="group_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private Set<GiraRole> roles = new LinkedHashSet<GiraRole>();
}