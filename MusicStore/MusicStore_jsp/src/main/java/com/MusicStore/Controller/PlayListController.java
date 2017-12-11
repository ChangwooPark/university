package com.MusicStore.Controller;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.MusicStore.Model.Member;
import com.MusicStore.Model.Music;
import com.MusicStore.Model.PlayList;
import com.MusicStore.dao.MemberDAO;
import com.MusicStore.dao.MusicDAO;
import com.MusicStore.dao.PlayListDAO;

@Controller
public class PlayListController {
	@Autowired
	private PlayListDAO playlistdao;
	@Autowired
	private MemberDAO memberdao;
	@Autowired
	private MusicDAO musicdao;

	@RequestMapping(value = "playlist/PlayListMain", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView playlist(HttpSession session) {
		ModelAndView modelandview = new ModelAndView("playlist/PlayListMain");
		boolean Is_playlist;
		int member_idx = (int) session.getAttribute("member_idx");
		Member member = memberdao.getMember(member_idx);
		List<PlayList> playlistList = playlistdao.getPlayLists(member);
		if (playlistList.isEmpty()) {
			Is_playlist = true;
		} else {
			Is_playlist = false;
			modelandview.addObject("playlist", playlistList);
		}
		modelandview.addObject("Is_playlist", Is_playlist);
		return modelandview;
	}

	@RequestMapping(value = "playlist/PlayList", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public ModelAndView PlayList(@RequestParam("music") String music)
			throws Exception {

		ModelAndView modelAndView = new ModelAndView("playlist/PlayList");
		modelAndView.addObject("music", music);
		return modelAndView;
	}

	@RequestMapping(value = "playlist/VideoPlayer", method = {
			RequestMethod.GET, RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public ModelAndView VideoPlayer(@RequestParam("video") String video)
			throws Exception {

		ModelAndView modelAndView = new ModelAndView("playlist/VideoPlayer");
		List<Music> musiclist = musicdao.getVideoToMusic(video);
		modelAndView.addObject("video", video);
		modelAndView.addObject("musiclist", musiclist);
		//
		// String videoname = musiclist.get(0).getVideo().split(".")[0];
		// modelAndView.addObject("videoname", videoname);
		return modelAndView;
	}

	@RequestMapping(value = "playlist/Add", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView playlistAdd(PlayList playlist, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("playlist/PlayListMain");

		Member member = new Member();
		if (session != null) {
			int member_idx = (int) session.getAttribute("member_idx");
			member = memberdao.getMember(member_idx);
		}
		member.getPlaylists().add(playlist);
		playlist.setMember(member);
		playlistdao.addPlayList(playlist);

		boolean Is_playlist;

		List<PlayList> playlistList = playlistdao.getPlayLists(member);

		if (playlistList.isEmpty()) {
			Is_playlist = true;
		} else {
			Is_playlist = false;
			modelAndView.addObject("playlist", playlistList);
		}
		modelAndView.addObject("Is_playlist", Is_playlist);
		return modelAndView;
	}

	@RequestMapping(value = "playlist/Delete", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView playlistDelete(
			@RequestParam("playlist_idx") int playlist_idx, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("playlist/PlayListMain");
		boolean Is_playlist;
		int member_idx = (int) session.getAttribute("member_idx");
		Member member = memberdao.getMember(member_idx);
		List<PlayList> playlistList = playlistdao.getPlayLists(member);
		if (playlistList.isEmpty()) {
			Is_playlist = true;
		} else {
			Is_playlist = false;
			modelAndView.addObject("playlist", playlistList);
		}
		playlistdao.deletePlayList(playlist_idx);
		modelAndView.addObject("Is_playlist", Is_playlist);
		return modelAndView;
	}

	@RequestMapping(value = "playlist/musicAdd", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public ModelAndView musicAdd(HttpSession session,
			@RequestParam("playlist_idx") int playlist_idx,
			@RequestParam("music_idx") int music_idx) {
		ModelAndView modelAndView = new ModelAndView("playlist/playlist_exit");
		Music music = musicdao.getMusic(music_idx);
		// Set<Music> musics = new HashSet<Music>();
		// musics.add(music);
		PlayList playlist = playlistdao.getPlayList(playlist_idx);
		// playlist.setMusics(musics);
		// System.out.println("playlist idx" + playlist.getPlaylist_idx());
		// System.out.println("music idx" + music.getMusic_idx());
		//
		// //playlistdao.addPlayList(playlist);
		// Set<PlayList> playlists = new HashSet<PlayList>();
		// playlists.add(playlist);
		// music.setPlaylists(playlists);
		// music.getPlaylists().add(playlist);
		// musicdao.addMusic(music);
		playlistdao.addMapping(music, playlist);

		return modelAndView;
	}

	@RequestMapping(value = "playlist/playlistSelect", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView playlistSelect(HttpSession session,
			@RequestParam("music_idx") int music_idx) {
		ModelAndView modelAndView = new ModelAndView("playlist/playlistSelect");
		int member_idx = (int) session.getAttribute("member_idx");

		Member member = memberdao.getMember(member_idx);
		List<PlayList> playlist = playlistdao.getPlayLists(member);
		modelAndView.addObject("music_idx", music_idx);
		modelAndView.addObject("playlist", playlist);
		return modelAndView;
	}
}
