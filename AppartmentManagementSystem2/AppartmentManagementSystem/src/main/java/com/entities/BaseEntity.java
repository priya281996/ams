package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

import com.entities.DropdownList;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	public class BaseEntity implements DropdownList {

       @Id
       @GeneratedValue
       
		protected int id;
        @NotBlank
		protected String createdBy;
        @NotBlank
		protected String modifiedBy;
		protected String createdDateTime;
		protected String modifiedDateTime;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public String getCreatedDateTime() {
			return createdDateTime;
		}
		public void setCreatedDateTime(String createdDateTime) {
			this.createdDateTime = createdDateTime;
		}
		public String getModifiedDateTime() {
			return modifiedDateTime;
		}
		public void setModifiedDateTime(String modifiedDateTime) {
			this.modifiedDateTime = modifiedDateTime;
		}
		@Override
		public String toString() {
			return "BaseEntity [id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDateTime="
					+ createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
		}
		public String getKey() {
			
			String createdKey ="Key is created" ;
			return createdKey;
		}
		public String getValue() {
			
			String createdValue = "Value is created";
			return createdValue;
		}

		
	}

