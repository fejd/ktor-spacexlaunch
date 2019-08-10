package com.spacexlaunch.app.json

data class Core(
    val block: Int,
    val core_serial: String,
    val flight: Int,
    val gridfins: Boolean,
    val land_success: Any,
    val landing_intent: Boolean,
    val landing_type: Any,
    val landing_vehicle: Any,
    val legs: Boolean,
    val reused: Boolean
)