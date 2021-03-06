package com.regional.property.model;

// Generated 9 Oct, 2016 8:53:52 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "role_name"))
public class Role implements java.io.Serializable {

	private int roleId;
	private int deleted=0;
	private Date created=new Date();
	private Date lastUpdate=new Date();
	private String roleName;
	private Set<UserRoles> userRoleses = new HashSet<UserRoles>(0);

	public Role() {
	}

	public Role(int roleId, int deleted, Date created, Date lastUpdate,
			String roleName) {
		this.roleId = roleId;
		this.deleted = deleted;
		this.created = created;
		this.lastUpdate = lastUpdate;
		this.roleName = roleName;
	}

	public Role(int roleId, int deleted, Date created, Date lastUpdate,
			String roleName, Set userRoleses) {
		this.roleId = roleId;
		this.deleted = deleted;
		this.created = created;
		this.lastUpdate = lastUpdate;
		this.roleName = roleName;
		this.userRoleses = userRoleses;
	}

	@Id
	@Column(name = "role_id", unique = true, nullable = false)
	@SequenceGenerator(
			name="role_sequence",
			sequenceName="role_seq",initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_sequence")
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "deleted", nullable = false)
	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 29)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 29)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "role_name", unique = true, nullable = false, length = 100)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "role")
	public Set<UserRoles> getUserRoleses() {
		return this.userRoleses;
	}

	public void setUserRoleses(Set<UserRoles> userRoleses) {
		this.userRoleses = userRoleses;
	}

}
