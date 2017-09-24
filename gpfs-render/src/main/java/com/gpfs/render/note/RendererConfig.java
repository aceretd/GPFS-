package com.gpfs.render.note;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RendererConfig {

	@Bean(name = "genericRenderer")
	public NoteRenderer genericRenderer() {
		return new NoteRenderer() {
			@Override
			public int getNoteIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}

}
