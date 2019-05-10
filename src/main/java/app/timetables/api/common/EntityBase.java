package app.timetables.api.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

/**
 * Super class for all entities with Long Id.
 * @author kmrozowski
 *
 */
@MappedSuperclass
public class EntityBase {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	/**
	 * Checks if entity is persisted.
	 * @return
	 */
	public boolean isNew() {
		return id == null;
	}
}
