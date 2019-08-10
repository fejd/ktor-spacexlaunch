package com.spacexlaunch.app.json

import com.spacexlaunch.app.json.Payload

data class SecondStage(
    val block: Int,
    val payloads: List<Payload>
)