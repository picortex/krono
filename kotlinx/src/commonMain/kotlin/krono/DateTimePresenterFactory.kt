package krono

fun Instant.toDateTimePresenter(tz: TimeZone, formatter: PureDateTimeFormatter): DateTimePresenter {
    val zdt = atZone(tz)
    return DateTimePresenter(zdt.date, zdt.time, formatter)
}