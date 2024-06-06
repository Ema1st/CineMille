package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.FilmDTO;
import entity.Film;
import repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	public List<FilmDTO> getAllFilms() {
		return filmRepository.findAll().stream().map(this::convertToDTO).toList();
	}

	public List<FilmDTO> getFilmsByDateRange(LocalDate start, LocalDate end) {
		return filmRepository.findByDateRange(start, end).stream().map(this::convertToDTO).toList();
	}

	public List<FilmDTO> getHistoricalFilms() {
		return filmRepository.findHistoricalFilms().stream().map(this::convertToDTO).toList();
	}

	private FilmDTO convertToDTO(Film film) {
		FilmDTO filmDTO = new FilmDTO();
		filmDTO.setId(film.getId());
		filmDTO.setTitolo(film.getTitolo());
		filmDTO.setDataInizio(film.getDataInizio());
		filmDTO.setDataFine(film.getDataFine());
		filmDTO.setSala(film.getSala());
		return filmDTO;
	}
}


