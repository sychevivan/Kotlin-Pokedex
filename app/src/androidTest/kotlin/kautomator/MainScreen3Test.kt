package kautomator

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import kautomator.screen.MainScreen2
import kautomator.screen.PACKAGE
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import java.io.File


class MainScreen3Test : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @Test
    fun `1kautomatorTest`() {
        before {
            device.uiDevice.wakeUp()
            device.uiDevice.pressHome()

            println("Install package")
            val testContext = device.context
            val apk =
                testContext.resources.openRawResource(dev.marcosfarias.pokedex.test.R.raw.appdebug)

            val context = ApplicationProvider.getApplicationContext<Context>()
            val temp = File(context.filesDir, "/siticard.apk")

            temp.writeBytes(apk.readBytes())
            println("absolutePath: " + temp.absolutePath)

            device.uiDevice.executeShellCommand("pm clear $PACKAGE")
            val result =
                device.uiDevice.executeShellCommand("pm install -t -r " + temp.absolutePath)
            println("Installation result: $result")

            Thread.sleep(1000)
            device.apps.launch(PACKAGE)
            device.uiDevice.waitForIdle()
            Thread.sleep(3000)
        }.after {
            device.apps.kill(PACKAGE)
        }.run {
            MainScreen2 {
                search_text {
                    isDisplayed()
                }

                step("Check menu elements visibility") {
                    getMenuItemByTitle("Pokedex").isDisplayed()
                    getMenuItemByTitle("Moves").isDisplayed()
                    getMenuItemByTitle("Abilities").isDisplayed()
                    getMenuItemByTitle("Items").isDisplayed()
                    getMenuItemByTitle("Locations").isDisplayed()
                    getMenuItemByTitle("Type Charts").isDisplayed()
                }

                step("Check news elements visibility") {
                    getMenuItemByTitle("Pokémon Rumble Rush Arrives Soon").isDisplayed()
                    getNewsItem(1).isDisplayed()
                }
            }
        }
    }
}