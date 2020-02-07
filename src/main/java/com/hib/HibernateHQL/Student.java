package com.hib.HibernateHQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int broj;
	private String ime;
	private int godine;
	
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getGodine() {
		return godine;
	}
	public void setGodine(int godine) {
		this.godine = godine;
	}
	@Override
	public String toString() {
		return "Student [broj=" + broj + ", ime=" + ime + ", godine=" + godine + "]";
	}
	
}
