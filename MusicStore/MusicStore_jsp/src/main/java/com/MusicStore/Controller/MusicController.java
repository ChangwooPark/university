package com.MusicStore.Controller;

import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.MusicStore.Model.Music;
import com.MusicStore.Model.PlayList;
import com.MusicStore.dao.MusicDAO;
import com.MusicStore.dao.PlayListDAO;

@Controller
public class MusicController {

	@Autowired
	private MusicDAO musicdao;
	@Autowired
	private PlayListDAO playlistdao;

	// private File destinationDir;
	//
	// public void setDestinationDir(File destinationDir) {
	// this.destinationDir = destinationDir;
	// }

	@RequestMapping(value = "music/NewAlbum", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView NewAlbum() {
		ModelAndView modelandview = new ModelAndView("music/NewAlbum");
		boolean is_List = false;
		List<String> musicList = musicdao.getAlbums();
		List<Music> albumList = musicdao.getMusics();
		if (musicList.isEmpty() == true) {
			is_List = true;
		} else {
			is_List = false;
		}

		modelandview.addObject("is_List", is_List);
		modelandview.addObject("albumList", albumList);
		return modelandview;
	}

	@RequestMapping(value = "music/Write", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView musicWrite() {
		ModelAndView modelandview = new ModelAndView("music/Write");
		return modelandview;
	}

	@RequestMapping(value = "music/Write_Process", method = RequestMethod.POST)
	public ModelAndView musicWrite_Process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile picture = multipartRequest.getFile("picture");
		String pictureName = picture.getOriginalFilename();
		MultipartFile music_ = multipartRequest.getFile("music");
		String musicName = music_.getOriginalFilename();
		MultipartFile video = multipartRequest.getFile("video");
		String videoName = video.getOriginalFilename();

		String picturePath = "C:/Users/Administrator/Documents/MusicStore/MusicStore/src/main/webapp/resources/Upload_picture";
		String musicPath = "C:/Users/Administrator/Documents/MusicStore/MusicStore/src/main/webapp/resources/Upload_music";
		String videoPath = "C:/Users/Administrator/Documents/MusicStore/MusicStore/src/main/webapp/resources/Upload_video";

		FileOutputStream fos_p = null;
		FileOutputStream fos_m = null;
		FileOutputStream fos_v = null;

		try {
			byte fileData_p[] = picture.getBytes();
			fos_p = new FileOutputStream(picturePath + "\\" + pictureName);
			fos_p.write(fileData_p);

			byte fileData_m[] = music_.getBytes();
			fos_m = new FileOutputStream(musicPath + "\\" + musicName);
			fos_m.write(fileData_m);

			byte fileData_v[] = video.getBytes();
			fos_v = new FileOutputStream(videoPath + "\\" + videoName);
			fos_v.write(fileData_v);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos_p != null && fos_m != null && fos_v != null) {
				try {
					fos_p.close();
					fos_m.close();
					fos_v.close();
				} catch (Exception e) {
				}
			}
		}

		Music music = new Music();
		music.setName(multipartRequest.getParameter("name"));
		music.setRegis_date(multipartRequest.getParameter("regis_date"));
		music.setGenre(multipartRequest.getParameter("genre"));
		music.setAlbum(multipartRequest.getParameter("album"));
		music.setHits(0);
		music.setPicture(pictureName);
		music.setMusic(musicName);
		music.setVideo(videoName);
		music.setArtist(multipartRequest.getParameter("artist"));

		PlayList playlist = playlistdao.getPlayList(1);
		Set<PlayList> playlists = new HashSet<PlayList>();
		playlists.add(playlist);
		music.setPlaylists(playlists);
		musicdao.addMusic(music);

		ModelAndView modelandview = new ModelAndView("home");
		return modelandview;

	}

	@RequestMapping(value = "music/musicview", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView musicView(Music music) {

		// String idx_string = request.getAttribute("music_idx").toString();
		// int idx = Integer.parseInt(idx_string);
		// System.out.println("musicView Idx : "+idx);
		//
		// Music music = musicdao.getMusic(idx);

		int music_idx = music.getMusic_idx();

		music = musicdao.getMusic(music_idx);

		ModelAndView modelandview = new ModelAndView("music/MusicView");

		modelandview.addObject("music", music);
		return modelandview;

	}
}
