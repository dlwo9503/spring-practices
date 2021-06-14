package com.douzone.container.videosystem;

public class BlankDisc implements DigitalVideoDisc {
	private String title;
	private String studio;
	
	@Override
	public void play() {
		System.out.println("playing Movie "+ studio + "'s " + title);
	}
}
