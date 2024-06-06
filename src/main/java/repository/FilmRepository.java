package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

	@Query("SELECT f FROM Film f WHERE f.dataInizio BETWEEN :startDate AND :endDate")
	List<Film> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

	@Query("SELECT f FROM Film f WHERE f.dataFine < CURRENT_DATE")
	List<Film> findHistoricalFilms();

}
