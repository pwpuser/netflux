package com.pwp.netflux.bootstrap;

import com.pwp.netflux.domain.Movie;
import com.pwp.netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMongoDBData implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(Flux.just("Star Wars: Phantom Menace - Episode 1",
                "Star Wars: Attack of the Clones - Episode 2",
                "Star Wars: Revenge of the Sith - Episode 3",
                "Star Wars: New Hope - Episode 4",
                "Star Wars: Empire Strikes Back - Episode 5",
                "Star Wars: Return of the Jedi - Episode 6",
                "Star Wars: Force Awakens - Episode 7",
                "Star Wars: The Last Jedi - Episode 8",
                "Star Wars: Skywalker Rises - Episode 9")
                .map(Movie::new)
                .flatMap(movieRepository::save))
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
