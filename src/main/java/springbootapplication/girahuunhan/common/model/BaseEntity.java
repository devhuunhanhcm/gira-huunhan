package springbootapplication.girahuunhan.common.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder

public class BaseEntity implements Serializable {
	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	protected UUID id;
	
	@Version
	protected int version;
	
	@CreatedDate
	protected LocalDateTime createdAt;
	
	@CreatedBy
	protected String createdBy;
	
	@LastModifiedDate
	protected LocalDateTime lastModifiedAt;
	
	@LastModifiedBy
	protected String lastModifiedBy;
}
