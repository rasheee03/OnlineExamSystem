package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.model.Album;
import com.lti.model.Passport;
import com.lti.model.Person;
import com.lti.model.Song;

public class AlbumSongTest {

	@Test
	public void addAlbum() {
		Album album=new Album();
		
		album.setName("Mix");
		
		album.setGenre("Mild");
		album.setReleaseDate(LocalDate.of(2013,12,11));
		 GenericDao dao=new GenericDao();
		 dao.save(album);	
	}

	@Test
	public void assignSongToAAlbum() {
		 GenericDao dao=new GenericDao();
		
		 
		 Song s1=new Song();
		 
		 s1.setTitle("Photograph");
	s1.setDuration(5.6);
	s1.setArtist("Ed Sheeran");
	
	 Song s2=new Song();
	
	 s2.setTitle("In my Blood");
s2.setDuration(5.8);
s2.setArtist("Shawn Mendes");
	

Album album=(Album) dao.fetchById(Album.class,226);
s1.setAlbum(album);
s2.setAlbum(album);

dao.save(s1);
dao.save(s2);
		 
		
	}
	@Test
	public void addAlbumAlongwithSongs(){
		GenericDao dao=new GenericDao();
		Album album=new Album();
		album.setGenre("BollyWood");
		album.setName("Chak De India");
		album.setReleaseDate(LocalDate.of(2007, 11, 23));
		Song song=new Song();
		
		song.setArtist("Sukhwinder Singh");
		song.setDuration(4.00);
		song.setTitle("Chak De India");
		song.setAlbum(album);
		Song song1=new Song();
		
		song1.setArtist("Vishal Verma");
		song1.setDuration(3.59);
		song1.setTitle("Tu Mera Aasman");
		song1.setAlbum(album);
		List<Song> s = new ArrayList<Song>();
		s.add(song);
		s.add(song1);
		album.setSong(s);
		dao.save(album);
		
	

}}
