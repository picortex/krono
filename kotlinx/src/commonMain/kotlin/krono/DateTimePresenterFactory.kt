package krono

fun Instant.toDateTimePresenter(tz: TimeZone, pattern: PresenterPattern): DateTimePresenter {
    val zdt = atZone(tz)
    return DateTimePresenter(zdt.date, zdt.time, tz, pattern)
}