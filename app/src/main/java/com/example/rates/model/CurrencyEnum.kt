package com.example.rates.model

import com.example.rates.R

/**
 *
 * @author Maxim on 2020-01-30
 */
enum class CurrencyEnum(val drawableRes: Int, val currencyName: String) {
    EUR(R.drawable.ic_eu, "Euro"),
    CAD(R.drawable.ic_canada, "Canadian Dollar"),
    USD(R.drawable.ic_us, "US Dollar"),
    SEK(R.drawable.ic_sweden, "Swedish Krona"),
    AUD(R.drawable.ic_australia, "Australian Dollar"),
    SGD(R.drawable.ic_singapore, "Singapore Dollar"),
    BRL(R.drawable.ic_brazil, "Brazilian Real"),
    PLN(R.drawable.ic_poland, "Polish Zloty"),
    CZK(R.drawable.ic_czech, "Czech Koruna"),
    HKD(R.drawable.ic_hong_kong, "Hong Kong Dollar"),
    RUB(R.drawable.ic_russia, "Russian Ruble"),
    MXN(R.drawable.ic_mexico, "Mexican Peso"),
    NOK(R.drawable.ic_norway, "Norwegian Krone"),
    BGN(R.drawable.ic_bulgaria, "Bulgarian Lev"),
    CNY(R.drawable.ic_yuan, "Renminbi (Yuan)"),
    RON(R.drawable.ic_romania, "Leu"),
    NZD(R.drawable.ic_new_zealand, "New Zealand Dollar"),
    PHP(R.drawable.ic_philippines, "Philippine Peso"),
    TRY(R.drawable.ic_turkey, "Turkey Lira"),
    GBP(R.drawable.ic_uk, "Pound Sterling"),
    HRK(R.drawable.ic_croatia, "Croatian Kuna"),
    HUF(R.drawable.ic_hungary, "Forint"),
    IDR(R.drawable.ic_indonesia, "Rupiah"),
    CHF(R.drawable.ic_switzerland, "Swiss Franc"),
    DKK(R.drawable.ic_denmark, "Danish Kroner"),
    ILS(R.drawable.ic_israel, "New Israeli Sheqel"),
    INR(R.drawable.ic_india, "Indian Rupee"),
    ISK(R.drawable.ic_iceland, "Iceland Krona"),
    JPY(R.drawable.ic_japan, "Yen"),
    KRW(R.drawable.ic_south_korea, "Won"),
    MYR(R.drawable.ic_malaysia, "Malaysian Ringgit"),
    THB(R.drawable.ic_thailand, "Thai Baht"),
    ZAR(R.drawable.ic_south_afrika, "South African Rand");
}