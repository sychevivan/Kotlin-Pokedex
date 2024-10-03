package kautomator.screen

import android.view.View
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import com.kaspersky.kaspresso.screens.KScreen
import dev.marcosfarias.pokedex.R
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object PokedexScreen2 : UiScreen<PokedexScreen2>() {

    override val packageName: String = PACKAGE

    val pokedex = UiTextView { withText("Pokedex") }


    fun getItemByTitle(title: String): UiTextView {
        return UiTextView {
            withId(PACKAGE, "textViewName")
            withText(title)
        }
    }

    val sd_main_fab = UiButton {  withId(PACKAGE, "sd_main_fab")  }
    val allGen = UiButton {
        withId(PACKAGE, "sd_label")
        withText("All Gen")
    }

    val generation = UiTextView { withText("Generation") }

    fun getGenerationItemByTitle(title: String): UiTextView {
        return UiTextView {
            withId(PACKAGE, "textViewTitle")
            withText(title)
        }
    }
}