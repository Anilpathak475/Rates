package com.example.rates.extensions

import com.example.rates.model.Currency
import com.example.rates.model.CurrencyEnum

/**
 *
 * @author Maxim on 2020-01-30
 */

fun Currency.getFullNameAndDrawable(): CurrencyEnum {
    return when(this.name) {
        CurrencyEnum.AUD.name -> CurrencyEnum.AUD
        CurrencyEnum.BGN.name -> CurrencyEnum.BGN
        CurrencyEnum.BRL.name -> CurrencyEnum.BRL
        CurrencyEnum.CAD.name -> CurrencyEnum.CAD
        CurrencyEnum.CHF.name -> CurrencyEnum.CHF
        CurrencyEnum.CNY.name -> CurrencyEnum.CNY
        CurrencyEnum.CZK.name -> CurrencyEnum.CZK
        CurrencyEnum.DKK.name -> CurrencyEnum.DKK
        CurrencyEnum.GBP.name -> CurrencyEnum.GBP
        CurrencyEnum.HKD.name -> CurrencyEnum.HKD
        CurrencyEnum.HRK.name -> CurrencyEnum.HRK
        CurrencyEnum.HUF.name -> CurrencyEnum.HUF
        CurrencyEnum.IDR.name -> CurrencyEnum.IDR
        CurrencyEnum.ILS.name -> CurrencyEnum.ILS
        CurrencyEnum.INR.name -> CurrencyEnum.INR
        CurrencyEnum.ISK.name -> CurrencyEnum.ISK
        CurrencyEnum.JPY.name -> CurrencyEnum.JPY
        CurrencyEnum.MXN.name -> CurrencyEnum.MXN
        CurrencyEnum.MYR.name -> CurrencyEnum.MYR
        CurrencyEnum.KRW.name -> CurrencyEnum.KRW
        CurrencyEnum.NOK.name -> CurrencyEnum.NOK
        CurrencyEnum.NZD.name -> CurrencyEnum.NZD
        CurrencyEnum.PHP.name -> CurrencyEnum.PHP
        CurrencyEnum.PLN.name -> CurrencyEnum.PLN
        CurrencyEnum.RON.name -> CurrencyEnum.RON
        CurrencyEnum.RUB.name -> CurrencyEnum.RUB
        CurrencyEnum.SEK.name -> CurrencyEnum.SEK
        CurrencyEnum.SGD.name -> CurrencyEnum.SGD
        CurrencyEnum.THB.name -> CurrencyEnum.THB
        CurrencyEnum.TRY.name -> CurrencyEnum.TRY
        CurrencyEnum.USD.name -> CurrencyEnum.USD
        CurrencyEnum.ZAR.name -> CurrencyEnum.ZAR
        else -> CurrencyEnum.EUR
    }
}