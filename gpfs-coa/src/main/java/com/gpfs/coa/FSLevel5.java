package com.gpfs.coa;

import java.util.List;

import javax.persistence.Entity;

@Entity(name = "fs_level_5")
public class FSLevel5 {

	private List<FSLevel6> children;
	
}
