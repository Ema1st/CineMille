package dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDTO {

	private Long id;

	private String titolo;

	private LocalDate dataInizio;

	private LocalDate dataFine;

	private String sala;


}

