package com.example.cowin

data class testdata(
    val centers: List<Center>
) {
    data class Center(
        val address: String,
        val block_name: String,
        val center_id: Int,
        val district_name: String,
        val fee_type: String,
        val from: String,
        val lat: Int,
        val long: Int,
        val name: String,
        val pincode: Int,
        val sessions: List<Session>,
        val state_name: String,
        val to: String
    ) {
        data class Session(
            val available_capacity: Int,
            val date: String,
            val min_age_limit: Int,
            val session_id: String,
            val slots: List<String>,
            val vaccine: String
        )
    }
}