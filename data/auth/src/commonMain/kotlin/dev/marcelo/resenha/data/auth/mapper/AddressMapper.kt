package dev.marcelo.resenha.data.auth.mapper

import dev.marcelo.resenha.data.auth.model.AddressResponse
import dev.marcelo.resenha.domain.auth.model.AddressModel

fun AddressResponse.toModel(): AddressModel {
    return AddressModel(
        street = street,
        neighborhood = neighborhood,
        city = city,
        stateAbbreviation = stateAbbreviation,
        state = state,
        region = region,
        areaCode = areaCode
    )
}