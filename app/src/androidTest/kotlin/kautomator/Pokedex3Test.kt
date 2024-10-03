package kautomator

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dev.marcosfarias.pokedex.screen.MainScreen
import dev.marcosfarias.pokedex.screen.PokedexScreen
import kautomator.screen.MainScreen2
import kautomator.screen.PACKAGE
import kautomator.screen.PokedexScreen2
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


class Pokedex3Test : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {

    @Test
    fun PokedexTest3() {
        before {
            device.apps.launch(PACKAGE)
            device.uiDevice.waitForIdle()
            Thread.sleep(5000)
        }.after {
            device.apps.kill(PACKAGE)
        }.run {
            MainScreen2.getMenuItemByTitle("Pokedex").click()

            PokedexScreen2 {
                pokedex.isDisplayed()

                step("Check menu elements content") {
                    getItemByTitle("Bulbasaur").isDisplayed()
                    getItemByTitle("Ivysaur").isDisplayed()
                    getItemByTitle("Venusaur").isDisplayed()
                }
            }
        }
    }

    @Test
    fun allGenTest() {
        before {
            device.apps.launch(PACKAGE)
            device.uiDevice.waitForIdle()
            Thread.sleep(5000)
        }.after {
            device.apps.kill(PACKAGE)
        }.run {
            MainScreen2.getMenuItemByTitle("Pokedex").click()
            device.uiDevice.waitForIdle()

            step("Check elements") {
                PokedexScreen2 {
                    pokedex.isDisplayed()
                    sd_main_fab.click()
                    allGen.click()

                    getGenerationItemByTitle("Generation I").isDisplayed()
                    getGenerationItemByTitle("Generation II").isDisplayed()
                    getGenerationItemByTitle("Generation III").isDisplayed()
                }
            }
        }
    }
}