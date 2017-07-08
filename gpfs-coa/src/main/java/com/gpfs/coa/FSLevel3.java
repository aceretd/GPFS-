package com.gpfs.coa;

import java.util.List;

import javax.persistence.Entity;

@Entity(name = "fs_level_3")
public class FSLevel3 {

	private List<FSLevel4> children;

}
