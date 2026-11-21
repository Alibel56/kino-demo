package com.practice.kino.service.impl;

import com.practice.kino.dto.request.AddMovieRequest;
import com.practice.kino.dto.request.MovieFilterRequest;
import com.practice.kino.dto.request.SortingType;
import com.practice.kino.dto.request.UpdateMovieRequest;
import com.practice.kino.dto.response.MovieReadResponse;
import com.practice.kino.entity.Movie;
import com.practice.kino.mapper.MovieMapper;
import com.practice.kino.repository.MovieRepository;
import com.practice.kino.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    @Override
    public void addMovie(AddMovieRequest request) {
        movieRepository.save(movieMapper.toEntity(request));
    }

    @Override
    public void updateMovie(UUID movieId, UpdateMovieRequest request) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found!"));

        movieMapper.updateEntity(request, movie);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(UUID movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public MovieReadResponse findMovieById(UUID movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        return movieMapper.toResponse(movie);
    }

    @Override
    public List<MovieReadResponse> findAllMoviesByFilter(MovieFilterRequest request) {
        List<Movie> list = movieRepository.findAll();

        return list.stream()
                .filter(filterMovie(request))
                .sorted(sortMovie(request.sortingType()))
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());

    }

    public Predicate<Movie> filterMovie(MovieFilterRequest request){
        return movie -> {

            // Filter by title
            boolean titleMatches =
                    request.title() == null ||
                            movie.getTitle().toLowerCase()
                                    .contains(request.title().toLowerCase());

            // Filter by release date FROM
            boolean dateFromMatches =
                    request.releaseDateFrom() == null ||
                            !movie.getReleaseDate()
                                    .isBefore(request.releaseDateFrom());

            // Filter by release date TO
            boolean dateToMatches =
                    request.releaseDateTo() == null ||
                            !movie.getReleaseDate()
                                    .isAfter(request.releaseDateTo());

            // Filter by genres
            boolean genresMatch =
                    request.genreList() == null ||
                            request.genreList().isEmpty() ||
                            request.genreList().stream().allMatch(genre ->
                                    movie.getMovieGenres().stream()
                                            .anyMatch(movieGenre ->
                                                    movieGenre.getGenre().getTitle()
                                                            .equalsIgnoreCase(genre)
                                            )
                            );

            // Filter by cast
            boolean castMatches =
                    request.castList() == null ||
                            request.castList().isEmpty() ||
                            request.castList().stream().allMatch(actor ->
                                    movie.getMovieCasts().stream()
                                            .anyMatch(movieCast -> {

                                                String fullName =
                                                        movieCast.getActor().getFirstName()
                                                                + " "
                                                                + movieCast.getActor().getLastName();

                                                return fullName.equalsIgnoreCase(actor);
                                            })
                            );

            // Filter by release country
            boolean countryMatches =
                    request.releaseCountry() == null ||
                            movie.getReleaseCountry().toLowerCase()
                                    .contains(request.releaseCountry().toLowerCase());

            return titleMatches
                    && dateFromMatches
                    && dateToMatches
                    && genresMatch
                    && castMatches
                    && countryMatches;
        };
    }

    private Comparator<Movie> sortMovie(SortingType sortingType) {

        if (sortingType == null) {
            return Comparator.comparing(Movie::getId);
        }

        return switch (sortingType) {

            case RATING_ASC -> Comparator.comparing(
                    movie -> movie.getRating() == null
                            ? null
                            : movie.getRating().getRating(),
                    Comparator.nullsLast(Comparator.naturalOrder())
            );

            case RATING_DESC -> Comparator.comparing(
                    movie -> movie.getRating() == null
                            ? null
                            : movie.getRating().getRating(),
                    Comparator.nullsLast(Comparator.reverseOrder())
            );

            case RELEASE_DATE_ASC -> Comparator.comparing(
                    Movie::getReleaseDate,
                    Comparator.nullsLast(Comparator.naturalOrder())
            );

            case RELEASE_DATE_DESC -> Comparator.comparing(
                    Movie::getReleaseDate,
                    Comparator.nullsLast(Comparator.reverseOrder())
            );

            case TITLE_ASC -> Comparator.comparing(
                    Movie::getTitle,
                    Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
            );

            case TITLE_DESC -> Comparator.comparing(
                    Movie::getTitle,
                    Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER.reversed())
            );
        };
    }
}
