package org.olga.main;

import org.hamcrest.core.IsNull;
import org.olga.entity.actor.Actor;
import org.olga.entity.actor.ActorImpl;
import org.olga.entity.fact.Fact;
import org.olga.entity.fact.FactImpl;
import org.olga.entity.film.Film;
import org.olga.entity.film.FilmImpl;
import org.olga.entity.statistic.Statistic;
import org.olga.entity.statistic.StatisticImpl;
import org.olga.service.actor.ActorService;
import org.olga.service.actor.ActorServiceImpl;
import org.olga.service.fact.FactService;
import org.olga.service.fact.FactServiceImpl;
import org.olga.service.film.FilmService;
import org.olga.service.film.FilmServiceImpl;
import org.olga.service.statistic.StatisticService;
import org.olga.service.statistic.StatisticServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MovieLibrary {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write 'break' if you want to quit or write command 'table action data'");
        System.out.println("****************************************************************");
        while (true) {
            try {
                String lineFromConsole = bufferedReader.readLine();
                String[] arrayFromConsole = lineFromConsole.split(" ");
                if (arrayFromConsole[0].equals("actor")) {
                    if (arrayFromConsole.length == 1) {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getById")) {
                        ActorService actorService = new ActorServiceImpl();
                        System.out.println("Actor with id:" + arrayFromConsole[2]);
                        System.out.println(actorService.getActorById(Long.parseLong(arrayFromConsole[2])));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getAll")) {
                        ActorService actorService = new ActorServiceImpl();
                        actorService.getAllActors()
                                .forEach(System.out::println);
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("create")) {
                        ActorService actorService = new ActorServiceImpl();
                        Actor actor = new ActorImpl();
                        actor.setId(Long.parseLong(arrayFromConsole[2]));
                        actor.setName(arrayFromConsole[3]);
                        actor.setSurname(arrayFromConsole[4]);
                        System.out.println("Created actor:");
                        System.out.println(actorService.create(actor));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("update")) {
                        ActorService actorService = new ActorServiceImpl();
                        Actor actor = new ActorImpl();
                        actor.setId(Long.parseLong(arrayFromConsole[2]));
                        actor.setName(arrayFromConsole[3]);
                        actor.setSurname(arrayFromConsole[4]);
                        System.out.println("Updated actor:");
                        System.out.println(actorService.update(actor));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("delete")) {
                        ActorService actorService = new ActorServiceImpl();
                        actorService.delete(Long.parseLong(arrayFromConsole[2]));
                        System.out.println("****************************************************************");
                    } else {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    }
                } else if (arrayFromConsole[0].equals("fact")) {
                    if (arrayFromConsole.length == 1) {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getById")) {
                        FactService factService = new FactServiceImpl();
                        System.out.println("Fact with id:" + arrayFromConsole[2]);
                        System.out.println(factService.getFactById(Long.parseLong(arrayFromConsole[2])));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getAll")) {
                        FactService factService = new FactServiceImpl();
                        factService.getAllFacts()
                                .forEach(System.out::println);
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("create")) {
                        FactService factService = new FactServiceImpl();
                        Fact fact = new FactImpl();
                        fact.setId(Long.parseLong(arrayFromConsole[2]));
                        fact.setFactText(arrayFromConsole[3]);
                        System.out.println("Created fact:");
                        System.out.println(factService.create(fact));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("update")) {
                        FactService factService = new FactServiceImpl();
                        Fact fact = new FactImpl();
                        fact.setId(Long.parseLong(arrayFromConsole[2]));
                        fact.setFactText(arrayFromConsole[3]);
                        System.out.println("Updated fact:");
                        System.out.println(factService.update(fact));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("delete")) {
                        FactService factService = new FactServiceImpl();
                        factService.delete(Long.parseLong(arrayFromConsole[2]));
                        System.out.println("****************************************************************");
                    } else {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    }
                } else if (arrayFromConsole[0].equals("film")) {
                    if (arrayFromConsole.length == 1) {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getById")) {
                        FilmService filmService = new FilmServiceImpl();
                        System.out.println("Film with id:" + arrayFromConsole[2]);
                        System.out.println(filmService.getFilmById(Long.parseLong(arrayFromConsole[2])));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getAll")) {
                        FilmService filmService = new FilmServiceImpl();
                        filmService.getAllFilms()
                                .forEach(System.out::println);
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("create")) {
                        FilmService filmService = new FilmServiceImpl();
                        Film film = new FilmImpl();
                        film.setId(Long.parseLong(arrayFromConsole[2]));
                        film.setName(arrayFromConsole[3]);
                        film.setStatisticId(Long.parseLong(arrayFromConsole[4]));
                        System.out.println("Created film:");
                        System.out.println(filmService.create(film));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("update")) {
                        FilmService filmService = new FilmServiceImpl();
                        Film film = new FilmImpl();
                        film.setId(Long.parseLong(arrayFromConsole[2]));
                        film.setName(arrayFromConsole[3]);
                        film.setStatisticId(Long.parseLong(arrayFromConsole[4]));
                        System.out.println("Updated film:");
                        System.out.println(filmService.update(film));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("delete")) {
                        FilmService filmService = new FilmServiceImpl();
                        filmService.delete(Long.parseLong(arrayFromConsole[2]));
                        System.out.println("****************************************************************");
                    } else {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    }
                } else if (arrayFromConsole[0].equals("statistic")) {
                    if (arrayFromConsole.length == 1) {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getById")) {
                        StatisticService statisticService = new StatisticServiceImpl();
                        System.out.println("Statistic with id:" + arrayFromConsole[2]);
                        System.out.println(statisticService.getStatisticById(Long.parseLong(arrayFromConsole[2])));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("getAll")) {
                        StatisticService statisticService = new StatisticServiceImpl();
                        statisticService.getAllStatistics()
                                .forEach(System.out::println);
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("create")) {
                        StatisticService statisticService = new StatisticServiceImpl();
                        Statistic statistic = new StatisticImpl();
                        statistic.setId(Long.parseLong(arrayFromConsole[2]));
                        statistic.setBudget(Double.parseDouble(arrayFromConsole[3]));
                        statistic.setBoxOffice(Double.parseDouble(arrayFromConsole[4]));
                        System.out.println("Created statistic:");
                        System.out.println(statisticService.create(statistic));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("update")) {
                        StatisticService statisticService = new StatisticServiceImpl();
                        Statistic statistic = new StatisticImpl();
                        statistic.setId(Long.parseLong(arrayFromConsole[2]));
                        statistic.setBudget(Double.parseDouble(arrayFromConsole[3]));
                        statistic.setBoxOffice(Double.parseDouble(arrayFromConsole[4]));
                        System.out.println("Updated statistic:");
                        System.out.println(statisticService.update(statistic));
                        System.out.println("****************************************************************");
                    } else if (arrayFromConsole[1].equals("delete")) {
                        StatisticService statisticService = new StatisticServiceImpl();
                        statisticService.delete(Long.parseLong(arrayFromConsole[2]));
                        System.out.println("****************************************************************");
                    } else {
                        System.out.println("Wrong action");
                        System.out.println("****************************************************************");
                    }
                } else if (arrayFromConsole[0].equals("break")) {
                    break;
                } else {
                    System.out.println("Wrong action");
                    System.out.println("****************************************************************");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
