package com.ctl.smartsignage.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
/**
 * @author Arun Kumar Tiwari
 * Base domain class for all domain classes
 */
@MappedSuperclass
public class BaseDomain implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	/**
	 * Please uncomment line below. When deploying on cloud server.
	 */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;

    public BaseDomain() {
    }

    public BaseDomain(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @SuppressWarnings({"JpaModelErrorInspection"})
    public boolean isNew() {
        return (id == null);
    }
}
