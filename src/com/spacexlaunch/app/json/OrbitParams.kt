package com.spacexlaunch.app.json

data class OrbitParams(
    val apoapsis_km: Any,
    val arg_of_pericenter: Any,
    val eccentricity: Any,
    val epoch: Any,
    val inclination_deg: Any,
    val lifespan_years: Int,
    val longitude: Int,
    val mean_anomaly: Any,
    val mean_motion: Any,
    val periapsis_km: Any,
    val period_min: Any,
    val raan: Any,
    val reference_system: String,
    val regime: String,
    val semi_major_axis_km: Any
)