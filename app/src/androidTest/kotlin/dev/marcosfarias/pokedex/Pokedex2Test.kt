package dev.marcosfarias.pokedex

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dev.marcosfarias.pokedex.screen.MainScreen
import dev.marcosfarias.pokedex.screen.PokedexScreen
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


class Pokedex2Test : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun PokedexTest() {
        run {
            MainScreen.recyclerViewMenu.childAt<MainScreen.RvItemScreen>(0) {
                click()
            }

            PokedexScreen {
                pokedex.isDisplayed()

                step("Check menu elements content") {
                    recyclerView {
                        childAt<PokedexScreen.RvItem>(0) {
                            textViewName.isDisplayed()
                            textViewName.hasText("Bulbasaur")
                        }
                        childAt<PokedexScreen.RvItem>(1) {
                            textViewName.isDisplayed()
                            textViewName.hasText("Ivysaur")
                        }
                        childAt<PokedexScreen.RvItem>(2) {
                            textViewName.isDisplayed()
                            textViewName.hasText("Venusaur")
                        }
                    }
                }

                step("Swipe") {

                    recyclerView.isDisplayed()
//                    recyclerView.swipeUp()

                    val height = device.uiDevice.displayHeight
                    val width = device.uiDevice.displayWidth
                    device.uiDevice.swipe(width / 2, height / 2, width / 2, 0, 200)


                    recyclerView {
                        device.uiDevice.waitForIdle()
                        childAt<PokedexScreen.RvItem>(20) {
                            textViewName {
                                isDisplayed()
                                hasAnyText()
                                hasNoText("Bulbasaur")
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun allGenTest() {
        run {
            MainScreen.recyclerViewMenu.childAt<MainScreen.RvItemScreen>(0) {
                click()
            }

            PokedexScreen {
                pokedex.isDisplayed()
                sd_main_fab.click()
                allGen.click()

                step("Check menu count") {
                    Assert.assertEquals(8, recyclerView.getSize())
                }

                step("Check menu elements visibility") {
                    recyclerView {
                        children<PokedexScreen.RvItem> {
                            textViewTitle {
                                isDisplayed()
                                hasAnyText()
                            }
                        }
                    }
                }

                step("Check menu elements content") {
                    recyclerView {
                        childAt<PokedexScreen.RvItem>(0) {
                            textViewTitle.isDisplayed()
                            textViewTitle.hasText("Generation I")
                        }
                        childAt<PokedexScreen.RvItem>(1) {
                            textViewTitle.isDisplayed()
                            textViewTitle.hasText("Generation II")
                        }
                        childAt<PokedexScreen.RvItem>(2) {
                            textViewTitle.isDisplayed()
                            textViewTitle.hasText("Generation III")
                        }
                    }
                }
            }
        }
    }
}