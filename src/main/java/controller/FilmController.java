package controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.FilmDTO;
import service.FilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping
	public List<FilmDTO> getAllFilms() {
		return filmService.getAllFilms();
	}

	@GetMapping("/filter")
	public List<FilmDTO> getFilmsByDate(@RequestParam LocalDate start, @RequestParam LocalDate end) {
		return filmService.getFilmsByDateRange(start, end);
	}

	@GetMapping("/historical")
	public List<FilmDTO> getHistoricalFilms() {
		return filmService.getHistoricalFilms();
	}
}

