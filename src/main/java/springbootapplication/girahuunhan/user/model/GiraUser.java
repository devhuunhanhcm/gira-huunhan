package springbootapplication.girahuunhan.user.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springbootapplication.girahuunhan.common.model.BaseEntity;
import springbootapplication.girahuunhan.role.model.GiraGroup;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="gira_user")
public class GiraUser extends BaseEntity {
	@ManyToMany(mappedBy = "users")
	private Set<GiraGroup> groups = new LinkedHashSet<GiraGroup>();
	
	@Column(name="username",nullable=false,unique=true,length=100)
	private String username;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="display_name",nullable = false)
	private String displayname;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="avatar")
	private String avatar;
	
	@Column(name="email",nullable= false,unique=true,length = 100)
	private String email;
	
	@Column(name="status",nullable=false)
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	@Column(name="department")
	private String deparment;
	
	@Column(name="major")
	private String major;
	
	@Column(name="facebook")
	private String facebook;
	
	@Column(name="hobbies")
	private String hobbies;
}
