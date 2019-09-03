package org.olga.service.film;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.olga.entity.fact.Fact;
import org.olga.entity.film.Film;
import org.olga.entity.film.FilmImpl;
import org.olga.repository.film.FilmDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FilmServiceImplTest {
    public static final long DEFAULT_ID = 321L;
    public static final String DEFAULT_NAME = "film_name";
    public static final long DEFAULT_STATISTIC_ID = 123L;
    public static final List<Fact> DEFAULT_FACT_LIST = new ArrayList<>();

    @Mock
    private FilmServiceImpl filmService;

    @Mock
    private FilmDAO filmDAO;

//    @Before
//    public void init() {
//        filmService = mock(FilmServiceImpl.class);
//    }

    @Test
    public void shouldReturnTheSameFilm() {
        Film film = getFilm();
        when(filmService.getFilmById(DEFAULT_ID)).thenReturn(film);
        when(filmService.update(any(Film.class))).thenCallRealMethod();

        Film result = filmService.update(film);

        assertEquals(film, result);
        verify(filmService).getFilmById(DEFAULT_ID);
    }

    @Test
    public void shouldReturnChangedFilmFromDB() {
        Film film = getFilm();
        Film filmFromDB = getFilm();
        filmFromDB.setName("old name");
        when(filmService.getFilmById(DEFAULT_ID)).thenReturn(filmFromDB);
        when(filmService.update(any(Film.class))).thenCallRealMethod();
        when(filmService.getFilmDao()).thenReturn(filmDAO);
        when(filmDAO.update(filmFromDB)).thenReturn(filmFromDB);

        Film result = filmService.update(film);

        assertEquals(film, film);
        verify(filmDAO).update(filmFromDB);
    }

    private Film getFilm() {
        Film film = new FilmImpl();
        film.setId(DEFAULT_ID);
        film.setStatisticId(DEFAULT_STATISTIC_ID);
        film.setName(DEFAULT_NAME);
        film.setFactList(DEFAULT_FACT_LIST);
        return film;
    }
}
