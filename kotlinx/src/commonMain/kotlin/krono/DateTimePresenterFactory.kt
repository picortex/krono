package krono

fun Instant.toDateTimePresenter(tz: TimeZone, pattern: PresenterPattern): LocalDateTimePresenter {
    val zdt = atZone(tz)
    return DateTimePresenter(zdt.date, zdt.time, tz, pattern)
}