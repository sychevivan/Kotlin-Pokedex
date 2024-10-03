package kautomator.screen

import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

const val PACKAGE = "dev.marcosfarias.pokedex"

object MainScreen2 : UiScreen<MainScreen2>() {
    override val packageName: String = PACKAGE

    val search_text = UiTextView { withId(PACKAGE, "search_text") }

    fun getMenuItemByTitle(title: String): UiTextView {
        return UiTextView {
            withId(PACKAGE, "textViewName")
            withText(title)
        }
    }

    fun getNewsItem(index: Int): UiTextView {
        return UiTextView {
            withIndex(index) {
                withId(PACKAGE, "textViewName")
                withText("Pokémon Rumble Rush Arrives Soon")
            }
        }
    }
}