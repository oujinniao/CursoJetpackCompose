package com.example.cursodejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Cicada3301Scene()
                }
            }
        }
    }
}

@Composable
fun Cicada3301Scene() {
    // Animaciones para los diferentes elementos
    val infiniteTransition = rememberInfiniteTransition()

    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val pulse by infiniteTransition.animateFloat(
        initialValue = 0.7f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val wingMovement by infiniteTransition.animateFloat(
        initialValue = -15f,
        targetValue = 15f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        // Fondo con elementos criptográficos
        CryptographicBackground(rotation)

        // Esfera central con patrones
        CentralSphere(rotation, pulse)

        // Cigarra estilizada
        StylizedCicada(wingMovement)

        // Texto flotante con símbolos
        FloatingSymbols(rotation)

        // Título
        Text(
            text = "CICADA 3301",
            color = Color(0xFF00CCFF),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        )
    }
}

@Composable
fun CryptographicBackground(rotation: Float) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Dibujar elementos criptográficos en el fondo
        for (i in 0 until 50) {
            val angle = Math.toRadians((i * 360 / 50 + rotation).toDouble())
            val radius = size.minDimension * 0.4f
            val x = center.x + (radius * cos(angle)).toFloat()
            val y = center.y + (radius * sin(angle)).toFloat()

            rotate(degrees = rotation, pivot = Offset(x, y)) {
                drawCircle(
                    color = Color(0x5533CCFF),
                    radius = 4f,
                    center = Offset(x, y)
                )

                drawLine(
                    color = Color(0x5533CCFF),
                    start = center,
                    end = Offset(x, y),
                    strokeWidth = 0.5f
                )
            }
        }
    }
}

@Composable
fun CentralSphere(rotation: Float, pulse: Float) {
    Canvas(modifier = Modifier.size(200.dp)) {
        // Esfera base
        drawCircle(
            color = Color(0x88111133),
            radius = size.minDimension * 0.4f * pulse,
            center = center
        )

        // Patrones en la esfera
        for (i in 0 until 12) {
            val angle = Math.toRadians((i * 30 + rotation).toDouble())
            val x = center.x + (size.minDimension * 0.35f * cos(angle)).toFloat()
            val y = center.y + (size.minDimension * 0.35f * sin(angle)).toFloat()

            drawCircle(
                color = Color(0xAA00CCFF),
                radius = 8f * pulse,
                center = Offset(x, y)
            )
        }

        // Aros concéntricos
        for (i in 1..3) {
            drawCircle(
                color = Color(0x4400CCFF),
                radius = size.minDimension * 0.1f * i,
                center = center,
                style = Stroke(width = 1f)
            )
        }
    }
}

@Composable
fun StylizedCicada(wingMovement: Float) {
    Canvas(modifier = Modifier.size(250.dp)) {
        // Cuerpo
        drawRoundRect(
            color = Color(0xFF1a1a1a),
            topLeft = Offset(center.x - 15f, center.y - 60f),
            size = Size(30f, 120f),
            cornerRadius = CornerRadius(15f, 15f)
        )

        // Cabeza
        drawCircle(
            color = Color(0xFF1a1a1a),
            radius = 20f,
            center = Offset(center.x, center.y - 70f)
        )

        // Ojos
        drawCircle(
            color = Color(0xFFFF3300),
            radius = 8f,
            center = Offset(center.x - 8f, center.y - 75f)
        )
        drawCircle(
            color = Color(0xFFFF3300),
            radius = 8f,
            center = Offset(center.x + 8f, center.y - 75f)
        )

        // Alas - izquierda con animación
        val wingPath = Path().apply {
            moveTo(center.x, center.y - 30f)
            quadraticBezierTo(
                center.x - 70f, center.y - 30f + wingMovement,
                center.x - 40f, center.y + 40f
            )
            quadraticBezierTo(
                center.x - 10f, center.y + 20f,
                center.x, center.y - 30f
            )
        }

        drawPath(
            path = wingPath,
            color = Color(0x88330099),
            style = Fill
        )

        // Ala derecha con animación
        val rightWingPath = Path().apply {
            moveTo(center.x, center.y - 30f)
            quadraticBezierTo(
                center.x + 70f, center.y - 30f - wingMovement,
                center.x + 40f, center.y + 40f
            )
            quadraticBezierTo(
                center.x + 10f, center.y + 20f,
                center.x, center.y - 30f
            )
        }

        drawPath(
            path = rightWingPath,
            color = Color(0x88330099),
            style = Fill
        )
    }
}

@Composable
fun FloatingSymbols(rotation: Float) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Símbolos flotantes alrededor de la esfera central
        val symbols = listOf("π", "φ", "Ω", "∑", "∫", "√", "∞", "∇", "Δ", "λ")

        for (i in symbols.indices) {
            val angle = Math.toRadians((i * 36 + rotation).toDouble())
            val radius = size.minDimension * 0.3f
            val x = center.x + (radius * cos(angle)).toFloat()
            val y = center.y + (radius * sin(angle)).toFloat()

            rotate(degrees = rotation * 2, pivot = Offset(x, y)) {
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        symbols[i],
                        x,
                        y,
                        android.graphics.Paint().apply {
                            color = android.graphics.Color.argb(200, 0, 204, 255)
                            textSize = 24f
                            textAlign = android.graphics.Paint.Align.CENTER
                        }
                    )
                }
            }
        }
    }
}




