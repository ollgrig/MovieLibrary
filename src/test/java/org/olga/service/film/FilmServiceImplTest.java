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

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
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
        when(filmService.getFilmDAO()).thenReturn(filmDAO);
        when(filmService.convert(film, filmFromDB)).thenReturn(film);
        when(filmDAO.update(film)).thenReturn(film);

        Film result = filmService.update(film);

        assertEquals(film, result);
        verify(filmDAO).update(film);
    }

    @Test
    public void shouldReturnFilmByIdFromDB() {
        Film filmFromDB = getFilm();
        when(filmService.getFilmDAO()).thenReturn(filmDAO);
        when(filmService.getFilmById(DEFAULT_ID)).thenCallRealMethod();
        when(filmDAO.getById(DEFAULT_ID)).thenReturn(filmFromDB);

        filmService.getFilmById(DEFAULT_ID);

        verify(filmDAO).getById(DEFAULT_ID);
    }

    @Test
    public void shouldReturnFilmByAllFromDB() {
        List<Film> filmList = getFilmList();
        when(filmService.getFilmDAO()).thenReturn(filmDAO);
        when(filmService.getAllFilms()).thenCallRealMethod();
        when(filmDAO.getAll()).thenReturn(filmList);

        filmService.getAllFilms();

        verify(filmDAO).getAll();
    }

    @Test
    public void shouldReturnChangedFilm() {
        Film film = getFilm();
        Film filmEntity = getFilm();
        filmEntity.setName("old name");
        when(filmService.convert(any(Film.class), any(Film.class))).thenCallRealMethod();

        Film result = filmService.convert(film, filmEntity);

        assertEquals(film, result);
    }

    @Test
    public void shouldReturnCreatedFilmFromDB() {
        Film film = getFilm();
        when(filmService.create(any(Film.class))).thenCallRealMethod();
        when(filmService.getFilmDAO()).thenReturn(filmDAO);
        when(filmDAO.create(film)).thenReturn(film);

        Film result = filmService.create(film);

        assertEquals(film, result);
        verify(filmDAO).create(film);
    }

    @Test
    public void shouldCallDelete() {
        doCallRealMethod().when(filmService).delete(DEFAULT_ID);
        when(filmService.getFilmDAO()).thenReturn(filmDAO);
        when(filmDAO.delete(DEFAULT_ID)).thenReturn(any(Boolean.class));

        filmService.delete(DEFAULT_ID);

        verify(filmDAO).delete(DEFAULT_ID);
    }

    private Film getFilm() {
        Film film = new FilmImpl();
        film.setId(DEFAULT_ID);
        film.setStatisticId(DEFAULT_STATISTIC_ID);
        film.setName(DEFAULT_NAME);
        film.setFactList(DEFAULT_FACT_LIST);
        return film;
    }

    private List<Film> getFilmList() {
        return singletonList(getFilm());
    }
}
