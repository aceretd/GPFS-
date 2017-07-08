package com.gpfs.coa;

import java.util.List;

import javax.persistence.Entity;

@Entity(name = "fs_level_4")
public class FSLevel4 {

	private List<FSLevel5> children;
	
}
