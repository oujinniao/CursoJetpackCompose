package com.example.cursodejetpackcompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme( // Colores para el tema oscuro
    primary = Purple80, // color que se usa en elementos destacados
    secondary = PurpleGrey80, // color que se usa en elementos secundarios o menos destacados
    tertiary = Pink80 // color que se usa en elementos de texto o títulos o adicionales
)

private val LightColorScheme = lightColorScheme(  // Colores para el tema claro
    primary = Purple40, // color que se usa en elementos destacados
    secondary = PurpleGrey40, // color que se usa en elementos secundarios o menos destacados
    tertiary = Pink40 // color que se usa en elementos de texto o títulos o adicionales

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun CursoDeJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, // indica si se debe usar el color dinamico
    //dynamicColors: Boolean = false,// indica que los colores no son dinamicos
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        //si dinamico es verdadero y la version de android es mayor o igual a 12
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}