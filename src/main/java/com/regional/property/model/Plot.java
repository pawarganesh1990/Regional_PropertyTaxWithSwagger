package com.regional.property.model;

// Generated 16 Oct, 2016 5:51:52 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Plot generated by hbm2java
 */
@Entity
@Table(name = "plot", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "plot_name"))
public class Plot implements java.io.Serializable {

	private int plotId;
	private Sector sector;
	private String plotName;
	private int deleted;
	private Date created=new Date();
	private Date lastUpdate=new Date();
	private Set<Flat> flats = new HashSet(0);

	public Plot() {
	}

	public Plot(int plotId, Sector sector, String plotName, int deleted,
			Date created, Date lastUpdate) {
		this.plotId = plotId;
		this.sector = sector;
		this.plotName = plotName;
		this.deleted = deleted;
		this.created = created;
		this.lastUpdate = lastUpdate;
	}

	public Plot(int plotId, Sector sector, String plotName, int deleted,
			Date created, Date lastUpdate, Set flats) {
		this.plotId = plotId;
		this.sector = sector;
		this.plotName = plotName;
		this.deleted = deleted;
		this.created = created;
		this.lastUpdate = lastUpdate;
		this.flats = flats;
	}

	@Id
	@Column(name = "plot_id", unique = true, nullable = false)
	public int getPlotId() {
		return this.plotId;
	}

	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}

	@ManyToOne
	@JoinColumn(name = "sector_id", nullable = false)
	@JsonIgnore
	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Column(name = "plot_name", unique = true, nullable = false, length = 100)
	public String getPlotName() {
		return this.plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
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
	 @LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "plot")
	@JsonIgnore
	public Set<Flat> getFlats() {
		return this.flats;
	}

	public void setFlats(Set<Flat> flats) {
		this.flats = flats;
	}

}
