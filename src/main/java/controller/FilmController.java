package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Film;
import service.FilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping
	public List<Film> getAllFilms() {
		return filmService.getAllFilms();
	}

	@GetMapping("/filter")
	public List<Film> getFilmsByDate(@RequestParam Date startDate, @RequestParam Date endDate) {
		return filmService.getFilmsByDate(startDate, endDate);
	}

	@GetMapping("/historical")
	public List<Film> getHistoricalFilms() {
		return filmService.getHistoricalFilms();
	}
}
