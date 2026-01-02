package com.example.appf1.navHost

import kotlinx.coroutines.flow.MutableSharedFlow

object sessionEvents

private val _navigation = MutableSharedFlow<rutasNavegacion>()
val navigation = _navigation

private val _forbidden = MutableSharedFlow<Unit>()
val forbidden = _forbidden


suspend fun emitForbidden() {
    _forbidden.emit(Unit)
}

suspend fun emitNavigation(navRoute: rutasNavegacion) {
    _navigation.emit(navRoute)
}
