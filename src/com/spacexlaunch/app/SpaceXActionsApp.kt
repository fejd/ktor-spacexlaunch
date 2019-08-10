package com.spacexlaunch.app

import com.google.actions.api.ActionRequest
import com.google.actions.api.ActionResponse
import com.google.actions.api.DialogflowApp
import com.google.actions.api.ForIntent

class SpaceXActionsApp : DialogflowApp() {
    @ForIntent("Latest launch")
    fun latestLaunch(request: ActionRequest): ActionResponse {
        val responseBuilder = getResponseBuilder(request)
        SpaceXRepository().getLatestLaunch {
            responseBuilder.add(it.details)
            responseBuilder.endConversation()
        }
        return responseBuilder.build()
    }
}