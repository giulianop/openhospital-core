package org.isf.menu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.isf.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/*------------------------------------------
 * User - model for the user entity
 * -----------------------------------------
 * modification history
 * ? - ? - first version 
 * 07/05/2016 - Antonio - ported to JPA
 * 
 *------------------------------------------*/
@Entity
@Table(name="GROUPMENU")
@EntityListeners(AuditingEntityListener.class) 
public class GroupMenu extends Auditable<String>
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GM_ID")		
	private Integer code;
	
	@Column(name="GM_UG_ID_A")
	private String userGroup;
	
	@Column(name="GM_MNI_ID_A")
	private String menuItem;

	@Column(name="GM_ACTIVE")
	private char actived;	
	
	@Transient
	private volatile int hashCode = 0;
			
	
	public GroupMenu(){
	}
	
	public GroupMenu(Integer code, String userGroup, String menuItem, char actived)
	{
		this.code = code;
		this.userGroup = userGroup;
		this.menuItem = menuItem;
		this.actived = actived;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}
	public char getActived() {
		return actived;
	}
	public void setActived(char actived) {
		this.actived = actived;
	}
	
	public String toString(){
		return code.toString();		
	}
	
	@Override
	public boolean equals(Object anObject) {
        return (anObject == null) || !(anObject instanceof GroupMenu) ? false
                : (getCode().equals(((GroupMenu) anObject).getCode())
                  && getUserGroup().equalsIgnoreCase(((GroupMenu) anObject).getUserGroup()) 
                  && getMenuItem().equals(((GroupMenu) anObject).getMenuItem())
                  && getActived() == ((GroupMenu) anObject).getActived());
    }

	@Override
	public int hashCode() {
	    if (this.hashCode == 0) {
	        final int m = 23;
	        int c = 133;
	        
	        c = m * c + code.hashCode();
	        
	        this.hashCode = c;
	    }
	  
	    return this.hashCode;
	}	
	
}//class GroupMenu
