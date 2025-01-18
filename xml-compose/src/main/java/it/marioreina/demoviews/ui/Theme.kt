package it.marioreina.demoviews.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import it.marioreina.demoviews.R

@Composable
fun DemoAndroidNativeTheme(
    content: @Composable () -> Unit
) {
    //Color
    val main500 = colorResource(R.color.main_500)
    val main200 = colorResource(R.color.main_200)
    val main700 = colorResource(R.color.main_700)
    val main800 = colorResource(R.color.main_800)
    val white = colorResource(R.color.white)
    val black = colorResource(R.color.black)

    val colorScheme =  lightColorScheme(
        primary = main500,
        onPrimary = white,
        primaryContainer = main700,
        secondary = main200,
        onSecondary = black,
        secondaryContainer = main700,
        background = white,
        surface = white,   
        onBackground = main800,
        onSurface = black,
    )

    val customFontFamily = FontFamily(
        Font(R.font.source_sans_pro_regular, FontWeight.Normal),
        Font(R.font.source_sans_pro_semi_bold, FontWeight.SemiBold),
    )

    //text style
    val typography = Typography(
        
        labelMedium = TextStyle(
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionResource(R.dimen.text_size_medium).value.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = customFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = dimensionResource(R.dimen.text_size_medium).value.sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionResource(R.dimen.text_size_medium_plus).value.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = customFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = dimensionResource(R.dimen.text_size_medium_plus).value.sp,
        )
    )


    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}