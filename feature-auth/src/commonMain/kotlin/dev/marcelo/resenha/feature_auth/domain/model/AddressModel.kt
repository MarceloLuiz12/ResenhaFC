package dev.marcelo.resenha.feature_auth.domain.model

data class AddressModel(
    val street: String,
    val neighborhood: String,
    val city: String,
    val stateAbbreviation: String,
    val state: String,
    val region: String,
    val areaCode: String,
)