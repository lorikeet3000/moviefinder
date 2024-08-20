package com.example.moviefinder

import com.example.moviefinder.presentation.model.Country
import com.example.moviefinder.presentation.model.Genre
import com.example.moviefinder.presentation.model.Movie
import com.example.moviefinder.presentation.viewmodel.DetailsViewItem

val MovieList = listOf(
    Movie(
        id = 843649,
        title = "Мстители: Война бесконечности",
        description = "Пока Мстители и их союзники продолжают защищать мир от различных опасностей, с которыми не смог бы справиться один супергерой, новая угроза возникает из космоса: Танос. Межгалактический тиран преследует цель собрать все шесть Камней Бесконечности - артефакты невероятной силы, с помощью которых можно менять реальность по своему желанию. Всё, с чем Мстители сталкивались ранее, вело к этому моменту – судьба Земли никогда ещё не была столь неопределённой.",
        rating = 8.081,
        imageUrl = "https://image.openmoviedb.com/kinopoisk-images/1773646/af92d310-4ae5-4daa-b42c-5bcc380c2e6e/x1000",
        year = 2018
    ),
    Movie(
        id = 843650,
        title = "Мстители: Финал",
        description = "Оставшиеся в живых члены команды Мстителей и их союзники должны разработать новый план, который поможет противостоять разрушительным действиям могущественного титана Таноса. После наиболее масштабной и трагической битвы в истории они не могут допустить ошибку.",
        rating = 7.869,
        imageUrl = "https://image.openmoviedb.com/kinopoisk-images/1600647/ae22f153-9715-41bb-adb4-f648b3e16092/x1000",
        year = 2019
    ),
    Movie(
        id = 679830,
        title = "Мстители: Эра Альтрона",
        description = "Человечество на грани уничтожения. На этот раз людям угрожает Альтрон — искусственный интеллект, ранее созданный для того, чтобы защищать Землю от любых угроз. Однако, главной угрозой он посчитал человечество. Международная организация Щ.И.Т. распалась, и теперь мир не способен справиться с таким мощным врагом, потому люди вновь обращаются за помощью к Величайшим Героям Земли — Мстителям. Однако Альтрон слишком силен, и есть большая вероятность, что даже им не удастся остановить начало надвигающейся Эры Альтрона, где нет места для людей…",
        rating = 7.257,
        imageUrl = "https://image.openmoviedb.com/kinopoisk-images/1900788/881abd28-a361-4a23-916a-3e2cc781ba83/x1000",
        year = 2015
    )
)

fun getDetailsScreen(id: Long): List<DetailsViewItem> {
    val movie = MovieList.firstOrNull {
        it.id == id
    }

    return listOf(
        DetailsViewItem.Title(movie?.title ?: "Мстители: Эра Альтрона"),
        DetailsViewItem.Image(movie?.imageUrl ?: "https://image.openmoviedb.com/kinopoisk-images/1900788/881abd28-a361-4a23-916a-3e2cc781ba83/x1000"),
        DetailsViewItem.Countries(countries = listOf(
            Country("США")
        )),
        DetailsViewItem.Genres(genres = listOf(
            Genre("фантастика"),
            Genre("боевик"),
            Genre("драма"),
            Genre("приключения")
        )),
        DetailsViewItem.Description(movie?.description ?: "Человечество на грани уничтожения. На этот раз людям угрожает Альтрон — искусственный интеллект, ранее созданный для того, чтобы защищать Землю от любых угроз. Однако, главной угрозой он посчитал человечество. Международная организация Щ.И.Т. распалась, и теперь мир не способен справиться с таким мощным врагом, потому люди вновь обращаются за помощью к Величайшим Героям Земли — Мстителям. Однако Альтрон слишком силен, и есть большая вероятность, что даже им не удастся остановить начало надвигающейся Эры Альтрона, где нет места для людей…"),
    )
}