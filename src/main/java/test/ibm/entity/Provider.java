package test.ibm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sets the aggregation products dao.
 */
@Entity
@Table(name = "provider")
public class Provider {

	public Provider() {
	}

	public Provider(final Integer id, final String name, final Integer customerId, final LocalDateTime creationDate) {
		this.id = id;
		this.name = name;
		this.customerId = customerId;
		this.creationDate = creationDate;
	}

	@Id
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column
	private Integer customerId;
	@Column(nullable = false)
	private LocalDateTime creationDate;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(final Integer customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
