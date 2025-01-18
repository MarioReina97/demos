package it.marioreina.demoviews.credits

import android.net.Uri
import android.text.style.URLSpan
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.weredev.binding_ui.convertFromHtml
import it.marioreina.demoviews.R

@Composable
fun CreditsScreen(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding10))
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            text = buildAnnotatedString {
                val spannedText =  stringResource(R.string.credits_message).convertFromHtml()
                append(spannedText)

                spannedText.getSpans(0, spannedText.length, URLSpan::class.java).forEach { span ->
                    val start = spannedText.getSpanStart(span)
                    val end = spannedText.getSpanEnd(span)

                    addStyle(
                        style = SpanStyle(color = colorResource(R.color.main_500), textDecoration = TextDecoration.Underline),
                        start = start,
                        end = end
                    )

                    addStringAnnotation(
                        tag = "URL",
                        annotation = span.url,
                        start = start,
                        end = end
                    )
                }
            },
            style = TextStyle(color = colorResource(id = R.color.black)),
        )
    }
}

@Preview
@Composable
fun PreviewCreditsScreen() {
    CreditsScreen()
}