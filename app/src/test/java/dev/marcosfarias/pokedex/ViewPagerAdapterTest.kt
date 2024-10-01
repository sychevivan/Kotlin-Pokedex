package dev.marcosfarias.pokedex

import android.content.Context
import androidx.fragment.app.FragmentManager
import dev.marcosfarias.pokedex.ui.dashboard.ViewPagerAdapter
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ViewPagerAdapterTest {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val mockFragmentManager: FragmentManager = mockk(relaxed = true)
    private val mockContext: Context = mockk(relaxed = true)
    private val pokemonId = "1"

    @Before
    fun setUp() {
        every { mockContext.getString(R.string.dashboard_tab_1) } returns "About"
        every { mockContext.getString(R.string.dashboard_tab_2) } returns "Stats"
        every { mockContext.getString(R.string.dashboard_tab_3) } returns "Evolution"
        every { mockContext.getString(R.string.dashboard_tab_4) } returns "Moves"
        viewPagerAdapter = ViewPagerAdapter(mockFragmentManager, mockContext, pokemonId)
    }

    @Test
    fun `getCount should return correct page count`() {
        assertEquals(4, viewPagerAdapter.count)
    }

    @Test
    fun `getPageTitle should return correct title`() {
        assertEquals("About", viewPagerAdapter.getPageTitle(0).toString())
        assertEquals("Stats", viewPagerAdapter.getPageTitle(1).toString())
        assertEquals("Evolution", viewPagerAdapter.getPageTitle(2).toString())
        assertEquals("Moves", viewPagerAdapter.getPageTitle(3).toString())
    }
}