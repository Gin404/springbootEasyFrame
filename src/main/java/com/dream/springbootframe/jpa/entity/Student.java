package com.dream.springbootframe.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author Dream
 * 2018年1月31日
 *
 *
 */
@Data
@Entity
public class Student {

	@Id
	private String id;
	private String name;
	private String age;
	private String address;

}
