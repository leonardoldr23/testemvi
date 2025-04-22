package br.com.mylister.main.model

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry

fun exitTransition(transitionDuration: Int): AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition =
    {
        if (isEntering(initialState.destination.route, targetState.destination.route)) {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(transitionDuration)
            )
        } else {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(transitionDuration)
            )
        }
    }

fun enterTransition(transitionDuration: Int): AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition =
    {
        if (isEntering(initialState.destination.route, targetState.destination.route)) {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(transitionDuration)
            )
        } else {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(transitionDuration)
            )
        }
    }