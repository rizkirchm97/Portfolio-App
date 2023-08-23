package com.rizkir.mobileappportofolio.common.components

import androidx.compose.runtime.Composable

@Composable
fun LoadingContent(
    isLoading: Boolean,
    loading: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    if (isLoading) loading()
    else content()
}