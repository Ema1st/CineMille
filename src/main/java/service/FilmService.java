package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Film;
import repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	public List<Film> getFilmsByDate(Date startDate, Date endDate) {
		return filmRepository.findByDateRange(startDate, endDate);
	}

	public List<Film> getHistoricalFilms() {
		return filmRepository.findHistoricalFilms();
	}
}

